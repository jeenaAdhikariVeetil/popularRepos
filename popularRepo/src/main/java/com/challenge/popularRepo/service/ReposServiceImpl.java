package com.challenge.popularRepo.service;

import com.challenge.popularRepo.entity.GitHubApiResponse;
import com.challenge.popularRepo.entity.GitHubRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Comparator;

import static com.challenge.popularRepo.constants.ReposConstants.BASEURL;
import static com.challenge.popularRepo.constants.ReposConstants.URI;

@Service
public class ReposServiceImpl implements ReposService{
    private final WebClient.Builder webClientBuilder;

    public ReposServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Flux<GitHubApiResponse> sortedByStars() {

        return webClientBuilder.baseUrl(BASEURL)
                .build()
                .get()
                .uri(URI)
                .retrieve()
                .bodyToFlux(GitHubApiResponse.class)
                .flatMap(apiResponse -> Flux.fromIterable(apiResponse.getItems()))
                .sort(Comparator.comparing(GitHubRepository::getStargazersCount).reversed())
                .collectList()
                .map(sortedList -> {
                    GitHubApiResponse response = new GitHubApiResponse();
                    response.setItems(sortedList);
                    return response;
                })
                .flux();
    }

    @Override
    public Flux<GitHubApiResponse> topNRepos(int pageSize) {
        return webClientBuilder.baseUrl(BASEURL)
                .build()
                .get()
                .uri(URI)
                .retrieve()
                .bodyToFlux(GitHubApiResponse.class)
                .flatMap(apiResponse -> Flux.fromIterable(apiResponse.getItems()))
                .sort(Comparator.comparing(GitHubRepository::getStargazersCount).reversed())
                .take(pageSize)
                .collectList()
                .map(sortedList -> {
                    GitHubApiResponse response = new GitHubApiResponse();
                    response.setItems(sortedList);
                    return response;
                })
                .flux();
    }

    @Override
    public Flux<GitHubApiResponse> ReposSinceDate(LocalDateTime fromDate) {
        return webClientBuilder.baseUrl(BASEURL)
                .build()
                .get()
                .uri(URI)
                .retrieve()
                .bodyToFlux(GitHubApiResponse.class)
                .flatMap(apiResponse -> Flux.fromIterable(apiResponse.getItems()))
                .filter(repository -> repository.getCreatedDate().isAfter(fromDate))
                .sort(Comparator.comparing(GitHubRepository::getStargazersCount).reversed())
                .collectList()
                .map(sortedList -> {
                    GitHubApiResponse response = new GitHubApiResponse();
                    response.setItems(sortedList);
                    return response;
                })
                .flux();
    }

    @Override
    public Flux<GitHubApiResponse> ReposByProgrammingLanguage(String programmingLanguage) {
        return webClientBuilder.baseUrl(BASEURL)
                .build()
                .get()
                .uri(URI)
                .retrieve()
                .bodyToFlux(GitHubApiResponse.class)
                .flatMap(apiResponse -> Flux.fromIterable(apiResponse.getItems()))
                .filter(repository -> {
                    String language = repository.getProgrammingLanguage();
                    return language != null && language.equalsIgnoreCase(programmingLanguage);
                })
                .sort(Comparator.comparing(GitHubRepository::getStargazersCount).reversed())
                .collectList()
                .map(sortedList -> {
                    GitHubApiResponse response = new GitHubApiResponse();
                    response.setItems(sortedList);
                    return response;
                })
                .flux();
    }
}
