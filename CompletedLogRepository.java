package engine.repository;

import engine.entity.CompletedLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompletedLogRepository extends PagingAndSortingRepository<CompletedLog, Long> {
    Page<CompletedLog> findByUserId(Long id, Pageable pageable);

}