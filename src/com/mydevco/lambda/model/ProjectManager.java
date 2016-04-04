package com.mydevco.lambda.model;

public class ProjectManager {

    private String name;
    
    private PMPCertificate pmp;

    public PMPCertificate getPmp() {
        return pmp;
    }

    public ProjectManager(String name, PMPCertificate pmp) {
        this.name = name;
        this.pmp = pmp;
    }
    
    
    public String getName() {
        return name;
    }
}
