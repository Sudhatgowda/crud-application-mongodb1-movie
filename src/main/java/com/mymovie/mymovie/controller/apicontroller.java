package com.mymovie.mymovie.controller;


import com.mymovie.mymovie.model.movie;
import com.mymovie.mymovie.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class apicontroller {

        @Autowired
        private MovieRepo movieRepo;

        @GetMapping(value = "/movie")
        public List<movie> getmovies(){
                return movieRepo.findAll();
        }

        @PostMapping(value = "/saved")
        public String savemovie (@RequestBody movie movie){
                movieRepo.save(movie);
                return "Your Data is Saved....";
        }

        @PutMapping(value = "/update/{id}")
        public String updatemovie(@PathVariable Long id, @RequestBody movie movie){
                movie updatedmovie=movieRepo.findById(id).get();
                updatedmovie.setMoviename((movie.getMoviename()));
                updatedmovie.setTime((movie.getTime()));
                updatedmovie.setLocation((movie.getLocation()));
                updatedmovie.setTheatre((movie.getTheatre()));
                movieRepo.save(updatedmovie);
                return "Data Has Been Updated.....";

        }

        @DeleteMapping(value = "/delete/{id}")
        public String deletemovie(@PathVariable Long id){
                movie deletemovie=movieRepo.findById(id).get();
                movieRepo.delete(deletemovie);
                return "The ID u have selected, its deleted";
        }
}
