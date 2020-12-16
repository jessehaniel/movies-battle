package br.com.letscode.java.moviesbattle.movie;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@formatter:off
@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString @EqualsAndHashCode
//@formatter:on
public class Movie { //POJO

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private Integer year;
    private String imdbId;
    private String type;
    private Double rating;
    private Long votes;

    public Double score() {
        return rating * votes;
    }

    public MovieDTO getDTO() {
        return MovieDTO.builder()
            .imdbId(this.imdbId)
            .title(this.title)
            .year(this.year)
            .build();
    }

}
