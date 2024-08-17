package com.brucepang.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Common response
 * @author BrucePang
 */
@Data
public class CommonResponse<T> implements Serializable {
    /**
     * Error code
     *
     * @see ErrorCode#getCode()
     */
}
