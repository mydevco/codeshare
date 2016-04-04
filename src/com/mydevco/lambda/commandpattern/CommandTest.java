package com.mydevco.lambda.commandpattern;

import java.util.ArrayList;
import java.util.List;
public class CommandTest {

    public static void main(String[] args) {
        Development development = new Development();
        List<Action> developer = new ArrayList<>();
        developer.add(new CodingAction(development));
        developer.add(new TestingAction(development));
        developer.add(new DeployAction(development));

        for (Action action : developer) {
            action.execute();
        }
        
        //using lambda
        System.out.println("\n\nUsing Lambda>>>");      
        List<Action> smartDeveloper = new ArrayList<>();
        smartDeveloper.add(development::code);
        smartDeveloper.add(development::test);
        smartDeveloper.add(development::deploy);

        for (Action action : smartDeveloper) {
            action.execute();
        }
    }

}
