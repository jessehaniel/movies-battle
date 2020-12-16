package br.com.letscode.java.moviesbattle.quiz;

import br.com.letscode.java.moviesbattle.movie.MovieDTO;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizDTO {

    private UUID id;
    private MovieDTO firstCompetitor;
    private MovieDTO secondCompetitor;
}
