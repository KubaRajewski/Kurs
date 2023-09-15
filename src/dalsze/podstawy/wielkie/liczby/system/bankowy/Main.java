package dalsze.podstawy.wielkie.liczby.system.bankowy;

// Stworz krotki system bankowy oparty na klasie BigDecimal. Stworz klase Klient
// i Konto. Klient moze miec wiele kont. Konto powinno miec metody
// deposit(BigDecimal b) i withdraw(BigDecimal b). Przeprowadz symulacje
// wplacania i wyplacania pieniedzy.
// Dodaj swoje metody pozwalajace na ciekawe operacje na koncie np naliczenie
// odsetek gdy stan konta jest ujemny, dodanie odsetek gdy ktos ma duzo pieniedzy itp
// Znajdz konto ktore ma najwiecej hajsu
// Znajdz konto ktore miało najwiecej transakcji
// Znajdz znajdz wszystkie konta z ujemnym balansem

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Client c1 = new Client("Jan", "Kowalski");
        Client c10 = new Client("Jan", "Kowalski"); // new client with the same name and surname but different id
        Client c2 = new Client("Anna", "Nowak");
        Client c3 = new Client("Andrzej", "Wisniewski");
        Client c4 = new Client("Maria", "Dabrowska");
        Client c5 = new Client("Piotr", "Zawadzki");

        // Each has at least one account
        Account a1 = new Account(c1);
        Account a2 = new Account(c2);
        Account a3 = new Account(c3);
        Account a4 = new Account(c4);
        Account a5 = new Account(c5);

        // some have more than one
        Account a6 = new Account(c1);
        Account a7 = new Account(c1);
        Account a8 = new Account(c1);

        Account a9 = new Account(c2);

        Account a10 = new Account(c3);
        Account a11 = new Account(c3);

//        Client.getExtension().forEach(System.out::println);

        // depositing and withdrawing money
        a1.deposit(new BigDecimal("1000"));
        a1.withdraw(new BigDecimal("100"));

        System.out.println(a1.getBalance()); // 900

        // transfering money
        a1.transfer(a2.getNumber(), new BigDecimal("100"));

        System.out.println(a1.getBalance()); // 800
        System.out.println(a2.getBalance()); // 100

    }
}
