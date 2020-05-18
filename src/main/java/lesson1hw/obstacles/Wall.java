package lesson1hw.obstacles;

import lesson1hw.competitor.Competitor;

public class Wall extends Obstacle {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }

}
