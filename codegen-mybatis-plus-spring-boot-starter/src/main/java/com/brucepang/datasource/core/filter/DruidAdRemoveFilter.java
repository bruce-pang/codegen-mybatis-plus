package com.brucepang.datasource.core.filter;

import com.alibaba.druid.util.Utils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Druid bottom advertising filter
 *
 * @author YunaiV
 */
public class DruidAdRemoveFilter extends OncePerRequestFilter {

    /**
     * path of common.js
     */
    private static final String COMMON_JS_ILE_PATH = "support/http/resources/js/common.js";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        chain.doFilter(request, response);
        // Reset the buffer, The response header is not reset
        response.resetBuffer();
        // get common.js
        String text = Utils.readFromResource(COMMON_JS_ILE_PATH);
        // Regular substitution banner, remove the advertising message at the bottom
        text = text.replaceAll("<a.*?banner\"></a><br/>", "");
        text = text.replaceAll("powered.*?shrek.wang</a>", "");
        response.getWriter().write(text);
    }

}
