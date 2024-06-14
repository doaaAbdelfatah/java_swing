public class StringDemo {
    public static void main(String[] args) {
        String name = "Mohamed";
//        System.out.println(name.substring(0,name.length()-2));

        System.out.println(name.indexOf("h")); // 2
        System.out.println(name.indexOf("x")); // -1

        System.out.println(name.contains("m"));
        System.out.println(name.contains("x"));


        System.out.println("----------------");

        String [] arr = new String[4];
        arr[0] = "Ahmed";
        arr[1]="Dina";

        Employee arrEmp [] = new Employee[3];

        for (int i = 0; i < arrEmp.length; i++) {
            arrEmp[i] = new Employee();
            arrEmp[i].name = "Ahmed";
            arrEmp[i].job = "Sales";
        }

        for (Employee e :arrEmp){
            System.out.println(e.name);
        }



    }


}
class Employee {
    String name ;
    String job;
}