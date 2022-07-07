package engine;

import engine.entity.Answer;
import engine.entity.Quiz;
import engine.entity.Response;
import engine.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/api/quizzes")
    public Quiz sentQuiz(@Valid @RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    @GetMapping("/api/quizzes")
    public Page<Quiz> findAll(@RequestParam(defaultValue = "0") Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        return quizService.findAll(pageRequest);
    }

    @GetMapping("/api/quizzes/{id}")
    public Quiz getById(@PathVariable("id") int id) {
        return quizService.getQuizById(id);
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public Response getResponse(@PathVariable("id") int id, @RequestBody Answer answer) {
        return quizService.getAnswer(id, answer);
    }

    @DeleteMapping("/api/quizzes/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteQ(@PathVariable("id") int id) {
        quizService.deleteQ(id);
    }

    @GetMapping("/api/test")
    @ResponseBody
    public String test(Authentication authentication) {
        return authentication.getName();
    }
}