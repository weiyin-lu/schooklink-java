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
@TableName("dictionary")
@ApiModel(value = "Dictionary对象", description = "")
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("数据角度唯一性ID")
    @TableId(value = "dic_id", type = IdType.AUTO)
    private Integer dicId;

    @ApiModelProperty("字典类型编码")
    @TableField("dic_type")
    private String dicType;

    @ApiModelProperty("字典编码")
    @TableField("dic_key")
    private String dicKey;

    @ApiModelProperty("字典编码值")
    @TableField("dic_value")
    private String dicValue;


}
