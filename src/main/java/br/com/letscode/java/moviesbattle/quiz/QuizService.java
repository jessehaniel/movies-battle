package br.com.letscode.java.moviesbattle.quiz;

import br.com.letscode.java.moviesbattle.movie.Movie;
import br.com.letscode.java.moviesbattle.movie.MovieService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizService {

    private final QuizRepository repository;
    private final MovieService movieService;

    private Integer hits = 0;
    private Integer misses = 0;
    private List<String> imdbIdList = new ArrayList<>();

    public Quiz nextQuiz() {
        final var quizNotAnswered = this.repository.findFirstByAnsweredFalse();
        if (quizNotAnswered.isPresent()) {
            return quizNotAnswered.get();
        }
        List<Movie> movieList = getMoviesList();
        Movie firstCompetitor = getRandomMovie(movieList);
        Movie secondCompetitor = getRandomMovie(movieList);

        Quiz quiz = new Quiz();
        quiz.setFirstCompetitor(firstCompetitor);
        quiz.setSecondCompetitor(secondCompetitor);
        quiz.setWinnerImdbId(winnerOf(firstCompetitor, secondCompetitor));
        return this.repository.save(quiz);
    }

    private String winnerOf(Movie firstCompetitor, Movie secondCompetitor) {
        return Stream.of(firstCompetitor, secondCompetitor)
            .max(Comparator.comparing(Movie::score))
            .map(Movie::getImdbId)
            .orElseThrow();
    }

    private Movie getRandomMovie(List<Movie> movieList) {
        int bound = movieList.size() > 0? movieList.size() : 1;
        return movieList.get(new Random().nextInt(bound));
    }

    private List<Movie> getMoviesList() {
        if (this.imdbIdList.isEmpty()) {
            return this.movieService.list();
        } else {
            return this.movieService.findMoviesByImdbIdNotIn(imdbIdList);
        }
    }
}
