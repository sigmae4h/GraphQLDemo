package com.example.GraphQLDemo;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@GraphQLTest
public class GraphQLTests {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void shouldReturnCorrectly() throws Exception {
        String expectedResponse = loadFromResource("responses/all_fields.json");

        GraphQLResponse response = graphQLTestTemplate.postForResource("requests/all_fields.graphql");

        assertEquals(expectedResponse, response.getRawResponse().getBody());
    }

    private String loadFromResource(String filePath) throws IOException {
        return IOUtils.toString(getClass().getClassLoader().getResource(filePath), "UTF-8");
    }

}
