package engine.services;

import engine.entity.CompletedLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//Interface for interacting with CompletedLog entities.
public interface CompletedLogServices {

    //Persists the given CompletedLog to the database.
    void saveCompletedLog(CompletedLog completedLog);

    //Retrieves a paginated list of CompletedLogs.
    Page<CompletedLog> findAll(Pageable pageable);
}
