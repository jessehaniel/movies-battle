package br.com.letscode.java.moviesbattle.imdbclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
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
public class ResultSearch {

    @JsonProperty("Search")
    private List<MovieMinimal> resultList;

    private Integer total;
    private Boolean response;

    @JsonProperty("totalResults")
    public void setTotal(String total) {
        this.total = Integer.parseInt(total);
    }

    @JsonProperty("Response")
    public void setResponse(String response) {
        this.response = Boolean.valueOf(response);
    }
}
