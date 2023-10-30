package online.weiyin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName PersonInfo
 * @Description 个人信息dto
 * @Version 1.0.0
 * @Time 2023/10/30 下午 07:38
 * @Author 卢子昂
 */
@Data
@ApiModel(value = "个人信息修改dto", description = "")
public class PersonInfo {

    @ApiModelProperty("邮箱")
    private String contactEmail;

    @ApiModelProperty("手机号")
    private String contactPhone;

    @ApiModelProperty("性别编码")
    private String gender;
}
