package com.live.model.DTO;

import lombok.Data;

@Data
public class MPWechatAuthDTO {

    private String spread_spid;
    private String spread_code;
    private String iv;
    private String encryptedData;
    private String code;
    private String cache_key;
    private String login_type;
}
