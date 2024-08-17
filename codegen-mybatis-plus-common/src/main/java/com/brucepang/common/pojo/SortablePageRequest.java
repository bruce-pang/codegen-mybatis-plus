package com.brucepang.common.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;


@Schema(description = "Sortable pagination parameters")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SortablePageRequest extends PageRequest{
    @Schema(description = "排序字段")
    private List<SortingField> sortingFields;
}
