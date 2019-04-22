package ru.academit.mitiukliaev;

import ru.academit.mitiukliaev.lambda.Person;

import java.util.*;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("John", 32));
        list.add(new Person("Jane", 27));
        list.add(new Person("Victor", 36));
        list.add(new Person("Victor", 24));
        list.add(new Person("Victor", 12));
        list.add(new Person("Suzie", 25));
        list.add(new Person("Mary", 32));
        list.add(new Person("Charles", 14));
        list.add(new Person("Tiffany", 10));

        // список уникальных имен
        String uniqueNamesString = "Names: ";
        uniqueNamesString += list.stream()
                .map(x -> x.getName())
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(uniqueNamesString);

        OptionalDouble average = list.stream()
                .filter(person -> person.getAge() < 18)
                .mapToDouble(p -> p.getAge())
                .average();
        System.out.println(average);

        //получить Map, где ключи - имена, а значения - средний возраст
        Map<String, Double> personsByName = list.stream()
                .collect(Collectors.groupingBy(p -> p.getName(), Collectors.averagingDouble(p -> p.getAge())));
        System.out.println(personsByName);

        //получить людей в возрасте от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        list.stream()
                .filter(p -> p.getAge() < 45 && p.getAge() >= 20)
                .sorted((p1, p2) -> {
                    return (int) (p2.getAge() - p1.getAge());
                })
                .forEach(p -> System.out.println(p.getName()));
    }

}
