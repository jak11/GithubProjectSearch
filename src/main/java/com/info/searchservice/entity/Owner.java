package com.info.searchservice.entity;

import java.util.Objects;

public class Owner {
  private String id;
  private String login;
  private String url;

  public Owner() {
  }

  public String getLogin() {
    return login;
  }

  @Override
  public String toString() {
    return "Owner{" +
        "id='" + id + '\'' +
        ", login='" + login + '\'' +
        ", url='" + url + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Owner owner = (Owner)o;
    return Objects.equals(id, owner.id) &&
        Objects.equals(login, owner.login) &&
        Objects.equals(url, owner.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, url);
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
