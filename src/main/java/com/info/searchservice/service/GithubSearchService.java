package com.info.searchservice.service;

import java.util.ArrayList;
import java.util.List;

import com.info.searchservice.entity.GithubResponse;
import com.info.searchservice.entity.Project;
import com.info.searchservice.entity.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubSearchService extends SearchService {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  public GithubSearchService(@Qualifier("githubServiceClient") SearchServiceClient client) {
    super(client);
  }

  @Override
  public List<Project> search(SearchCriteria searchCriteria) {
    GithubResponse result = restTemplate.getForObject(getClient().getUrl() + "?q=" +
        searchCriteria.getQuery() + "&&page=" + searchCriteria.getPage() + "&&per_page=" + searchCriteria.getPagesize(), GithubResponse.class);

    if (result != null) {
      return result.getItems();
    }
    return new ArrayList<>();
  }
}
