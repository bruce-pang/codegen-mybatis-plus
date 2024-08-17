package com.brucepang.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * String Utils
 *
 * using {@link cn.hutool.Hutool} implementation
 * @author BrucePang
 */
public class StrUtils {
    /**
     * Split into integers
     *
     * @param str string
     * @param separator separator string
     * @return List<Integer>
     */
    public static List<Integer> splitToInteger(String str, CharSequence separator) {
        int[] integers = cn.hutool.core.util.StrUtil.splitToInt(str, separator);
        return Arrays.stream(integers).boxed().collect(Collectors.toList());
    }

    /**
     * Split into long
     *
     * @param str string
     * @param separator separator string
     * @return List<Long>
     */
    public static List<Long> splitToLong(String str, CharSequence separator) {
        long[] longs = cn.hutool.core.util.StrUtil.splitToLong(str, separator);
        return Arrays.stream(longs).boxed().collect(Collectors.toList());
    }
}
