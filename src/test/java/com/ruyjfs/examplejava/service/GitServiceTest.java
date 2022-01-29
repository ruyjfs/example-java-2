package com.ruyjfs.examplejava.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;
@EnableFeignClients(clients = GitService.class)
@RestController
@Configuration
@EnableAutoConfiguration
@RibbonClient(name = "test", configuration = FeignAPITest.RibbonConfig.class)
static class FeignConfig {

    @RequestMapping(value = "hello")
    public String testFeign() {
        return "success";
    }

}

@SpringBootTest(classes = GitServiceTest.FeignConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitServiceTest {

    @InjectMocks
    private GitService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test_Get_OK() {
        var data = service.get();

        Mockito.when(service.get()).thenReturn(null);
//        FormField formField =
//                formFieldTemplate.getFormField("campaignName", FormFieldValidationType.REQUIRED, "true");
//        FormField result = service.save(formField);
//
//        Mockito.when(service.save(formField)).thenReturn(formField);
//        assertThat(result).isNull();
    }

}
