package com.zuehlke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Created by urzy on 10.05.2017.
 */
public class RatingAdapter {

    private final RatingServiceApiClient ratingsApiClient;

    public RatingAdapter(String url) {
        RatingServiceApiClient fallback = (id) -> {
                return new ArrayList<RatingResponse>();
            };
        ratingsApiClient = RestClientFactory.createClientWithFallback(url, RatingServiceApiClient.class, fallback);

    }

    public List<Rating> getRatingsById(long id) {
        List<RatingResponse> ratingResponses = ratingsApiClient.getRatingsById(id);
        List<Rating> ratings = new ArrayList<Rating>();
        for( RatingResponse ratingResponse : ratingResponses) {
            ratings.add(Rating.from(ratingResponse));
        }
        return ratings;
    }
}
