package com.zuehlke;

import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Created by urzy on 10.05.2017.
 */
public interface RatingServiceApiClient {
    @RequestLine("GET /api/v1/ratings/{id}")
    List<RatingResponse> getRatingsById(@Param("id") long id);
}
