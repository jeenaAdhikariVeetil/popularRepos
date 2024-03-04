package com.challenge.popularRepo.entity;

import lombok.Data;

import java.util.List;
@Data
public class GitHubApiResponse {
    private List<GitHubRepository> items;
}
