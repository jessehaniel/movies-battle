package br.com.letscode.java.moviesbattle.movie;

import br.com.letscode.java.moviesbattle.imdbclient.MovieDetail;
import br.com.letscode.java.moviesbattle.imdbclient.MovieDetailRestRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository repository;
    private final MovieDetailRestRepository movieDetailRestRepository;

    public Movie save(Movie movie) {
        final var movieDetail = this.movieDetailRestRepository.detail(movie.getImdbId());
        movie.setRating(movieDetail.getRating());
        movie.setVotes(movieDetail.getVotes());
        return this.repository.save(movie);
    }

    public List<Movie> list() {
        return this.repository.findAll();
    }

    public void delete(String imdbId) {
        this.repository.findMovieByImdbId(imdbId)
            .ifPresent(this.repository::delete);
    }

    public List<Movie> findMoviesByImdbIdNotIn(List<String> imdbIdList) {
        return this.repository.findMoviesByImdbIdNotIn(imdbIdList);
    }
}
