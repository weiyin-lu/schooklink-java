package online.weiyin.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName ParentInfo
 * @Description 家长常规信息dto
 * @Version 1.0.0
 * @Time 2023/10/22 下午 08:42
 * @Author 卢子昂
 */
@Data
@ApiModel(value = "家长常规信息dto", description = "")
public class ParentInfo {
    @ApiModelProperty("家长编号，业务角度唯一性ID")
    private String parentUniqueId;

    @ApiModelProperty("家长性别")
    private String gender;

    @ApiModelProperty("家长联系邮箱")
    private String contactEmail;

    @ApiModelProperty("家长联系电话")
    private String contactPhone;
}
