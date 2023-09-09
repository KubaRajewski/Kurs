package testy.test2.zadanie2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Person {
    private String surname;
    private String name;
    private final String pesel;
    private final Date dateOfBirth;

    public static List<Person> extension = new ArrayList<>();

    public Person(String surname, String name, String pesel, Date dateOfBirth) {
        for (Person person : extension) {
            if (person.pesel.equals(pesel)){
                throw new IllegalArgumentException("Person with this PESEL already exists");
            }
        }

        this.surname = surname;
        this.name = name;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;

        extension.add(this);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFormattedDateOfBirth() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateOfBirth);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(pesel, person.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }
}
