package engine.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompletedLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long logId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long userId;
    private Integer id;
    private LocalDateTime completedAt;

    public CompletedLog(Long userId, Integer id, LocalDateTime completedAt) {
        this.userId = userId;
        this.id = id;
        this.completedAt = completedAt;
    }
}