
package com.seba.movies.repositories;

import com.seba.movies.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;




public interface MovieRepository  extends JpaRepository<Movie, Long> {
    
}
