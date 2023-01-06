package engine.controller;

import engine.entity.CompletedLog;
import engine.services.CompletedLogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Controller for handling HTTP requests related to CompletedLog entities.
@RestController
public class CompletedLogController {

    @Autowired
    private CompletedLogServices completedLogServices;

    //This handles HTTP GET requests to retrieve a list of completed logs, sorted by the specified field.
    //Default page is set to 0
    @GetMapping("/api/quizzes/completed")
    public Page<CompletedLog> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "completedAt") String sortBy
    ) {
        return completedLogServices.findAll(PageRequest.of(
                page,
                10,
                Sort.Direction.DESC, sortBy)
        );
    }

}
