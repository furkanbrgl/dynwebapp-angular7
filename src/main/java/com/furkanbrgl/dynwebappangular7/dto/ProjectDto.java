package com.furkanbrgl.dynwebappangular7.dto;


public class ProjectDto {

    private Long id;
    private String projectName;
    private String projectCode;

    public ProjectDto(Long id, String projectName, String projectCode) {
        this.id = id;
        this.projectName = projectName;
        this.projectCode = projectCode;
    }

    public ProjectDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
}