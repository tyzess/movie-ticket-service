package com.zuehlke;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by urzy on 10.05.2017.
 */
// IntegrationTest
public class RatingAdapterIT {

    static {
        System.setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", "5000");
    }

    @Test
    public void getRatingsById() throws Exception {
        RatingAdapter ratingAdapter = new RatingAdapter("https://movie-rating-service.herokuapp.com");

        List<Rating> ratings = ratingAdapter.getRatingsById(1);

        assertThat(ratings, hasSize(3));
        assertThat(ratings, hasItem(new Rating("Internet Movie Database", "8.3/10")));
    }

}
