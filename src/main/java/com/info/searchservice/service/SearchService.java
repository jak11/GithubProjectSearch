package com.info.searchservice.service;

import java.util.List;

import com.info.searchservice.entity.Project;
import com.info.searchservice.entity.SearchCriteria;

abstract class SearchService {
  private SearchServiceClient client;

  public SearchService(SearchServiceClient client) {
    this.client = client;
  }

  public SearchServiceClient getClient() {
    return client;
  }

  abstract public List<Project> search(SearchCriteria searchCriteria);
}
