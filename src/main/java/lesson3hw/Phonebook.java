package lesson3hw;

import java.util.*;

public class Phonebook {

    //Для упрощения доступа реализована как статическая переменная
    static List<PhonebookEntry> name_tel = new ArrayList<>();

    public Phonebook() {
    }

    static void addEntry(String name, Integer tel){

        name_tel.add(new PhonebookEntry(name,tel));
    }

    static void getEntry(String name){

        for(PhonebookEntry entry: name_tel){

            if (entry.getName().equals(name))
                    System.out.println(entry);
        }
    }

}
