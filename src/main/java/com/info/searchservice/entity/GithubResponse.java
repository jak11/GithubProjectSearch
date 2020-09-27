package com.info.searchservice.entity;

import java.util.List;

public class GithubResponse {
  private List<Project> items;

  public List<Project> getItems() {
    return items;
  }

  public void setItems(List<Project> items) {
    this.items = items;
  }
}
