package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.models.Movie;
import io.javabrains.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

  /*  @Value("${api.key}")
    private String apiKey;

   */

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId")String movieId){
       /* MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/550?api_key=91c96884c6758198c238f2b65d36bdba" + movieId + "?api_key=" +  apiKey, MovieSummary.class);
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
  */
        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId +"?api_key=91c96884c6758198c238f2b65d36bdba" , MovieSummary.class);
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

        //return new Movie(movieId,"Test name");
    }
}
