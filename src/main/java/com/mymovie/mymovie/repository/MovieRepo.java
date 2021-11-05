package com.mymovie.mymovie.repository;

import com.mymovie.mymovie.model.movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepo extends MongoRepository<movie, Long> {
}
