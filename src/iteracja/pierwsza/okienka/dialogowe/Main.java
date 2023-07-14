package iteracja.pierwsza.okienka.dialogowe;
import java.io.IOException;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
// Wprowadz za pomoca okienka dialogowego jakis napis. Jesli jego dlugosc jest wieksza niz 15, wyswietl
// za pomoca okienka napis ze jest za dlugi tekst, a jesli nie to wyswietl ze jest ok.

        String napis = JOptionPane.showInputDialog("Podaj napis: ");
        if (napis.length() > 15) {
            JOptionPane.showMessageDialog(null, "Za długi tekst");
        } else {
            JOptionPane.showMessageDialog(null, "OK");
        }


// Za pomoca JOPtionPane wczytaj 3 liczby i wyswietl ta ktora jest najwieksza

        String liczbaA = JOptionPane.showInputDialog("Liczba 1: ");
        int a = Integer.parseInt(liczbaA);
        String liczbaB = JOptionPane.showInputDialog("Liczba 2: ");
        int b = Integer.parseInt(liczbaB);
        String liczbaC = JOptionPane.showInputDialog("Liczba 3: ");
        int c = Integer.parseInt(liczbaC);

        int max = a;
        if (b > max) {
            max = b;
        }   if (c > max) {
            max = c;
        }
        JOptionPane.showMessageDialog(null, "Największa liczba to: " + max);

// Za pomoc JOptionpane (confrim dialog) zadaj pytanie uzytkownikowi o to czy chce zlozyc zamowienie.
// W zaleznosci od zaznaczonej odpowiedzi wyswietl odpowiedni napis


        int dialogResult = JOptionPane.showConfirmDialog(null, "Czy chcesz złożyć zamówienie?",
                "Potwierdzenie", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Zamówienie zostało złożone.");
        } else {
            JOptionPane.showMessageDialog(null, "Zamówienie nie zostało złożone.");
        }


//Za pomoca JOPtionpane uzytkwonik podaje imiona. Dopoki nie poda tomek to moze je wprowadzac dalej i wypisujemy je na konsoli
//Gdy wpisze Tomek przerywamy wprowadzanie i podajemy komunikat w okienku dialogowym ze wpisano brzydkie imie.

        String imie = "";
        while (!imie.equals("Tomek")) {
            imie = JOptionPane.showInputDialog("Podaj imię: ");
            System.out.println(imie);
        }
        JOptionPane.showMessageDialog(null, "Wpisałeś brzydkie imię.");

//Wpisujemy imiona za pomoca JOPtionPane tak dlugo az uzytkownik nie zrezygnuje. Przypisujemy te wartosci do wczesniej utworzonej
//zmiennej typu String, wyswietlamy ja na koncu

        String imiona = "";
        String imie2 = "";
        while (!(imie2 = JOptionPane.showInputDialog("Podaj imię: ")).equals("")) {
            imiona += imie2 + " ";
        }
        JOptionPane.showMessageDialog(null, imiona);

//Uzytkownik wybiera dwie opcje, tak lub nie dopoki nie nacisnie cancel.
// Policz czy uzytkownik wybral wiecej razy tak, nie czy bylo ich tyle samo.

        int tak = 0;
        int nie = 0;
        int dialogResult2 = 0;
        while (dialogResult2 != JOptionPane.CANCEL_OPTION) {
            dialogResult2 = JOptionPane.showConfirmDialog(null, "Tak czy nie?",
                    "",JOptionPane.YES_NO_CANCEL_OPTION);
            if (dialogResult2 == JOptionPane.YES_OPTION) {
                tak++;
            } else if (dialogResult2 == JOptionPane.NO_OPTION) {
                nie++;
            }
        }
        if (tak > nie) {
            JOptionPane.showMessageDialog(null, "Więcej razy wybrałeś tak: " + tak + " razy.");
        } else if (nie > tak) {
            JOptionPane.showMessageDialog(null, "Więcej razy wybrałeś nie: "+ nie + " razy.");
        } else {
            JOptionPane.showMessageDialog(null, "Wybrałeś tyle samo razy tak i nie: " + tak + " razy.");
        }
    }
}
