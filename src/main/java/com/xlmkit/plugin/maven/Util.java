package com.xlmkit.plugin.maven;

/**
 * @Author: 蔡小龙
 * @Date: 2021/3/12 14:23
 * @Description: 工具类
 */
public class Util {
    /**
     * 首字母大写
     * @param letter
     * @return
     */
    public static String upperFirstLatter(String letter) {
        char[] chars = letter.toCharArray();

        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 32);
        }
        return new String(chars);
    }
}
