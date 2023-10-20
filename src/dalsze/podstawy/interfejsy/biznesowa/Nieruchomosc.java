package dalsze.podstawy.interfejsy.biznesowa;

interface Nieruchomosc {
    double podatekStaly = 100.0; // wartość stała (zmienna statyczna)

    double obliczPodatek(); // metoda abstrakcyjna

    default void wyswietlPodatek() {  // metoda domyślna
        System.out.println("Podatek wynosi: " + obliczPodatek() + " zł.");
    }

    static double getPodatekStaly() {  // metoda statyczna
        return podatekStaly;
    }
}

