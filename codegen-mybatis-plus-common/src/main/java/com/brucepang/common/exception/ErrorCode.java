package com.brucepang.common.exception;

import com.brucepang.common.exception.enums.GlobalErrorCodeConstants;
import lombok.Data;

/**
 * Error code object
 *
 *  Global error code constants, see {@link GlobalErrorCodeConstants}
 *
 * TODO: why do this, for i18
 */
@Data
public class ErrorCode {

    /**
     * Error code
     */
    private final Integer code;
    /**
     * Error message
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

}
