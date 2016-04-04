package com.mydevco.lambda.model;

import java.util.Objects;

public class Baby {
    
    private String name;
    private String gender; //M/F
    private int occurance;

    public Baby(String name, String gender, int occurance) {
        this.name = name;
        this.gender = gender;
        this.occurance = occurance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getOccurance() {
        return occurance;
    }

    public void setOccurance(int occurance) {
        this.occurance = occurance;
    }

    @Override
    public String toString() {
        return "Baby{" + "name=" + name + ", gender=" + gender + ", occurance=" + occurance + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.gender);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Baby other = (Baby) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        return true;
    }
    
    
}
