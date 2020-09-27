package com.info.searchservice.entity;

import java.util.Objects;

public class Project {
  private String id;
  private String name;
  private String url;
  private Owner owner;

  public Project() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Project project = (Project)o;
    return Objects.equals(id, project.id) &&
        Objects.equals(name, project.name) &&
        Objects.equals(url, project.url) &&
        Objects.equals(owner, project.owner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, url, owner);
  }

  @Override
  public String toString() {
    return "Project{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", URL='" + url + '\'' +
        ", owner=" + owner +
        '}';
  }
}
