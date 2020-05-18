package lesson1hw.competitor;

public class Human implements Competitor {

    private String type;
    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;

    private boolean onDistance;

    public Human(String name) {
        this.type = "Человек";
        this.name = name;
        this.maxRunDistance = 1000;
        this.maxJumpHeight = 2;
        this.onDistance = true;
    }

    public Human(String type, String name, int maxRunDistance, int maxJumpHeight) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (maxRunDistance == 0) {
            System.out.println(type + " " + name + " не умеет бегать");
            onDistance = false;
            return;
        }
        if (dist <= maxRunDistance) {
            System.out.println(type + " " + name + " успешно пробежал " + dist + " метров");
        } else {
            System.out.println(type + " " + name + " не может пробежать " + dist + " метров");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (maxJumpHeight == 0) {
            System.out.println(type + " " + name + " не умеет прыгать");
            onDistance = false;
            return;
        }
        if (height <= maxJumpHeight) {
            System.out.println(type + " " + name + " успешно прыгнул на  " + height + " метр(ов)");
        } else {
            System.out.println(type + " " + name + " не может прыгнуть на " + height + " метр(ов)");
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type + " " + name + " " +
                (onDistance ? "на дистанции" : "выбыл из соревнований"));
    }
}
