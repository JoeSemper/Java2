package hw1;

import hw1.obstacles.Road;
import hw1.obstacles.Wall;

public interface Actionable {

    void run(Road r);

    void jump(Wall w);
}
