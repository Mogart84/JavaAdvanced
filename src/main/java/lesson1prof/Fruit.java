package lesson1prof;

public class Fruit {

    protected float WEIGHT;

    public float getWeight() {
        return WEIGHT;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

}
