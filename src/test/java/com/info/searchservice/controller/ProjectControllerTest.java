package com.info.searchservice.controller;

import java.util.Arrays;
import java.util.List;

import com.info.searchservice.assembler.ProjectModelAssembler;
import com.info.searchservice.controlllers.ProjectController;
import com.info.searchservice.entity.Owner;
import com.info.searchservice.entity.Project;
import com.info.searchservice.service.GithubSearchService;
import com.info.searchservice.validator.QueryValidator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private QueryValidator queryValidator;

  @MockBean
  private GithubSearchService githubSearchService;

  @MockBean
  private ProjectModelAssembler projectModelAssembler;

  @Test
  public void getProjectsAPI() throws Exception
  {
    Mockito.when(githubSearchService.search(Mockito.any())).thenReturn(getSampleExpectedGithubResponse());
    Project p = new Project();
    p.setId("1");
    p.setName("test_project");
    Mockito.when(projectModelAssembler.toModel(Mockito.any())).thenReturn(EntityModel.of(p));
    mvc.perform(get("/projects")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("test_project")));
  }

  private List<Project> getSampleExpectedGithubResponse(){
    Project p = new Project();
    p.setId("1");
    p.setName("test_project");
    Owner owner = new Owner();
    owner.setId("owner1");
    owner.setLogin("ownerlogin");
    p.setOwner(owner);
    return Arrays.asList(p);
  }
}
