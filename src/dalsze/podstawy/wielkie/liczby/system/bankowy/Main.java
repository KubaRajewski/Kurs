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
        Client c2 = new Client("Anna", "Nowak");

        Account a1 = new Account(c1, new BigDecimal("1000"));
        Account a2 = new Account(c1, new BigDecimal("10000"));
        Account a3 = new Account(c1, new BigDecimal("5000"));
        Account a4 = new Account(c2, BigDecimal.ZERO);

        //deposit and withdraw
        System.out.println("Deposit and withdraw:");
        a1.deposit(new BigDecimal("1000"));
        a1.withdraw(new BigDecimal("500"));
        System.out.println("1000-500: " + a1.getBalance() + "\n");

        //transfer
        System.out.println("Transfer:");
        a1.transfer(a4, new BigDecimal("100"));
        System.out.println("1000-500-100: " + a1.getBalance());
        System.out.println("0+100: " + a4.getBalance() + "\n");

        //Credit
        System.out.println("Interest:");
        a1.withdraw(new BigDecimal("500"));
        // balance wynosi -100
        // credit wynosi 1000 - 100 czyli 900
        System.out.println(a1.getBalance());
        System.out.println(a1.getCredit() + "\n");

        //interest
        Account.checkForInterest(); // ta funkcja jesli sprawia ze jesli ktos ma ujemny balans to nalicza odsetki
        System.out.println(a1.getBalance());
        System.out.println(a1.getCredit() + "\n");
        // wczesniej na a1 bylo -100zl balance i 900zl credit a teraz jest -105zl balance i 895zl credit

        //taxing the rich
        System.out.println("Taxing the rich:");
        a2.deposit(new BigDecimal("1000000"));
        System.out.println("Przed: " + a2.getBalance());
        Account.taxTheRich(); // ta funkcja sprawia ze jesli ktos ma wiecej niz 1000000zl to zabiera mu 10% z tego co ma
        System.out.println("Po " + a2.getBalance() + "\n");

        //find account with the most money
        System.out.println("Account with the most money:");
        System.out.println(Account.findAccountWithTheMostMoney(Account.getExtension()) + "\n");

        //find account with the most transactions
        System.out.println("Account with the most transactions:");
        System.out.println(Account.accountWithMostTransactions(Account.getExtension()) + "\n");

        //find all accounts with negative balance
        a3.withdraw(new BigDecimal("700"));
        System.out.println("Accounts with negative balance:");
        System.out.println(Account.accountsWithDebt(Account.getExtension()) + "\n");

        // show all transactions from one account:
        System.out.println("Transactions from one account:");
        System.out.println(a1.getTransactions() + "\n");
    }
}
