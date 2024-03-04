package com.challenge.popularRepo.controller;

import com.challenge.popularRepo.entity.GitHubApiResponse;
import com.challenge.popularRepo.service.ReposServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/popularRepos")
public class ReposController {
    private final ReposServiceImpl reposService;

    public ReposController(ReposServiceImpl reposService) {
        this.reposService = reposService;
    }


    @GetMapping("/getExternalData")
    public   Flux<GitHubApiResponse>  fetchPopularRepos() {
        return reposService.fetchPopularRepos();
    }

}
