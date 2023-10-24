package online.weiyin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
 * @since 2023-10-24
 */
@Getter
@Setter
@TableName("notices")
@ApiModel(value = "Notices对象", description = "")
public class Notices implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据角度唯一性id")
    @TableId(value = "notice_id", type = IdType.AUTO)
    private Integer noticeId;

    @ApiModelProperty("通知创建人id")
    @TableField("created_id")
    private String createdId;

    @ApiModelProperty("通知创建时间")
    @TableField("create_dt")
    private LocalDateTime createDt;

    @ApiModelProperty("通知类型编码")
    @TableField("notice_type")
    private String noticeType;

    @ApiModelProperty("通知目标，可能是班级、个人")
    @TableField("notice_target")
    private String noticeTarget;

    @ApiModelProperty("通知内容")
    @TableField("information")
    private String information;


}
