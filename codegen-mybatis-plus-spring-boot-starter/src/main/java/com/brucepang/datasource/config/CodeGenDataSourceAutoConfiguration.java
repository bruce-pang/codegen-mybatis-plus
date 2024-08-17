package com.brucepang.datasource.config;

import com.brucepang.datasource.core.filter.DruidAdRemoveFilter;
import com.alibaba.druid.spring.boot3.autoconfigure.properties.DruidStatProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Database configuration class
 *
 * @author YunaiV
 */
@AutoConfiguration
@EnableTransactionManagement(proxyTargetClass = true) // Start transaction management
@EnableConfigurationProperties(DruidStatProperties.class)
public class CodeGenDataSourceAutoConfiguration {

    /**
     * Create DruidAdRemoveFilter, filter the advertising of common.js
     */
    @Bean
    @ConditionalOnProperty(name = "spring.datasource.druid.stat-view-servlet.enabled", havingValue = "true")
    public FilterRegistrationBean<DruidAdRemoveFilter> druidAdRemoveFilterFilter(DruidStatProperties properties) {
        // Get the parameters of the Druid web monitoring page
        DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
        // Extract the configuration path of common.js
        String pattern = config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*";
        String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");
        // Create DruidAdRemoveFilter Bean
        FilterRegistrationBean<DruidAdRemoveFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new DruidAdRemoveFilter());
        registrationBean.addUrlPatterns(commonJsPattern);
        return registrationBean;
    }

}
