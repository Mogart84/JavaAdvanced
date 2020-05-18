package lesson1hw.obstacles;

import lesson1hw.competitor.Competitor;

public class Track extends Obstacle {

    private int dist;

    public Track(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(dist);
    }

}
