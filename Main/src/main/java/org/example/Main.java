package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        HashMap<Integer, List<User>> users = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.println("Введите имя пользователя " + i);
            String name = scanner.nextLine();
            System.out.println("Введите возраст пользователя " + i);
            int age = Integer.parseInt(scanner.nextLine());

            if(!users.containsKey(age)) {
                users.put(age, new ArrayList<>(List.of(new User(name, age))));
                continue;
            }
            users.get(age).add(new User(name,age));
        }

        System.out.println("\nВведите требуемый возраст");
        int age = Integer.parseInt(scanner.nextLine());
        Optional.ofNullable(users.get(age)).ifPresentOrElse(
                x -> x.forEach(System.out::println)
                ,() -> System.out.printf("Пользователь с возрастом '%d' не найден", age));

    }
}