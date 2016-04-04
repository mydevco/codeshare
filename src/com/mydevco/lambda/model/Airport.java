/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mydevco.lambda.model;

import java.util.Objects;

public class Airport {

    private String code;
    private String name;
    private boolean isDelay;
    private double temperatue = 999;
    private String state;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsDelay() {
        return isDelay;
    }

    public void setIsDelay(boolean isDelay) {
        this.isDelay = isDelay;
    }

    public double getTemperatue() {
        return temperatue;
    }

    public void setTemperatue(double temperatue) {
        this.temperatue = temperatue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "Airport{" + "code=" + code + ", name=" + name + ", state=" + state + ", isDelay=" + isDelay + ", temprature=" + temperatue + "}";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.code);
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
        final Airport other = (Airport) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
    
}
