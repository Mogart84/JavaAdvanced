package lesson1prof;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruitBox;
    private String boxType;

    public Box() {
        this.fruitBox = new ArrayList<>();
    }

    public Box(int initCapacity) {
        this.fruitBox = new ArrayList<>(initCapacity);
    }

    // Тип коробки определяется по первому размещенному в ней фрукту
    public void addFruit(T fruit) {
        if (boxType == null) {
            boxType = fruit.getClass().getSimpleName();
        }

        if (boxType.equals(fruit.getType())) {
            fruitBox.add(fruit);
        } else {
            System.out.println("Не могу разместить фрукт: " + fruit.getType());
            System.out.println("Я коробка типа: " + this.getBoxType());
        }

    }

    public boolean compare(Box anotherBox) {
        return (Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001f);
    }

    public float getWeight() {
        float boxWeight = 0.0f;
        for (T f : fruitBox) {
            boxWeight += f.getWeight();
        }
        return boxWeight;
    }

    // Пересыпаем фрукты из одной коробки в другую
    public void emptyBox(Box<T> targetBox) {
        if (this.boxType.equals(targetBox.getBoxType()) || (targetBox.getBoxType() == null)) {
            for (T fruit : fruitBox) {
                targetBox.addFruit(fruit);
            }
            fruitBox.clear();
        } else {
            System.out.println("Коробки разных типов!");
        }
    }

    public String getBoxType() {
        return boxType;
    }
}
