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
        return new Movie(1,"Titanic", "https://www.google.com/favicon");
    }

    @RequestMapping(value = "/api/v1/movies", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(1,"Titanic", "https://www.google.com/favicon"));
        movies.add(new Movie(1,"Titanic", "https://www.google.com/favicon"));
        return movies;
    }
}
