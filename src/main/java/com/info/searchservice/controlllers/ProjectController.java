package com.info.searchservice.controlllers;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import com.info.searchservice.assembler.ProjectModelAssembler;
import com.info.searchservice.entity.Project;
import com.info.searchservice.entity.SearchCriteria;
import com.info.searchservice.service.GithubSearchService;
import com.info.searchservice.validator.QueryValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
  private static final Logger log = LoggerFactory.getLogger(ProjectController.class);
  @Autowired
  private QueryValidator queryValidator;

  @Autowired
  private GithubSearchService githubSearchService;

  @Autowired
  private ProjectModelAssembler projectModelAssembler;

  @GetMapping("/projects")
  public CollectionModel<EntityModel<Project>> getProjects2(@Valid SearchCriteria criteria) {
    log.info("Query performed for searching projects {}", criteria);
    queryValidator.validate(criteria.getQuery()); // validate the query

    List<EntityModel<Project>> projects = githubSearchService.search(criteria).stream()
        .map(projectModelAssembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(projects);
  }
}
