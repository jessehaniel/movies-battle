package br.com.letscode.java.moviesbattle.imdbclient;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieMinimalRestRepositoryTest {

    @Autowired
    private MovieMinimalRestRepository restRepository;

    @Test
    void search() {
        ResultSearch resultSearch = this.restRepository.search("Redemption");
        assertTrue(resultSearch.getResponse());

        boolean containsThBestMovieEver = false;
        for (MovieMinimal movieMinimal : resultSearch.getResultList()) {
            if (movieMinimal.getTitle().equals("The Shawshank Redemption")) {
                containsThBestMovieEver = true;
                break;
            }
        }

        assertTrue(containsThBestMovieEver);
    }
}
