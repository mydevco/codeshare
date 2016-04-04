package com.mydevco.lambda.model;


public class Project {

    private ProjectManager manager;

    public ProjectManager getManager() {
        return manager;
    }

    public Project(ProjectManager manager) {
        this.manager = manager;
    }
    
}
