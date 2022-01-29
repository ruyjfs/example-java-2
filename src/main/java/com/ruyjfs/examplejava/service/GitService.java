package com.ruyjfs.examplejava.service;

import com.ruyjfs.examplejava.model.Contributor;
import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

class Issue {
    String title;
    String body;
    List<String> assignees;
    int milestone;
    List<String> labels;
}

interface GitHub {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

    @RequestLine("POST /repos/{owner}/{repo}/issues")
    void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);

    @RequestLine("GET /emojis")
    Map<String, String> getEmojis();

}

@Service
public class GitService {

    public Map<String, String> get() {
        GitHub github = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");
        return github.getEmojis();
    }
}
