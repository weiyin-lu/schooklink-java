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
@TableName("teachers")
@ApiModel(value = "Teachers对象", description = "")
public class Teachers implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据角度唯一性ID")
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("工号，业务角度唯一性ID")
    @TableField("teacher_unique_id")
    private String uniqueId;

    @ApiModelProperty("教师姓名")
    @TableField("teacher_name")
    private String name;

    @ApiModelProperty("教师性别编码")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("教师联系邮箱")
    @TableField("contact_email")
    private String contactEmail;

    @ApiModelProperty("教师联系电话")
    @TableField("contact_phone")
    private String contactPhone;

    @ApiModelProperty("所在班级编码")
    @TableField("grade")
    private String grade;

    @ApiModelProperty("逻辑删除标识")
    @TableField("is_delete")
    private Integer isDelete;

}
