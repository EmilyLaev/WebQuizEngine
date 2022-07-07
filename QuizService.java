package engine.services;

import engine.entity.Answer;
import engine.entity.Quiz;
import engine.entity.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuizService {

    Quiz saveQuiz(Quiz quiz);

    List<Quiz> printAllQuizzes();

    Quiz getQuizById(Integer quizId);

    Response getAnswer(int id, Answer answer);

    void deleteQ(int id);

    Page<Quiz> findAll(Pageable pageable);
}
