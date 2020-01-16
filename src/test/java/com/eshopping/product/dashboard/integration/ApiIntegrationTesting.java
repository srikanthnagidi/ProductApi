package com.hackerrank.eshopping.product.dashboard.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ApiIntegrationTesting {

    @Autowired private MockMvc mvc;

    @LocalServerPort
    private  int port;

    @Autowired private TestRestTemplate testRestTemplate;

    @Test
    public void getAllProducts(){
        ResponseEntity<List> responseEntity = testRestTemplate.getForEntity("http://localhost:" + port + "/products", List.class);
        assertThat(responseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
