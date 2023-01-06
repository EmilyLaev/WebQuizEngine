package engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

//This class represents the answers to the quiz questions
//The answer are stored in the form of an integer list
public class Answer {

    private List<Integer> answer;

}
