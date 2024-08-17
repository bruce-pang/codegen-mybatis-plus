package com.brucepang.common.exception.enums;

import com.brucepang.common.exception.ErrorCode;

/**
 * Global error code constants
 * @author BrucePang
 */
public interface GlobalErrorCodeConstants {
    ErrorCode SUCCESS = new ErrorCode(0, "Success");

    // ===== Client Error =====
    ErrorCode BAD_REQUEST = new ErrorCode(400, "the request parameters are incorrect");
    ErrorCode UNAUTHORIZED = new ErrorCode(401, "The account is not logged in");
    ErrorCode FORBIDDEN = new ErrorCode(403, "You do not have this permission");
    ErrorCode NOT_FOUND = new ErrorCode(404, "The request was not found");
    ErrorCode METHOD_NOT_ALLOWED = new ErrorCode(405, "The request method is incorrect");
    ErrorCode LOCKED = new ErrorCode(423, "The request failed, please try again later"); // 并发请求，不允许
    ErrorCode TOO_MANY_REQUESTS = new ErrorCode(429, "The request is too frequent, please try again later");

    // ==== Server Error ====
    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500, "The system is abnormal");

    // ==== Custom Error ====

}
