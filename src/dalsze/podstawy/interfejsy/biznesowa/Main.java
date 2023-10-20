package dalsze.podstawy.interfejsy.biznesowa;

public class Main {
    public static void main(String[] args) {
        Dom dom = new Dom(500000.0, 2);
        dom.wyswietlPodatek();
        dom.wyswietlLiczbePieter();

        Grunt grunt = new Grunt(1000.0);
        grunt.wyswietlPodatek();
        grunt.wyswietlPowierzchnie();
    }
}

