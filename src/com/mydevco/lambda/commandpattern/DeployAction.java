package com.mydevco.lambda.commandpattern;

public class DeployAction implements Action {
    private final Programming programming;
    public DeployAction(Programming programming) {
        this.programming = programming;
    }
    @Override
    public void execute() {
        programming.deploy();
    }
}

