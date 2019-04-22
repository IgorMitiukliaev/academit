package ru.academit.mitiukliaev.lambda;

public class Person {
    private String name;
    private double age;

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public double getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "(Name = " + name + "| Age = " + age + ")";
    }

}
