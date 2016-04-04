package com.mydevco.lambda.common;

import java.util.Optional;

import com.mydevco.lambda.model.PMPCertificate;
import com.mydevco.lambda.model.Project;
import com.mydevco.lambda.model.ProjectManager;

public class Optionals {
    

    public static final Optional<Integer> max(Optional<Integer> i, Optional<Integer> j) {
         return i.flatMap(a -> j.map(b -> Math.max(a, b)));
    }
    
    public static boolean getAgileExperience(Project project) {

        if (null != project) {
            if (null != project.getManager()) {
                if (null != project.getManager().getPmp()) {
                    return project.getManager().getPmp().isAgileExperience();
                }
            }
        }
          
        return false;
        
    }
    
    public static void main(String[] args) {

        System.out.println(max(Optional.of(700), Optional.of(500)));
        System.out.println(max(Optional.empty(), Optional.of(100)));
        
        PMPCertificate cert = new PMPCertificate(true);
        
        ProjectManager mgr = new ProjectManager("Anyone", null);
        //ProjectManager mgr = new ProjectManager("Anyone", cert);
        
        //ProjectManager mgr = new ProjectManager("Anyone", cert);
        
        System.out.println("Agile Project : " + getAgileExperience(new Project(mgr)));

        //System.out.println("Agile Project : " + getAgileExperience(Optional.empty()));
        //System.out.println("Agile Project : " + getAgileExperience(Optional.ofNullable(null)));
        //System.out.println("Agile Project : " + getAgileExperience(Optional.of(new Project(null))));
        //System.out.println("Agile Project : " + getAgileExperience(Optional.of(new Project(mgr))));
    }
    
    
    
    
    /*
    public static boolean getOptionalAgileExperience(Optional<Project> project) {

    
        return project.flatMap(Project::getManager)
                     .flatMap(ProjectManager::getPmp)
                     .map(PMPCertificate::isAgileExperience)
                     .orElse(false);
        
     
    }
    
    */
    
}
