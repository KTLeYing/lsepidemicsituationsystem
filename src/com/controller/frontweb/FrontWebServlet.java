package com.controller.frontweb;

import com.dao.FrontWebDao;
import com.entity.News;
import com.entity.WebStu;
import com.entity.WebTea;
import com.utils.ChartUtils;
import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleEdge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@WebServlet("/FrontWebServlet")
public class FrontWebServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String sql = null;

        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        HttpSession session = req.getSession();

        String str = "是";
        Object[] objects = {str};
        //计算学生已经打卡
        sql = "select count(*) as num from stupunchin where sispunch = ?";
        int stuPunNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(stuPunNum);
        //计算教师已经打卡
        sql = "select count(*) as num from teapunchin where tispunch = ?";
        int teaPunNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(teaPunNum);
        //总打卡数
        int allPunNum = teaPunNum + stuPunNum;
        System.out.println(allPunNum);
        //设置请求的变量属性
        req.setAttribute("allPunNum", allPunNum);

        //计算学生发烧
        sql = "select count(*) as num from stupunchin where sishot = ?";
        int stuHotNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(stuHotNum);
        //计算教师发烧
        sql = "select count(*) as num from teapunchin where tishot = ?";
        int teaHotNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(teaHotNum);
        //总发烧
        int allHotNum = teaHotNum + stuHotNum;
        System.out.println(allHotNum);
        hashMap.put("发烧", allHotNum);
        //设置请求的变量属性
        req.setAttribute("allHotNum", allHotNum);

        //计算学生咳嗽
        sql = "select count(*) as num from stupunchin where siscough = ?";
        int stuCoughNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(stuCoughNum);
        //计算教师咳嗽
        sql = "select count(*) as num from teapunchin where tiscough = ?";
        int teaCoughNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(teaCoughNum);
        //总咳嗽
        int allCoughNum = teaCoughNum + stuCoughNum;
        System.out.println(allCoughNum);
        hashMap.put("咳嗽", allCoughNum);
        //设置请求的变量属性
        req.setAttribute("allCoughNum", allCoughNum);

        //计算学生疑似病例
        sql = "select count(*) as num from stupunchin where sisseem = ?";
        int stuSeemNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(stuSeemNum);
        //计算教师疑似病例
        sql = "select count(*) as num from teapunchin where tisseem = ?";
        int teaSeemNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(teaSeemNum);
        //总疑似病例
        int allSeemNum = stuSeemNum + teaSeemNum;
        System.out.println(allSeemNum);
        hashMap.put("疑似病例", allSeemNum);
        //设置请求的变量属性
        req.setAttribute("allSeemNum", allSeemNum);

        //计算学生确诊病例
        sql = "select count(*) as num from stupunchin where sisdiagnose = ?";
        int stuDiagNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(stuDiagNum);
        //计算教师确诊病例
        sql = "select count(*) as num from teapunchin where tisdiagnose = ?";
        int teaDiagNum = FrontWebDao.findTotalCount(sql, objects);
        System.out.println(teaDiagNum);
        //总确诊病例
        int allDiagNum = stuDiagNum + teaDiagNum;
        System.out.println(allDiagNum);
        hashMap.put("确诊病例", allDiagNum);
        //设置请求的变量属性
        req.setAttribute("allDiagNum", allDiagNum);

        //计算学生异常
        str = "异常";
        Object[] objects1 = {str};
        sql = "select count(*) as num from stupunchin where sstatus = ?";
        int sStatusNum = FrontWebDao.findTotalCount(sql, objects1);
        System.out.println(sStatusNum);
        //计算教师异常
        sql = "select count(*) as num from teapunchin where tstatus = ?";
        int tStatusNum = FrontWebDao.findTotalCount(sql, objects1);
        System.out.println(tStatusNum);
        //总异常
        int allStatusNum = tStatusNum + sStatusNum;
        System.out.println(allStatusNum);
        hashMap.put("健康异常", allStatusNum);
        //设置请求的变量属性
        req.setAttribute("allStatusNum", allStatusNum);

        //计算状态正常
        int normalNum = allPunNum - allStatusNum;
        System.out.println(normalNum);
        hashMap.put("健康正常", normalNum);


        //创建饼状图
        //实例化核心类对象
        DefaultPieDataset dataset = new DefaultPieDataset();

        //法2：用iterator遍历key
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            dataset.setValue(key, (Number) hashMap.get(key));
            System.out.println(key+ ":" + (Number) hashMap.get(key));
        }

        //创建饼状图
        JFreeChart chart = ChartFactory.createPieChart3D("各情况占比分析", dataset, true, true, true);
        //无背景色
        chart.setBackgroundPaint(null);

        /*//处理主标题的乱码
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,18));
        //处理子标题乱码
        chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));
        //获取图表区域对象
        PiePlot3D categoryPlot = (PiePlot3D)chart.getPlot();
        //设置背景透明度
        categoryPlot.setBackgroundAlpha(0);
        //设置饼图透明度
        categoryPlot.setForegroundAlpha(0.7f);
        // 去除背景边框线
        categoryPlot.setOutlinePaint(null);
        //处理图像上的乱码
        categoryPlot.setLabelFont(new Font("宋体",Font.BOLD,15));
        //设置图形的生成格式为（张三  23 （10%））（姓名 值 百分比）
        String fm = "{0} {1} ({2})";
        categoryPlot.setLabelGenerator(new StandardPieSectionLabelGenerator(fm));*/

        // 设置抗锯齿，防止字体显示不清楚
        ChartUtils.setAntiAlias(chart);// 抗锯齿
        // 对柱子进行渲染[创建不同图形]
        ChartUtils.setPieRender(chart.getPlot());
        // plot.setSimpleLabels(true);//简单标签,不绘制线条
        // plot.setLabelGenerator(null);//不显示数字
        // 设置标注无边框
        chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
        // 标注位于右侧
        chart.getLegend().setPosition(RectangleEdge.RIGHT);

        String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, null, session);
        String graphUrl = req.getContextPath() + "/DisplayChart?filename=" + filename;
        req.setAttribute("graphUrl", graphUrl);



        //创建柱形图
        //实例化核心类对象
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        //设置图表值
        dataset1.addValue(stuHotNum, "学生", "发烧");
        dataset1.addValue(teaHotNum, "教师", "发烧");
        dataset1.addValue(stuCoughNum, "学生", "咳嗽");
        dataset1.addValue(teaCoughNum, "教师", "咳嗽");
        dataset1.addValue(stuSeemNum, "学生", "疑似病例");
        dataset1.addValue(teaSeemNum, "教师", "疑似病例");
        dataset1.addValue(stuDiagNum, "学生", "确诊病例");
        dataset1.addValue(teaDiagNum, "教师", "确诊病例");
        dataset1.addValue(sStatusNum, "学生", "健康异常");
        dataset1.addValue(tStatusNum, "教师", "健康异常");

        //生成柱形图
        JFreeChart chart1 = ChartFactory.createBarChart("学生和教师情况统计", // 图表标题
                null, // x轴的显示标签
                "个体数目", // y轴的显示标签
                dataset1, // 数据
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true, // 显示图例
                true, // 生成工具
                true // URL链接
        );

        // 对整个图形设置整个柱状图的颜色和文字针
       /* chart1.setBackgroundPaint(null);
//        chart.setBackgroundPaint(ChartColor.WHITE); // 设置总的背景颜色
        // 获得图形对象，并通过此对象对图形的颜色文字进行设置
        CategoryPlot polt = chart1.getCategoryPlot();// 获得图表对象
        polt.setBackgroundPaint(ChartColor.lightGray);// 图形背景颜色
        polt.setRangeGridlinePaint(ChartColor.WHITE);// 图形表格颜色
        // 设置柱宽度
        BarRenderer renderer = (BarRenderer) polt.getRenderer();
        renderer.setMaximumBarWidth(0.06);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));

        // 图形设置标题文字
        TextTitle textTitle = chart1.getTitle();
        textTitle.setFont(new Font("宋体", Font.BOLD, 20));

        // 设置图形X轴坐标文字
        CategoryPlot plot = (CategoryPlot) chart1.getPlot();
        CategoryAxis axis = plot.getDomainAxis();
        axis.setLabelFont(new Font("宋体", Font.BOLD, 22)); // 设置X轴坐标上标题的文字
        axis.setTickLabelFont(new Font("宋体", Font.BOLD, 15)); // 设置X轴坐标上的文字

        // 设置图形Y轴坐标文字
        ValueAxis valueAxis = plot.getRangeAxis();
        valueAxis.setLabelFont(new Font("宋体", Font.BOLD, 12)); // 设置Y轴坐标上标题的文字
        valueAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));// 设置Y轴坐标上的文字
        // 设置提示内容的文字
        chart1.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));*/


        // 设置抗锯齿，防止字体显示不清楚
        ChartUtils.setAntiAlias(chart1);// 抗锯齿
        // 对柱子进行渲染
        ChartUtils.setBarRenderer(chart1.getCategoryPlot(), false);//
        // 对其他部分进行渲染
        ChartUtils.setXAixs(chart1.getCategoryPlot());// X坐标轴渲染
        ChartUtils.setYAixs(chart1.getCategoryPlot());// Y坐标轴渲染
        // 设置标注无边框
        chart1.getLegend().setFrame(new BlockBorder(Color.WHITE));
        //无背景色
        chart1.setBackgroundPaint(null);

        String filename1 = ServletUtilities.saveChartAsPNG(chart1, 500, 300, null, session);
        String graphUrl1 = req.getContextPath() + "/DisplayChart?filename=" + filename1;
        req.setAttribute("graphUrl1", graphUrl1);



        String[] depts = {"马克思主义学院", "文学与传媒学院", "法政学院", "外国语学院", "教育科学学院", "信息工程学院", "数学与统计学院",
                "物理科学与技术学院", "机电工程学院", "化学化工学院", "生命与科学学院", "商学院", "体育科学学院", "美术与设计学院",
                "音乐与舞蹈学院", "创新创业教育学院", "教师教育学院", "基础教育学院"};

        //学生表格处理
        ArrayList<WebStu> webStuArrayList = new ArrayList<WebStu>();
        System.out.println(depts.length);
        for (int i = 0; i < depts.length; i++) {
            WebStu webStu = new WebStu();
            String dept = depts[i];
            webStu.setSdept(dept);
            sql = "select count(*) as num from student s, stupunchin sp where s.sno = sp.sno and s.sdept= ? and sp.sishot = ?";
            Object[] obj2 = {dept, "是"};
            int tbStuHotNum = FrontWebDao.findTotalCount(sql, obj2);
            webStu.setSishotNum(tbStuHotNum);
            sql = "select count(*) as num from student s, stupunchin sp where s.sno = sp.sno and s.sdept= ? and sp.siscough = ?";
            int tbStuCoughNum = FrontWebDao.findTotalCount(sql, obj2);
            webStu.setSiscoughNum(tbStuCoughNum);
            sql = "select count(*) as num from student s, stupunchin sp where s.sno = sp.sno and s.sdept= ? and sp.sisseem = ?";
            int tbStuSeemNum = FrontWebDao.findTotalCount(sql, obj2);
            webStu.setSisseemNum(tbStuSeemNum);
            sql = "select count(*) as num from student s, stupunchin sp where s.sno = sp.sno and s.sdept= ? and sp.sisdiagnose = ?";
            int tbStuDiagNum = FrontWebDao.findTotalCount(sql, obj2);
            webStu.setSisdiagnoseNum(tbStuDiagNum);
            sql = "select count(*) as num from student s, stupunchin sp where s.sno = sp.sno and s.sdept= ? and sp.sstatus = ?";
            Object[] obj3 = {dept, "异常"};
            int tbStuStatusNum = FrontWebDao.findTotalCount(sql, obj3);
            webStu.setSstatusNum(tbStuStatusNum);
            webStuArrayList.add(webStu);
        }
        System.out.println(webStuArrayList);
        req.setAttribute("webStuArrayList", webStuArrayList);

        //教师表格
        ArrayList<WebTea> webTeaArrayList = new ArrayList<WebTea>();
        for (int i = 0; i < depts.length; i++) {
            WebTea webTea = new WebTea();
            String dept = depts[i];
            webTea.setTdept(dept);
            sql = "select count(*) as num from teacher t, teapunchin tp where t.tno = tp.tno and t.tdept= ? and tp.tishot = ?";
            Object[] obj2 = {dept, "是"};
            int tbTeaHotNum = FrontWebDao.findTotalCount(sql, obj2);
            webTea.setTishotNum(tbTeaHotNum);
            sql = "select count(*) as num from teacher t, teapunchin tp where t.tno = tp.tno and t.tdept= ? and tp.tiscough = ?";
            int tbTeaCoughNum = FrontWebDao.findTotalCount(sql, obj2);
            webTea.setTiscoughNum(tbTeaCoughNum);
            sql = "select count(*) as num from teacher t, teapunchin tp where t.tno = tp.tno and t.tdept= ? and tp.tisseem = ?";
            int tbTeaSeemNum = FrontWebDao.findTotalCount(sql, obj2);
            webTea.setTisseemNum(tbTeaSeemNum);
            sql = "select count(*) as num from teacher t, teapunchin tp where t.tno = tp.tno and t.tdept= ? and tp.tisdiagnose = ?";
            int tbTeaDiagNum = FrontWebDao.findTotalCount(sql, obj2);
            webTea.setTisdiagnoseNum(tbTeaDiagNum);
            sql = "select count(*) as num from teacher t, teapunchin tp where t.tno = tp.tno and t.tdept= ? and tp.tstatus = ?";
            Object[] obj3 = {dept, "异常"};
            int tbTeaStatusNum = FrontWebDao.findTotalCount(sql, obj3);
            webTea.setTstatusNum(tbTeaStatusNum);
            webTeaArrayList.add(webTea);
        }
        System.out.println(webTeaArrayList);
        req.setAttribute("webTeaArrayList", webTeaArrayList);


        //实时播报
        sql = "select * from news order by nid desc limit 7";
        Object[] objects2 = {};
        ArrayList<News> newsArrayList = new ArrayList<News>();

        ResultSet resultSet = FrontWebDao.qureyInfo(sql, objects2);
        try {
            while (resultSet.next()){
                News news = new News();
                news.setTitle(resultSet.getString("title"));
                news.setUrl(resultSet.getString("url"));
                news.setPubdate(resultSet.getDate("pubdate"));
                newsArrayList.add(news);
                System.out.println(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(newsArrayList);
        req.setAttribute("newsArrayList", newsArrayList);



        req.getRequestDispatcher("/view/frontweb/mainweb.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
