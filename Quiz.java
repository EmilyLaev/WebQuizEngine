package engine.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    
    // The unique identifier for the quiz
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    // The title of the quiz
    @NotNull
    @NotBlank(message = "title is required")
    private String title;

    // The text of the quiz
    @NotNull
    @NotBlank(message = "text is required")
    private String text;
    
    // The options for the quiz
    @NotNull
    @Size(min = 2)
    @ElementCollection
    private List<String> options;

    // The correct solutions for the quiz
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ElementCollection
    private List<Integer> answer;

    // The user that created the quiz
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    // The date and time that the quiz was completed
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime completedAt;

    // Constructor for creating a new quiz
    public Quiz(String title, String text, List<String> options, List<Integer> answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }
}
