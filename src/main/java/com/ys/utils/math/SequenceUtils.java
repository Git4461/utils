package com.ys.utils.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceUtils {
	/**
	 * 对数组排列 A(m,n) m选n的排列
	 * 
	 * @param s
	 *            待排列数组
	 * @param n
	 *            排列个数
	 * 
	 * @return 返回排列集合，逗号分隔
	 */
	public static List<String> permutation(String[] s, int n) {
		if (s == null || n < 1 || n > s.length) {
			throw new IllegalArgumentException("待排列数组：" + s + ",n:" + n);
		}
		List<String> out = new ArrayList<String>();
		List<Integer> exchange = new ArrayList<Integer>();
		permutation(s, "", exchange, n, out);
		return out;
	}

	/**
	 * 对数组组合 C(m,n) m选n的组合
	 * 
	 * @param s
	 *            待组合数组
	 * @param n
	 *            组合个数
	 * @return 返回组合结果集合，逗号分隔
	 */
	public static List<String> combination(String[] s, int n) {
		if (s == null || n < 1 || n > s.length) {
			throw new IllegalArgumentException("待组合数组：" + s + ",n:" + n);
		}
		List<String> out = new ArrayList<String>();
		combination(out, null, s, n);
		return out;
	}

	private static void permutation(String[] strs, String e,
			List<Integer> exchange, int m, List<String> out) {
		if (m == 0) {
			out.add(e);
			return;
		}
		List<Integer> exchange2;
		for (int i = 0; i < strs.length; i++) {
			exchange2 = new ArrayList<Integer>();
			exchange2.addAll(exchange);
			if (!exchange.contains(i)) {
				String str = e + strs[i] + ",";
				exchange2.add(i);
				permutation(strs, str, exchange2, m - 1, out);
			}
		}
	}

	private static void combination(List<String> out, String begin, String[] s,
			int n) {
		if (n > 1) {
			for (int i = 0; i < s.length - n + 1; i++) {
				// 取出一个字符
				String str = s[i];
				// 数组后边的元素组成新数组
				String[] newS = Arrays.copyOfRange(s, i + 1, s.length);
				// 递归，从后面的n-1个数种选出num-1个
				combination(out, begin == null ? str : (begin + "," + str),
						newS, n - 1);
			}
		} else {
			// 如果从剩下的s中选出1个数，那么前缀依次和s中的所有元素组合一次
			for (int b = 0; b < s.length; b++) {
				out.add((begin == null ? "" : begin + ",") + s[b]);
			}

		}

	}
}
