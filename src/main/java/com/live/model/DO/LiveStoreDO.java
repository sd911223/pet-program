package com.live.model.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class LiveStoreDO {

    private Integer id;

    private String store_name;


    private Integer admin_id;


    private String introduction;


    private String detailed_address;


    private String store_image;


    private String latitude;

    private String longitude;


    private String day_time;


    private Integer type_id;


    private String contact_name;


    private Integer province_id;


    private Integer city_id;


    private Long area_id;


    private String contact_mobile;

    private String parent_no;


    private Integer store_sort;


    private Integer store_status;


    private Integer is_cancellation;


    private Integer create_time;


    private Integer update_time;


    private static final long serialVersionUID = 1L;
}
