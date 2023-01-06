package engine.services;

import engine.entity.CompletedLog;
import engine.repository.CompletedLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


//Service for interacting with CompletedLog entities.
@Service
public class CompletedLogImp implements CompletedLogServices {

    //Repository for accessing CompletedLog entities from the database.
    @Autowired
    private CompletedLogRepository repository;

    @Override
    public void saveCompletedLog(CompletedLog completedLog) {
        repository.save(completedLog);
    }

    //Retrieves a paginated list of CompletedLogs belonging to the currently logged-in user.
    //@param pageable a Pageable object specifying the page number and page size of the logs to retrieve
    //@return a Page object containing the list of CompletedLogs
    @Override
    public Page<CompletedLog> findAll(Pageable pageable) {
        Object currentLogInUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repository.findByUserId(((CustomUserDetails) currentLogInUser).getId(), pageable);
    }
}
