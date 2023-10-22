package online.weiyin.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TeacherInfo
 * @Description 教师常规信息dto
 * @Version 1.0.0
 * @Time 2023/10/22 下午 08:29
 * @Author 卢子昂
 */
@Data
@ApiModel(value = "教师常规信息dto", description = "")
public class TeacherInfo {
    @ApiModelProperty("工号，业务角度唯一性ID")
    private String teacherUniqueId;

    @ApiModelProperty("教师性别编码")
    private String gender;

    @ApiModelProperty("教师联系邮箱")
    private String contactEmail;

    @ApiModelProperty("教师联系电话")
    private String contactPhone;
}
