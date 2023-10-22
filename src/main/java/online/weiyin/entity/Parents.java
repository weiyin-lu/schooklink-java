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
@TableName("parents")
@ApiModel(value = "Parents对象", description = "")
public class Parents implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据角度唯一性ID")
    @TableId(value = "parents_id", type = IdType.AUTO)
    private Integer parentsId;

    @ApiModelProperty("家长编号，业务角度唯一性ID")
    @TableField("parent_unique_id")
    private String parentUniqueId;

    @ApiModelProperty("家长姓名")
    @TableField("parent_name")
    private String parentName;

    @ApiModelProperty("家长性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("家长联系邮箱")
    @TableField("contact_email")
    private String contactEmail;

    @ApiModelProperty("家长联系电话")
    @TableField("contact_phone")
    private String contactPhone;

    @ApiModelProperty("逻辑删除标识")
    @TableField("is_delete")
    private Integer isDelete;


}
