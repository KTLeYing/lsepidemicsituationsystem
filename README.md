# lsepidemicsituationsystem

# 岭师疫情防控管理信息系统

## 项目简介：

岭师疫情防控管理信息系统分为前台部分和后台部分，面向岭南师范学院的学生和老师，旨在为学校提供一个有效防控校园出现疫情的综合性平台。本管理系统将通过健康打卡的功能实现后台管理系统对师生身体状况数据的收集。有了此系统，大大方便了学校疫情的防控工作，加大了学校疫情防控的力度，提高学校疫情防控的效率，尽最大地可能避免学校出现新冠肺炎疫情。借助此系统学校能更好地做好疫情防控措施。


## 采用技术 ： 
- 前端：HTML + CSS + JavaScript + Bootstrap + Jquery + Ajax
- 后端：Spring Boot + Jpa + Maven + Schedule定时任务 + Redis + Security + POI

## 开发环境 ：
- 工具：IDEA、Navicat、Git
- 环境：JDK 1.8、Tomcat 7.0、Mysql 8.0
- 项目管理：Maven
- 代码托管平台：GitHub

## 开发流程：  
1、数据库设计  
2、Model：模型定义，与数据库相匹配  
3、Dao层：数据操作  
4、Service:服务包装  
5、Controller：业务入口，数据交互   
6、Util：工具类封装   
7、Config：配置类封装    
8、单元测试    


## 功能模块 :  

**前台部分，主要分为以下几个模块：**

> 个人信息管理

- 学生和老师登录✔
- 学生和老师修改密码✔

> 数据显示

- 学校疫情各情况数据的统计显示✔
- 疫情各情况饼状图占比分析✔
- 学生和教师各情况统计柱形图显示✔
- 各学院学生的各情况统计表格显示✔
- 各学院教师的各情况统计表格显示✔

> 打卡操作  

- 学生每天打卡✔
- 教师每天打卡✔

> 疫情新闻显示

- 最新疫情新闻播报浏览✔
- 查看疫情新闻详情✔

**后台部分，主要分为以下几个模块：**

> 学生管理

- 查询学生✔
- 添加学生✔
- 修改学生✔
- 删除学生✔

> 教师管理

- 查询教师✔
- 添加教师✔
- 修改教师✔
- 删除教师✔

> 打卡信息管理

- 查询打卡信息✔
- 添加打卡信息✔
- 修改打卡信息✔
- 删除打卡信息✔
- 分析打卡信息✔
- 统计打卡信息✔

> 新闻管理

- 查询新闻✔
- 发布新闻✔
- 删除新闻✔


## 项目截图：

**前台部分展示：**  

1. 前台页面  
![](https://img-blog.csdnimg.cn/20210317205831305.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
![](https://img-blog.csdnimg.cn/2021031720583081.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
![](https://img-blog.csdnimg.cn/20210317205829879.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
![](https://img-blog.csdnimg.cn/20210317205829742.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
![](https://img-blog.csdnimg.cn/20210317205829897.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
![](https://img-blog.csdnimg.cn/20210317205829894.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
2. 登录页面(学生与教师的类似)  
![](https://img-blog.csdnimg.cn/20210317205829941.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
3. 打卡页面(学生与教师的类似)   
![](https://img-blog.csdnimg.cn/2021031720583076.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
4. 个人信息页面(学生与教师的类似)    
![](https://img-blog.csdnimg.cn/20210317205829569.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)

**后台部分展示：**  

1. 后台首页  
![](https://img-blog.csdnimg.cn/20210317205830135.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
2. 学生列表  
![](https://img-blog.csdnimg.cn/20210317205830123.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
3. 教师列表  
![](https://img-blog.csdnimg.cn/2021031720583091.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
4. 学生打卡信息列表  
![](https://img-blog.csdnimg.cn/20210317205830115.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
5. 老师打卡信息列表  
![](https://img-blog.csdnimg.cn/20210317205830110.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)
6. 发布新闻  
![](https://img-blog.csdnimg.cn/20210317205829345.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzU0ODMxMA==,size_16,color_FFFFFF,t_70)


## 项目访问 :  
浏览器访问路径：http://localhost:8080/lsepidemicsituationsystem_war_exploded/FrontWebServlet
