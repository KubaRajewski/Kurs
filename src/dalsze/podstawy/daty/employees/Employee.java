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

    // Pracownicy urodzeni po danej dacie:
    public static List<Employee> employeesBornAfter(List<Employee> employees, LocalDate date) {
        if (employees == null) {
            throw new IllegalArgumentException();
        }

        List<Employee> employeesBornAfter = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.birthDate.isAfter(date)){
                employeesBornAfter.add(employee);
            }
        }

        return employeesBornAfter;
    }

    // sortowanie po dacie urodzenia
    public static List<Employee> sortedEmployees(List<Employee> employees) {
        List<Employee> copy = new ArrayList<>(employees);

        Collections.sort(employees, Comparator.comparing(Employee::getBirthDate));
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
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
