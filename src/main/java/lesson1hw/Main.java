package lesson1hw;

import lesson1hw.competitor.Cat;
import lesson1hw.competitor.Competitor;
import lesson1hw.competitor.Human;
import lesson1hw.competitor.Robot;
import lesson1hw.obstacles.Obstacle;
import lesson1hw.obstacles.Track;
import lesson1hw.obstacles.Wall;

public class Main {

    public static void main(String[] args) {
        Competitor[] competitors = {
                new Human("Вася"),
                new Cat("Барсик"),
                new Robot("Вертер"),
        };

        Obstacle[] obstacles = {
                new Track(500),
                new Wall(1)
        };

        for (Competitor c:competitors ) {
            for (Obstacle o:obstacles ) {
                o.doIt(c);
                if(!c.isOnDistance()){
                    break;
                }
            }
        }

        for (Competitor c:competitors ) {
            c.info();
        }

    }

}
