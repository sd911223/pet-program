package com.pet.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @ApiModelProperty("临时登录凭证")
    @NotBlank(message = "临时登录凭证不能为空")
    private String code;

    @NotBlank(message = "用户非敏感信息不能为空")
    @ApiModelProperty("用户非敏感信息")
    private String rawData;

    @NotBlank(message = "签名不能为空")
    @ApiModelProperty("签名")
    private String signature;

    @NotBlank(message = "encrypteData不能为空")
    @ApiModelProperty("用户敏感信息")
    private String encrypteData;

    @NotBlank(message = "解密算法的向量不能为空")
    @ApiModelProperty("解密算法的向量")
    private String iv;
}
