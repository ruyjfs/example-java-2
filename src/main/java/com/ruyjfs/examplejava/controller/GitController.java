package com.ruyjfs.examplejava.controller;

import com.ruyjfs.examplejava.service.GitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/git")
public class GitController {

    @Autowired
    private final GitService service;

    @GetMapping("")
    public Map<String, String> index() {
        return service.get();
    }
}
