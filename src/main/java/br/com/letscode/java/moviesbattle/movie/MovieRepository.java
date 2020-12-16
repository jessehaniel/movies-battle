package br.com.letscode.java.moviesbattle.movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

    Optional<Movie> findMovieByImdbId(String imdbId);

    List<Movie> findMoviesByImdbIdNotIn(List<String> imdbIdList);
}
