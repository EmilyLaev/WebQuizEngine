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

//REST controller for interacting with Quiz entities.
@RestController
public class QuizController {

    //Service for interacting with Quiz entities
    @Autowired
    private QuizService quizService;

    //Handles a POST request to the "/api/quizzes" endpoint.
    //Saves the given Quiz object and returns it.
    @PostMapping("/api/quizzes")
    public Quiz sentQuiz(@Valid @RequestBody Quiz quiz) {
        return quizService.saveQuiz(quiz);
    }

    //Handles a GET request to the "/api/quizzes" endpoint.
    //Returns a paginated list of Quiz objects.
    @GetMapping("/api/quizzes")
    public Page<Quiz> findAll(@RequestParam(defaultValue = "0") Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        return quizService.findAll(pageRequest);
    }

    //Handles a GET request to the "/api/quizzes/{id}" endpoint.
    //Returns the Quiz object with the given id.
    @GetMapping("/api/quizzes/{id}")
    public Quiz getById(@PathVariable("id") int id) {
        return quizService.getQuizById(id);
    }

    //Handles the POST request to the  "/api/quizzes/{id}/solve" endpoint
    @PostMapping("/api/quizzes/{id}/solve")
    public Response getResponse(@PathVariable("id") int id, @RequestBody Answer answer) {
        return quizService.getAnswer(id, answer);
    }

    //Handles a DELETE request to the "/api/quizzes/{id}" endpoint
    @DeleteMapping("/api/quizzes/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteQ(@PathVariable("id") int id) {
        quizService.deleteQ(id);
    }

    //Handles a GET request to the "/api/test" endpoint
    @GetMapping("/api/test")
    @ResponseBody
    public String test(Authentication authentication) {
        return authentication.getName();
    }
}
