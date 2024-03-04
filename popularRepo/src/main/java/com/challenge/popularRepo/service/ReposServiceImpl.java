package com.challenge.popularRepo.service;

import com.challenge.popularRepo.entity.GitHubApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static com.challenge.popularRepo.constants.ReposConstants.BASEURL;
import static com.challenge.popularRepo.constants.ReposConstants.URI;

@Service
public class ReposServiceImpl implements ReposService{
    private final WebClient.Builder webClientBuilder;

    public ReposServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Flux<GitHubApiResponse> fetchPopularRepos() {

        return webClientBuilder.baseUrl(BASEURL)
                .build()
                .get()
                .uri(URI)
                .retrieve()
                .bodyToFlux(GitHubApiResponse.class);
    }
}
