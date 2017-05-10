package com.zuehlke;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by urzy on 10.05.2017.
 */
@Controller
public class MovieController {

    @RequestMapping(value = "/api/v1/movie", method = RequestMethod.GET)
    @ResponseBody
    public Movie getMovie() {
        return new Movie(1,"Batman Begins", "https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg");
    }

    @RequestMapping(value = "/api/v1/movies", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1,"Batman Begins", "https://images-na.ssl-images-amazon.com/images/M/MV5BNTM3OTc0MzM2OV5BMl5BanBnXkFtZTYwNzUwMTI3._V1_SX300.jpg"));
        movies.add(new Movie(2,"Ted", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1OTU0ODcxMV5BMl5BanBnXkFtZTcwOTMxNTUwOA@@._V1_SX300.jpg"));
        movies.add(new Movie(3,"Inception", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg"));
        return movies;
    }
}