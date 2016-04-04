package com.mydevco.lambda.commandpattern;

public class TestingAction implements Action {
    private final Programming programming;
    public TestingAction(Programming program) {
        this.programming = program;
    }
    @Override
    public void execute() {
        programming.test();
    }
}

