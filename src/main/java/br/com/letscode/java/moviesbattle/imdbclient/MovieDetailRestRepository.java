package br.com.letscode.java.moviesbattle.imdbclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "movieDetailRest",
    url = "http://www.omdbapi.com/?apikey=a4406f28")
public interface MovieDetailRestRepository {

    @GetMapping
    MovieDetail detail(@RequestParam("i") String imdbId);

}
