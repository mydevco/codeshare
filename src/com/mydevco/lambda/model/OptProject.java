package com.mydevco.lambda.model;

import java.util.Optional;


public class OptProject {

    private Optional<ProjectManager> manager;

    public Optional<ProjectManager> getManager() {
        return manager;
    }

    public OptProject(Optional<ProjectManager> manager) {
        this.manager = manager;
    }
    
}
