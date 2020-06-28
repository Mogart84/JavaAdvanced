package lesson3hw;

//Класс, инкапсулирующий одну запись в телефонной книге

public class PhonebookEntry {

    private String name;
    private Integer tel;

    public PhonebookEntry(String name, Integer tel) {
        this.name = name;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Фамилия: " + name + "\t\t Телефон: " + tel;
    }

    public String getName() {
        return name;
    }

    public Integer getTel() {
        return tel;
    }
}
