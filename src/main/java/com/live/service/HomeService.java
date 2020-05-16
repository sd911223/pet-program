package com.live.service;

import com.live.common.RestResponse;

/**
 * @author shitou
 */
public interface HomeService {
    RestResponse indexMap(String hotProduct, String recommendProduct, String goodProduct, String newProduct, String storeId, String type);
}
