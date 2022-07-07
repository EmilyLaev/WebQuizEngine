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

@Service
public class CompletedLogImp implements CompletedLogServices {

    @Autowired
    private CompletedLogRepository repository;

    @Override
    public void saveCompletedLog(CompletedLog completedLog) {
        repository.save(completedLog);
    }

    @Override
    public Page<CompletedLog> findAll(Pageable pageable) {
        Object currentLogInUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repository.findByUserId(((CustomUserDetails) currentLogInUser).getId(), pageable);
    }
}