package engine.services;


import engine.entity.CompletedLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompletedLogServices {

    void saveCompletedLog(CompletedLog completedLog);

    Page<CompletedLog> findAll(Pageable pageable);
}