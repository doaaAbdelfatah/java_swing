public class StringDemo {
    public static void main(String[] args) {
        String name = "Mohamed";
//        System.out.println(name.substring(0,name.length()-2));

        System.out.println(name.indexOf("h")); // 2
        System.out.println(name.indexOf("x")); // -1

        System.out.println(name.contains("m"));
        System.out.println(name.contains("x"));
    }
}
