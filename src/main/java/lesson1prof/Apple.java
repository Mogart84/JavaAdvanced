package lesson1prof;

public class Apple extends Fruit {

    private final float WEIGHT = 1.0f;

    public float getWeight() {
        return WEIGHT;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

}
