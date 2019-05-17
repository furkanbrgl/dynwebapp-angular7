package com.furkanbrgl.dynwebappangular7.service;

import com.furkanbrgl.dynwebappangular7.dto.ProjectDto;
import com.furkanbrgl.dynwebappangular7.entity.Project;
import com.furkanbrgl.dynwebappangular7.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getById(Long id);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);

}