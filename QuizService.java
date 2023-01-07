package engine.services;

import engine.entity.Answer;
import engine.entity.Quiz;
import engine.entity.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// Service interface for Quiz entity
//Has the get, save and delete method for the quiz itself
public interface QuizService {

    Quiz saveQuiz(Quiz quiz);

    List<Quiz> printAllQuizzes();

    Quiz getQuizById(Integer quizId);

    Response getAnswer(int id, Answer answer);

    void deleteQ(int id);

    Page<Quiz> findAll(Pageable pageable);
}
