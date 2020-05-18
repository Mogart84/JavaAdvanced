package lesson1hw.enums;

public class DayOfWeekMain {

    public static void main(String[] args) {
        getWorkingHours(DayOfWeek.SUNDAY);
    }

    public static void getWorkingHours(DayOfWeek dayOfWeek){
        int sum = 0;
        for(DayOfWeek dow:DayOfWeek.values()) {
            if(dow.compareTo(dayOfWeek)>=0) {
                sum += dow.getHours();
            }
        }

        if (sum == 0) {
            System.out.println("Сегодня выходной");
        }
        else System.out.println("Рабочих часов до конца недели: " + sum);
    }

}
