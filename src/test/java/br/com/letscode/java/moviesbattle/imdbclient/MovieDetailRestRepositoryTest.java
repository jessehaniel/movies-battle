package br.com.letscode.java.moviesbattle.imdbclient;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MovieDetailRestRepositoryTest {

    @Autowired
    private MovieDetailRestRepository restRepository;

    @Test
    void detail() {
        MovieDetail movieDetail = this.restRepository.detail("tt0111161");
        assertTrue(movieDetail.getResponse());
    }
}
