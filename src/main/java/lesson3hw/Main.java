package lesson3hw;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Исходный список слов
        String[] init_lst = {"Арбуз","Дыня","Арбуз","Кабачок","Томат","Дыня","Арбуз","Патиссон","Свекла","Баклажан"};
        List<String> lst = new ArrayList<>(Arrays.asList(init_lst));
        System.out.println("Исходный список слов: " + lst);

        // Только уникальные слова
        HashSet<String> hst = new HashSet<>(lst);
        System.out.println("Только уникальные слова: " + hst);

        // Cтруктура для хранения соответствий "слово - количество вхождений"
        HashMap<String,Integer> hm = new HashMap<String,Integer>();

        // Счетчик количества вхождений каждого слова в lst
        Integer cnt;

        // Проходим по исходному списку, вносим в hm если встретили в первый раз, инкрементируем счётчик если не в первый
        for (String str: lst) {
            cnt = hm.get(str);
            hm.put(str,cnt == null ? 1 : cnt +1);
        }

        System.out.println("Количество слов в исходном списке: " + hm);

        //Телефонная книга. Для простоты методы add, get реализованы как статические

        Phonebook.addEntry("Johns",123456781);
        Phonebook.addEntry("Smith",243456180);
        Phonebook.addEntry("Carter",867456789);
        Phonebook.addEntry("Kennedy",347456682);
        Phonebook.addEntry("Bush",367456777);
        Phonebook.addEntry("Carter",157456710);

        Phonebook.getEntry("Carter");

    }

}
