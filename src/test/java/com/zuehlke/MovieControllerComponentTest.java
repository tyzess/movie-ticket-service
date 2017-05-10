package com.zuehlke;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by urzy on 10.05.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerComponentTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void getMovies() throws Exception {
        when().
                get("api/v1/movies").

                then().
                statusCode(200).
                body(
                        "get(0).id", equalTo(1),
                        "get(1).id", equalTo(2),
                        "get(2).id", equalTo(3),
                        "get(0).name", equalTo("Batman Begins"),
                        "get(1).name", equalTo("Ted"),
                        "get(2).name", equalTo("Inception"),
                        "get(0).poster", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg"),
                        "get(1).poster", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1OTU0ODcxMV5BMl5BanBnXkFtZTcwOTMxNTUwOA@@._V1_SX300.jpg"),
                        "get(2).poster", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg"));

    }

    @Test
    public void getMovieById() throws Exception {
        when().
                get("api/v1/movie?id={id}", 1).

        then().
                statusCode(200).
                body("id", equalTo(1),
                        "name", equalTo("Batman Begins"),
                        "poster", equalTo("https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg"));

    }

}