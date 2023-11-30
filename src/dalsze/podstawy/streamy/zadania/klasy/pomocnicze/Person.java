package dalsze.podstawy.streamy.zadania.klasy.pomocnicze;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private LocalDate birthDate;
    private double examScore;

    public Person(String name, LocalDate birthDate, double examScore) {
        this.name = name;
        this.age = LocalDate.now().getYear() - birthDate.getYear();
        this.birthDate = birthDate;
        this.examScore = examScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getExamScore() {
        return examScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Double.compare(examScore, person.examScore) == 0 && Objects.equals(name, person.name) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthDate, examScore);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age + ", birthdate: " + birthDate + "exam score: " + examScore;
    }
}
