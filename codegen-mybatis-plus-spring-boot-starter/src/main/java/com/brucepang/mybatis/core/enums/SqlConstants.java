package com.brucepang.mybatis.core.enums;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * SQL-related constant class
 *
 * @author YunaiV
 */
public class SqlConstants {

    /**
     * Database type
     */
    public static DbType DB_TYPE;

    public static void init(DbType dbType) {
        DB_TYPE = dbType;
    }

}
