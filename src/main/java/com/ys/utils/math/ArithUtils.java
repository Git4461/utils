package com.ys.utils.math;

import java.math.BigDecimal;

/**
 * 高精度计算类
 * 
 * @author 余帅 2017-07-21
 *
 */
public class ArithUtils {
	/**
	 * 默认保留小数点后10位
	 */
	private static final int DEF_DIV_SCALE = 10;

	/**
	 * 私有构造方法
	 */
	private ArithUtils() {
	}

	/**
	 * 相加
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double add(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.add(b2).doubleValue();

	}

	/**
	 * 相减
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double sub(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.subtract(b2).doubleValue();

	}

	/**
	 * 相乘
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double mul(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.multiply(b2).doubleValue();

	}

	/**
	 * 相除
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double div(double d1, double d2) {

		return div(d1, d2, DEF_DIV_SCALE);

	}

	/**
	 * 相除(指定保留小数点后位数)
	 * 
	 * @param d1
	 * @param d2
	 * @param scale
	 *            保留小数点后位数
	 * @return
	 */
	public static double div(double d1, double d2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}