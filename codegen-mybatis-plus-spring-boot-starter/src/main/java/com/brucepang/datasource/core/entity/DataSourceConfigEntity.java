package com.brucepang.datasource.core.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.brucepang.mybatis.core.entity.BaseEntity;
import com.brucepang.mybatis.core.type.EncryptTypeHandler;
import lombok.Data;

/**
 * Datasource configuration entity
 *
 * @author YunaiV
 */
@TableName(value = "infra_data_source_config", autoResultMap = true)
@KeySequence("infra_data_source_config_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
public class DataSourceConfigEntity extends BaseEntity {

    /**
     * Primary key number - Master DataSource
     */
    public static final Long ID_MASTER = 0L;

    /**
     * id
     */
    private Long id;
    /**
     * name
     */
    private String name;

    /**
     * Datasource connection url
     */
    private String url;
    /**
     * username
     */
    private String username;
    /**
     * password
     */
    @TableField(typeHandler = EncryptTypeHandler.class)
    private String password;

}
