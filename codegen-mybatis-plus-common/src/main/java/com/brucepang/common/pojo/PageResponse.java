package com.brucepang.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Pagination response
 * @author BrucePang
 */
@Schema(description="Pagination response")
@Data
public class PageResponse<T> implements Serializable {

    @Schema(description = "data", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<T> list;

    @Schema(description = "total", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long total;

    public PageResponse() {
    }

    public PageResponse(List<T> list, Long total) {
        this.list = list;
        this.total = total;
    }

    public PageResponse(Long total) {
        this.list = new ArrayList<>();
        this.total = total;
    }

    public static <T> PageResponse<T> empty() {
        return new PageResponse<>(0L);
    }

    public static <T> PageResponse<T> empty(Long total) {
        return new PageResponse<>(total);
    }
}
