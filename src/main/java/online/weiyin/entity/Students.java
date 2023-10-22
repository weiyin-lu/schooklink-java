package online.weiyin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@Getter
@Setter
@TableName("students")
@ApiModel(value = "Students对象", description = "")
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据角度唯一性ID")
    @TableId(value = "student_id", type = IdType.AUTO)
    private Integer studentId;

    @ApiModelProperty("学号，业务角度唯一性ID")
    @TableField("student_unique_id")
    private String studentUniqueId;

    @ApiModelProperty("学生姓名")
    @TableField("student_name")
    private String studentName;

    @ApiModelProperty("学生生日")
    @TableField("birthdate")
    private String birthdate;

    @ApiModelProperty("学生邮箱")
    @TableField("contact_email")
    private String contactEmail;

    @ApiModelProperty("学生手机号")
    @TableField("contact_phone")
    private String contactPhone;

    @ApiModelProperty("学生性别编码")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("负责家长业务唯一性ID")
    @TableField("parents")
    private String parents;

    @ApiModelProperty("所在班级编码")
    @TableField("grade")
    private String grade;

    @ApiModelProperty("逻辑删除标识")
    @TableField("is_delete")
    private Integer isDelete;


}
