package com.brucepang.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * SortingField
 *
 * 类The reason for adding ing to the name is to avoid having the same name as ES SortField.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortingField implements Serializable {

    /**
     * Order - asc
     */
    public static final String ORDER_ASC = "asc";
    /**
     * Order - desc
     */
    public static final String ORDER_DESC = "desc";

    /**
     * field
     */
    private String field;
    /**
     * order
     */
    private String order;

}
