package com.challenge.popularRepo.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class GitHubRepository {
    @JsonProperty("full_name")
    private String fullName;
}
