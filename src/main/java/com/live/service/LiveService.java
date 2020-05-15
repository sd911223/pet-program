package com.live.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.live.common.RestResponse;

/**
 * @author shitou
 */
public interface LiveService {
    RestResponse getLiveList(Integer page, Integer store_id,String token) throws JsonProcessingException;
}
