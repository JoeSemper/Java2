package hw1;

import hw1.obstacles.*;
import hw1.party.*;

public class Main {

    public static void main(String[] args) {

        Actionable[] partyArr = { new Human("Bob"), new Human("Tony"),
                new Cat("Barsik"), new Cat("Tigr"),
                new Robot("Arnold"), new Robot("Wall-e")
        };

        Road r1 = new Road(2500);
        Road r2 = new Road(4000);
        Wall w1 = new Wall(3);
        Wall w2 = new Wall(5);


        for (Actionable a : partyArr) {
            a.run(r1);
            a.jump(w1);
            a.run(r2);
            a.jump(w2);
        }

    }
}
