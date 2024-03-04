package com.challenge.popularRepo.controller;

import com.challenge.popularRepo.entity.GitHubApiResponse;
import com.challenge.popularRepo.service.ReposServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/repos")
public class ReposController {
    private final ReposServiceImpl reposService;

    public ReposController(ReposServiceImpl reposService) {
        this.reposService = reposService;
    }


    @GetMapping("/sort/stars")
    public   Flux<GitHubApiResponse> fetchSortedByStars() {
        return reposService.sortedByStars();
    }
    @GetMapping("/sort/stars/{pageSize}")
    public   Flux<GitHubApiResponse> fetchTopNRepos(@PathVariable int pageSize) {
        return reposService.topNRepos(pageSize);
    }
    @GetMapping("/sort/stars/date/{fromDate}")
    public   Flux<GitHubApiResponse> fetchReposSinceDate(@PathVariable
                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                          LocalDateTime fromDate) {
        return reposService.ReposSinceDate(fromDate);
    }
    @GetMapping("/sort/stars/language/{programmingLanguage}")
    public   Flux<GitHubApiResponse> fetchReposByLanguage(@PathVariable String programmingLanguage) {
        return reposService.ReposByProgrammingLanguage(programmingLanguage);
    }
}
