package dalsze.podstawy.interfejsy.zbiornik;

import java.math.BigDecimal;

public interface IZbiornik {
    void dolanieWody(BigDecimal ilosc);
    void odlanieWody(BigDecimal ilosc);
    void przelanieWody(Zbiornik zbiornik, BigDecimal ilosc);
}
