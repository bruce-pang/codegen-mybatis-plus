package com.brucepang.datasource.core.enums;

/**
 * Corresponds to different data source configurations in multiple data sources
 *
 * ByMethod，using {@link com.baomidou.dynamic.datasource.annotation.DS} annotation, set the data source to use.
 * Careful，the default database source is {@link #MASTER}
 *
 * the corresponding official documents are http://dynamic-datasource.com/guide/customize/Annotation.html
 */
public interface DataSourceEnum {

    /**
     * Master DataBase. Recommend using  {@link com.baomidou.dynamic.datasource.annotation.Master} annotation
     */
    String MASTER = "master";
    /**
     * Slave DataBase. Recommend using {@link com.baomidou.dynamic.datasource.annotation.Slave} annotation
     */
    String SLAVE = "slave";

}
