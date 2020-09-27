package com.info.searchservice.assembler;

import com.info.searchservice.entity.Project;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ProjectModelAssembler implements RepresentationModelAssembler<Project, EntityModel<Project>> {

  @Override
  public EntityModel<Project> toModel(Project project) {
    return EntityModel.of(project);
  }
}
