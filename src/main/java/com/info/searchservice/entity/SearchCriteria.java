package com.info.searchservice.entity;

import com.info.searchservice.config.ProjectConstants;

public class SearchCriteria {
  private String query;
  private int page;
  private int pagesize;

  public void setQuery(String query) {
    this.query = query;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public void setPagesize(int pagesize) {
    this.pagesize = pagesize;
  }

  public String getQuery() {
    return query;
  }
  public int getPage() {
    return this.page == 0 ? ProjectConstants.DEFAULT_PAGE_NO : this.page;
  }
  public int getPagesize() {
    return this.pagesize == 0 ? ProjectConstants.DEFAULT_PAGE_SIZE : this.pagesize;
  }
  @Override
  public String toString() {
    return "SearchCriteria{" +
        "query='" + query + '\'' +
        ", page=" + page +
        ", pageSize=" + pagesize +
        '}';
  }
}
