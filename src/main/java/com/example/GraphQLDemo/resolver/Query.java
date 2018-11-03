package com.example.GraphQLDemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.GraphQLDemo.domain.Link;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Link> getLinks() {
        List<Link> links = new ArrayList<>();

        Link link1 = new Link("someUrl", "someDescription");
        Link link2 = new Link("anotherUrl", "anotherDescription");

        links.add(link1);
        links.add(link2);

        return links;
    }

}
