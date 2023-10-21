package online.weiyin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName LoginDTO
 * @Description 登录dto
 * @Version 1.0.0
 * @Time 2023/10/15 下午 01:25
 * @Author 卢子昂
 */
@ApiModel(value = "登录DTO", description = "用于登录")
@Data
public class LoginDTO {
    @ApiModelProperty("账号（业务角度唯一性id）")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}
