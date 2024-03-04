package com.challenge.popularRepo.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class GitHubRepository {
    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("stargazers_count")
    private Long stargazersCount;

    private String url;

    private String description;

    @JsonProperty("language")
    private String programmingLanguage;

    @JsonProperty("created_at")
    private LocalDateTime createdDate;
}
