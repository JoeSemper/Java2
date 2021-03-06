package hw1.party;

import hw1.Actionable;
import hw1.obstacles.*;

import java.util.*;

public class Human implements Actionable {

    private String name;
    private String type;
    private int maxRun;
    private int maxJump;
    private boolean isOnDistance;

    Random random = new Random();

    public Human (String name) {
        this.name = name;
        this.type = "Human";

        this.isOnDistance = true;

        this.maxRun = random.nextInt(1000) + 3000;
        this.maxJump = random.nextInt(2) + 2;
    }

    @Override
    public void run(Road r){
        if (!isOnDistance){
            return;
        }
        if (r.getLength() > maxRun){
            isOnDistance = false;
            System.out.printf("%s %s could not run! \n", type, name);
            return;
        }
        System.out.printf("%s %s ran! \n", type, name);
    }

    @Override
    public void jump(Wall w){
        if (!isOnDistance){
            return;
        }
        if (w.getHeight() > maxJump){
            isOnDistance = false;
            System.out.printf("%s %s could not jump! \n", type, name);
            return;
        }
        System.out.printf("%s %s jumped! \n", type, name);
    }

}