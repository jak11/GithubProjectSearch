package com.info.searchservice.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.info.searchservice.entity.GithubResponse;
import com.info.searchservice.entity.Owner;
import com.info.searchservice.entity.Project;
import com.info.searchservice.entity.SearchCriteria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class GithubSearchServiceTest {
  @MockBean
  private RestTemplate restTemplate;

  @Autowired
  @InjectMocks
  private GithubSearchService githubSearchService;

  @BeforeEach
  private void init(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void test_search_with_valid_search(){
    GithubResponse githubResponse = getSampleExpectedGithubResponse();
    Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.any())).thenReturn(githubResponse);
    SearchCriteria criteria = new SearchCriteria();
    criteria.setQuery("sampleqquery");
    List<Project> expected_projects = githubSearchService.search(criteria);
    Assertions.assertEquals(expected_projects, githubResponse.getItems());
  }

  @Test
  public void test_search_with_invalid_search(){
    Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.any())).thenReturn(null);
    SearchCriteria criteria = new SearchCriteria();
    criteria.setQuery("sampleqquery");
    List<Project> expected_projects = githubSearchService.search(criteria);
    Assertions.assertEquals(expected_projects, Collections.emptyList());
  }

  private GithubResponse getSampleExpectedGithubResponse(){
    GithubResponse githubResponse = new GithubResponse();
    Project p = new Project();
    p.setId("1");
    p.setName("test_project");
    Owner owner = new Owner();
    owner.setId("owner1");
    owner.setLogin("ownerlogin");
    p.setOwner(owner);
    githubResponse.setItems(Arrays.asList(p));
    return githubResponse;
  }

}
