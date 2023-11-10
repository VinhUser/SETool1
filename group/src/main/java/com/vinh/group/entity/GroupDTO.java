package com.vinh.group.entity;

public class GroupDTO {
    private int id;
    public String name;
    public Integer projectManager;
    public int studentCount;


    public GroupDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public Integer getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Integer projectManager) {
        this.projectManager = projectManager;
    }
}
