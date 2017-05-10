package com.zuehlke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by urzy on 10.05.2017.
 */
public class RatingAdapter {

    private final RatingServiceApiClient ratingsApiClient;

    public RatingAdapter(String url) {
        ratingsApiClient = RestClientFactory.createClient(url, RatingServiceApiClient.class);

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
