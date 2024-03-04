package com.challenge.popularRepo.service;

import com.challenge.popularRepo.entity.GitHubApiResponse;
import reactor.core.publisher.Flux;

public interface ReposService {
    Flux<GitHubApiResponse> fetchPopularRepos();
}
