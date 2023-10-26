package testy.test3.zadanie2.test.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private String city;
    private int age;

    public static List<Person> extension = new ArrayList<>();

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public static List<Person> getExtension() {
        return extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, age);
    }

    @Override
    public String toString() {
        return name + ", age: " + age + ", from: " + city;
    }
}
