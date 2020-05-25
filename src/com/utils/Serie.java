package com.utils;

import java.io.Serializable;
import java.util.Vector;

/**
 * 系列:名字和数据集合 构成一条曲线</br> 可以将serie看作一根线或者一根柱子：
 * 
 * <p>
 * 参照JS图表来描述数据：</br> series: [{ name: 'Tokyo', data: [7.0, 6.9, 9.5, 14.5]
 * },</br> { name: 'New York', data: [-0.2, 0.8, 5.7, 11.3} ]</br>
 * </p>
 * 
 * @author ccw
 * @date 2014-6-4
 */
public class Serie implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;// 名字
	private Vector<Object> data;// 数据值

	public Serie() {

	}

	/**
	 * 
	 * @param name
	 *            名称（线条名称）
	 * @param data
	 *            数据（线条上的所有数据值）
	 */
	public Serie(String name, Vector<Object> data) {

		this.name = name;
		this.data = data;
	}

	/**
	 * 
	 * @param name
	 *            名称（线条名称）
	 * @param array
	 *            数据（线条上的所有数据值）
	 */
	public Serie(String name, Object[] array) {
		this.name = name;
		if (array != null) {
			data = new Vector<Object>(array.length);
			for (int i = 0; i < array.length; i++) {
				data.add(array[i]);
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<Object> getData() {
		return data;
	}

	public void setData(Vector<Object> data) {
		this.data = data;
	}

}
