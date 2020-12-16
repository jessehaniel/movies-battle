package br.com.letscode.java.moviesbattle.quiz;


import br.com.letscode.java.moviesbattle.movie.Movie;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data
@Entity
public class Quiz {

    @Id
    @GeneratedValue
    private UUID id;

    private String winnerImdbId;
    private Boolean answered = false;

    @ManyToOne
    private Movie firstCompetitor;
    @ManyToOne
    private Movie secondCompetitor;

    public QuizDTO getDTO() {
        return QuizDTO.builder()
            .id(this.id)
            .firstCompetitor(this.firstCompetitor.getDTO())
            .secondCompetitor(this.secondCompetitor.getDTO())
            .build();
    }

}
