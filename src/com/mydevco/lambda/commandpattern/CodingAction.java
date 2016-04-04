package com.mydevco.lambda.commandpattern;

public class CodingAction implements Action {
    private final Programming programming;
    public CodingAction(Programming programming) {
        this.programming = programming;
    }
    @Override
    public void execute() {
        programming.code();
    }
}

