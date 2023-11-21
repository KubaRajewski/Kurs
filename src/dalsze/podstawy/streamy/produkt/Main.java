package dalsze.podstawy.streamy.produkt;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Produkt p1 = new Produkt("nazwa1", new BigDecimal("10"), 12, 4);
        Produkt p2 = new Produkt("nazwa", null, 12, 4);

        System.out.println(Produkt.najdrozszyProdukt(List.of(p1, p2)));

    }
}
