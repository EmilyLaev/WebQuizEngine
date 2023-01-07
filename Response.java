package engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//A class representing the response for the result
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    //Indicates whether the solution was successful or not.
    private boolean success;
    private String feedback;
}
