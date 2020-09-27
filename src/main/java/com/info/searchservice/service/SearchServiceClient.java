package com.info.searchservice.service;

public class SearchServiceClient {
  private final String url;

  public SearchServiceClient(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
