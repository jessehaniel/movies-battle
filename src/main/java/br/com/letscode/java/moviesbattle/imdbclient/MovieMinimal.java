package br.com.letscode.java.moviesbattle.imdbclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@formatter:off
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString @EqualsAndHashCode
//@formatter:on
public class MovieMinimal {

    @JsonProperty("imdbID")
    private String imdbId;
    @JsonProperty("Title")
    private String title;
    private Integer year;

    @JsonProperty("Year")
    public void setYear(String year) {
        this.year = Integer.parseInt(year);
    }
}
