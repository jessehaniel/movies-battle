package br.com.letscode.java.moviesbattle.imdbclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.NumberFormat;
import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDetail extends MovieMinimal {

    private Double rating;
    private Long votes;
    private Boolean response;

    @JsonProperty("imdbRating")
    public void setRating(String rating) {
        this.rating = Double.valueOf(rating);
    }

    @SneakyThrows
    @JsonProperty("imdbVotes")
    public void setVotes(String votes) {
        this.votes = NumberFormat.getInstance(Locale.US)
            .parse(votes)
            .longValue();
    }

    @JsonProperty("Response")
    public void setResponse(String response) {
        this.response = Boolean.valueOf(response);
    }
}
