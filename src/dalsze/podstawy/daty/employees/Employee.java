package dalsze.podstawy.daty.employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private final String name;
    private final LocalDate birthDate;

    public static List<Employee> extension = new ArrayList<>();

    public Employee(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;

        extension.add(this);
    }

    //TODO Znajdz najmlodszego Pracownika
    public static Employee youngestEmployee(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Employee youngest = employees.get(0);

        for (Employee employee : employees) {
            if (employee.getBirthDate().isAfter(youngest.getBirthDate())) {
                youngest = employee;
            }
        }

        return youngest;
    }

    //TODO Pracownicy urodzeni po danej dacie:
    public static List<Employee> employeesBornAfter(List<Employee> employees, LocalDate date) {
        if (employees == null) {
            throw new IllegalArgumentException();
        }

        List<Employee> employeesBornAfter = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getBirthDate().isAfter(date)){
                employeesBornAfter.add(employee);
            }
        }

        return employeesBornAfter;
    }

    //TODO sortowanie po dacie urodzenia
    public static List<Employee> sortedEmployees(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException();
        }

        List<Employee> copy = new ArrayList<>(employees);
        copy.sort(Comparator.comparing(Employee::getBirthDate));

        return copy;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public static List<Employee> getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return name +  ", Birthdate: " + birthDate;
    }
}
