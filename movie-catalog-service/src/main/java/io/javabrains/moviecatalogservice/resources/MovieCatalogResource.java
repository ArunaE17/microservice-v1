package io.javabrains.moviecatalogservice.resources;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import io.javabrains.moviecatalogservice.models.*;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;
//scb
//private static final String ServiceMovieCatalog="ServiceMovieCatalog";
//ecb
//booktickets cb

    @Autowired
    private Tickets tickets;

    @GetMapping
    @RequestMapping("/booktickets")
    public book getticketdetails(){
        book b = new book();
        String name = tickets.callTickets();
        b.setStatus(name);
        return b;

   }
  //booktickets cb


    @RequestMapping("/{userId}")
    //scb
   // @CircuitBreaker(name=ServiceMovieCatalog,fallbackMethod="getCatalogFallback")
    //ecb

    public List<CatalogItem> getCatalog(@PathVariable ("userId") String userId){

        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+ userId, UserRating.class);
        return  ratings.getUserRating().stream().map(rating -> {

            //For each movie ID, call movie info service and get details
            //return new CatalogItem(movie.getName(), "Test", rating.getRating());
            //external api

        Movie movie =  restTemplate.getForObject( "http://localhost:8082/movies/"+ rating.getMovieId(), Movie.class);
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());




        })
         .collect(Collectors.toList());

      /*  //scb
        public List<CatalogItem> getCatalogFallback(@PathVariable ("userId")String userId,Exception e){
        List a = new ArrayList();
        a.add(new CatalogItem("none","None",0));
        return a;
        }

        //ecb


*/

    }



}
 /* Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/"+ rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

*/