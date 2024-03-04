package com.challenge.popularRepo.service;

import com.challenge.popularRepo.entity.GitHubApiResponse;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface ReposService {
    Flux<GitHubApiResponse> sortedByStars();

    Flux<GitHubApiResponse> topNRepos(int pageSize);

    Flux<GitHubApiResponse> ReposSinceDate(LocalDateTime fromDate);
    Flux<GitHubApiResponse> ReposByProgrammingLanguage(String programmingLanguage);
}
