package dalsze.podstawy.daty.employees;

//Stworz praconwika imie, data urodzenia
//Znajdz najmlodszego Pracownika
//Znajdz pracownikow ktorzy sa urodzeni po 11.04.2003
//Posortuj pracownikow po datach urodzenia

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", LocalDate.of(1990, 5, 15));
        Employee e2 = new Employee("Alice", LocalDate.of(1985, 11, 25));
        Employee e3 = new Employee("Bob", LocalDate.of(1995, 3, 10));
        Employee e4 = new Employee("Eva", LocalDate.of(2004, 9, 30));

        //Znajdz pracownikow ktorzy sa urodzeni po 11.04.2003
        System.out.println(Employee.employeesBornAfter(Employee.getExtension(), LocalDate.of(2003, 04, 11)));

        //Posortuj pracownikow po datach urodzenia
        System.out.println(Employee.sortedEmployees(Employee.getExtension()));
    }
}
