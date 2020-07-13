package com.pet.bean.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportReq {
    /**
     * 经度
     */
    @NotBlank(message = "经度不能为空")
    private String longitude;
    /**
     * 纬度
     */
    @NotBlank(message = "纬度不能为空")
    private String latitude;
    /**
     * 手机号
     */
    private String mobile;
}
