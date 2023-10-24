package online.weiyin.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName NoticeDTO
 * @Description 通知消息dto
 * @Version 1.0.0
 * @Time 2023/10/24 上午 11:03
 * @Author 卢子昂
 */
@Data
@ApiModel(value = "通知消息dto", description = "")
public class NoticeDTO {

    @ApiModelProperty("通知类型编码")
    private String noticeType;

    @ApiModelProperty("通知目标，可能是班级、个人")
    private String noticeTarget;

    @ApiModelProperty("通知内容")
    private String information;
}
