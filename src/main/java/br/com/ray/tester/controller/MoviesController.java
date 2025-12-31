package br.com.ray.tester.controller;

import br.com.ray.tester.service.MoviesService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping(value = "/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getMovieByTitle(@PathVariable String title) {

        String json = moviesService.getMovieNameByTitleAsJson(title);
        if(json != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(json);
        }
        return ResponseEntity.notFound().build();
    }
}
