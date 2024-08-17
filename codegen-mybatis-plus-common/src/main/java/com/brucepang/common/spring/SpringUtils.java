package com.brucepang.common.spring;

import cn.hutool.extra.spring.SpringUtil;

import java.util.Objects;

/**
 * Spring Utils
 *
 * @author YunaiV
 */
public class SpringUtils extends SpringUtil {

    public static boolean isProd() {
        String activeProfile = getActiveProfile();
        return Objects.equals("prod", activeProfile);
    }

}
