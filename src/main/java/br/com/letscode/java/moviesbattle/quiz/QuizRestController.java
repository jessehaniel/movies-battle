package br.com.letscode.java.moviesbattle.quiz;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping( "/quiz")
@RestController
public class QuizRestController {

    private final QuizService service;

    @GetMapping
    public QuizDTO nextQuiz() {
        return this.service.nextQuiz().getDTO();
    }

}
