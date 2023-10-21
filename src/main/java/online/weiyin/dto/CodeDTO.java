package online.weiyin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName CodeDTO
 * @Description 插入码表DTO
 * @Version 1.0.0
 * @Time 2023/10/17 下午 06:57
 * @Author 卢子昂
 */
@ApiModel(value = "码表DTO", description = "用于码表数据处理")
@Data
public class CodeDTO {
    @ApiModelProperty("编码类型")
    private String type;
    @ApiModelProperty("字典内编码")
    private String key;
    @ApiModelProperty("字典值")
    private String value;
}
