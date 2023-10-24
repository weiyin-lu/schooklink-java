package online.weiyin.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName StudentInfo
 * @Description 学生常规信息dto
 * @Version 1.0.0
 * @Time 2023/10/22 下午 08:36
 * @Author 卢子昂
 */
@Data
@ApiModel(value = "学生常规信息dto", description = "")
public class StudentInfo {

    @ApiModelProperty("学生生日")
    private String birthdate;

    @ApiModelProperty("学生邮箱")
    private String contactEmail;

    @ApiModelProperty("学生手机号")
    private String contactPhone;

    @ApiModelProperty("学生性别编码")
    private String gender;
}
