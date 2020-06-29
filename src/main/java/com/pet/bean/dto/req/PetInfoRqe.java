package com.pet.bean.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author dun.shi
 */
@ApiModel("宠物信息")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetInfoRqe {
    /**
     * 宠物图片
     */
    @ApiModelProperty(value = "宠物图片", required = true)
    @NotBlank(message = "宠物图片不能为空")
    private String petPhoto;

    /**
     * 宠物名
     */
    @ApiModelProperty(value = "宠物名", required = true, example = "狗蛋")
    @NotBlank(message = "宠物名不能为空")
    private String petName;

    /**
     * 1:公;2:母
     */
    @ApiModelProperty(value = "1:公;2:母", required = true, example = "1")
    private Integer petSex;

    /**
     * 品种编码
     */
    @ApiModelProperty(value = "品种编码", required = true, example = "1")
    private Integer varietyCode;

    /**
     * 宠物生日
     */
    @ApiModelProperty(value = "宠物生日", example = "2010-10-01")
    private Date petBirthday;

    /**
     * 宠物毛色
     */
    @ApiModelProperty(value = "宠物毛色", example = "黑色")
    private String coatColor;

    /**
     * 1:大于35cm;2小于35cm
     */
    @ApiModelProperty(value = "1:大于35cm;2小于35cm", example = "2")
    private Integer shoulderHeight;

    /**
     * 是否打疫苗
     */
    @ApiModelProperty(value = "是否打疫苗0:未打;1:已")
    private Integer isVaccine;

    /**
     * 是否绝育
     */
    @ApiModelProperty(value = "是否绝育0:未;1:已")
    private Integer isSterilization;
}
