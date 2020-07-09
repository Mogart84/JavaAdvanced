package lesson7prof;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        start(MyTest.class);

    }

    private static void start(Class testClass) {

        Method[] methods = testClass.getDeclaredMethods();
        ArrayList<Method> mOrder = new ArrayList<>();
        boolean isBefore = false;
        boolean isAfter = false;

        for (Method m : methods) {

            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (isBefore) throw new RuntimeException("Больше 1 BeforeSuite!");
                isBefore = true;
                addMethod(mOrder,m);
            }

            if (m.isAnnotationPresent(AfterSuite.class)) {
                if (isAfter) throw new RuntimeException("Больше 1 AfterSuite!");
                isAfter = true;
                addMethod(mOrder,m);
            }

            if(m.isAnnotationPresent(Test.class)){
                addMethod(mOrder,m);
            }

        }

        //Выводим методы из ArrayList, где они хранятся в отсортированном порядке
        for (Method m:mOrder) {
            try {
                m.invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

    //Сохраняет методы в отсортированном по priority порядке
    private static void addMethod(ArrayList<Method> arrMethods, Method m){

        int inPriority = 0;
        int currPriority = 0;

        if (m.isAnnotationPresent(BeforeSuite.class)) { inPriority = m.getAnnotation(BeforeSuite.class).priority();}
        if (m.isAnnotationPresent(AfterSuite.class)) { inPriority = m.getAnnotation(AfterSuite.class).priority();}
        if (m.isAnnotationPresent(Test.class)) { inPriority = m.getAnnotation(Test.class).priority();}

        if (arrMethods.size() == 0) {
            arrMethods.add(m);
            return;
        }

        for (int i = 0; i < arrMethods.size(); i++) {
            if (arrMethods.get(i).isAnnotationPresent(BeforeSuite.class)) {
                currPriority = arrMethods.get(i).getAnnotation(BeforeSuite.class).priority();
            }
            if (arrMethods.get(i).isAnnotationPresent(AfterSuite.class)) {
                currPriority = arrMethods.get(i).getAnnotation(AfterSuite.class).priority();
            }
            if (arrMethods.get(i).isAnnotationPresent(Test.class)) {
                currPriority = arrMethods.get(i).getAnnotation(Test.class).priority();
            }

            if (inPriority <= currPriority) {
                arrMethods.add(i,m);
                return;
            }
        }

        arrMethods.add(m);
    }

}
