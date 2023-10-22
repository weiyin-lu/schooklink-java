package online.weiyin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName RegisterDTO
 * @Description 注册dto
 * @Version 1.0.0
 * @Time 2023/10/15 下午 03:55
 * @Author 卢子昂
 */
@Data
@ApiModel(value = "注册DTO", description = "用于注册用户，包含用户和角色两张表的不同字段")
public class RegisterDTO {
    @ApiModelProperty("账号角色")
    private String userType;
    @ApiModelProperty("账号，业务角度唯一性id")
    private String username;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("手机号（可能为空）")
    private String phone;
    @ApiModelProperty("班级（代码中包含默认值）")
    private String grade;
    @ApiModelProperty("性别（代码中包含默认值）")
    private String gender;

}
