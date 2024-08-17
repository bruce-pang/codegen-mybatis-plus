package com.brucepang.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Pagination request parameters
 * @author BrucePang
 */
@Schema(description="Pagination request parameters")
@Data
public class PageRequest {

    private static final Integer PAGE_NO = 1;
    private static final Integer PAGE_SIZE = 10;


    /**
     * Records per page - No pagination
     *
     * For example, export interface，you can set {@link #pageSize} value as -1, it's meaning no pagination, query all data.
     */
    public static final Integer PAGE_SIZE_NONE = -1;

    @Schema(description = "page number, start with 1", requiredMode = Schema.RequiredMode.REQUIRED,example = "1")
    @NotNull(message = "The page number cannot be empty")
    @Min(value = 1, message = "page number min value is 1")
    private Integer pageNo = PAGE_NO;

    @Schema(description = "page size，max value 100", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "page size cannot be empty")
    @Min(value = 1, message = "page size min value is 1")
    @Max(value = 100, message = "page size max value is 100")
    private Integer pageSize = PAGE_SIZE;
}
