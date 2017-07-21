package com.ys.utils.clazz;

import java.lang.reflect.Field;

/**
 * @author 余帅
 *
 */
public class EnumUtils {

	/**
	 * 获取枚举类的所有字段
	 * 
	 * @param clazz
	 * @return
	 */
	public static String[] getAllField(Class<? extends Enum<?>> clazz) {
		Field[] declaredFields = clazz.getDeclaredFields();
		if (declaredFields == null || declaredFields.length < 2)
			return new String[0];
		String[] s = new String[declaredFields.length - 2];
		for (int i = 0; i < declaredFields.length - 2; i++) {
			s[i] = declaredFields[i].getName();
		}
		return s;
	}
}
