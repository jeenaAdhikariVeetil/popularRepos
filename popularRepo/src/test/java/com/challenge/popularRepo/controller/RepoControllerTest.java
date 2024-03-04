package com.challenge.popularRepo.controller;

import com.challenge.popularRepo.entity.GitHubApiResponse;
import com.challenge.popularRepo.entity.GitHubRepository;
import com.challenge.popularRepo.service.ReposServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebFluxTest(ReposController.class)
public class RepoControllerTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    ReposServiceImpl reposService;
    @Test
    void contexLoads() {
        assertThat(reposService).isNotNull();
    }
   // @Test
    public void fetchSortedByStarsTest() throws Exception {
        GitHubRepository repo1 = new GitHubRepository();
        repo1.setUrl("/test/mock/repo1");
        repo1.setProgrammingLanguage("java");
        GitHubRepository repo2 = new GitHubRepository();
        repo1.setUrl("/test/mock/repo2");
        repo1.setProgrammingLanguage("python");
        List<GitHubRepository> mockItems =  Arrays.asList(repo1,repo2);
        GitHubApiResponse mockApiResponse = new GitHubApiResponse();
        mockApiResponse.setItems(mockItems);
        when(reposService.sortedByStars()).thenReturn(Flux.just(mockApiResponse));
        webTestClient.get()
                .uri("repos/sort/stars")
                .exchange()
                .expectBodyList(GitHubRepository.class)
                .isEqualTo(mockItems);
    }
}
