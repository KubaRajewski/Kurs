package dalsze.podstawy.wielkie.liczby.system.bankowy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Client {
    private final String name;
    private final String surname;
    private final BigDecimal id;
    private final static int NUMBER_OF_DIGITS_IN_ID = 3;

    private List<Account> accounts = new ArrayList<>();

    private static List<Client> extension = new ArrayList<>();

    public Client(String name, String surname) {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("name or surname is null");
        }

        this.name = name;
        this.surname = surname;
        this.id = generateNewId();

        extension.add(this);
    }

    private BigDecimal generateNewId() {
        Random rand = new Random();
        StringBuilder numberBuilder = new StringBuilder();
        numberBuilder.append(rand.nextInt(9) + 1);

        for (int i = 1; i < NUMBER_OF_DIGITS_IN_ID; i++) {
            numberBuilder.append(rand.nextInt(10));
        }

        BigDecimal idNumber = new BigDecimal(numberBuilder.toString());

        idNumber = idNumber.setScale(0, RoundingMode.DOWN);

        for (Client c : extension) {
            if(Objects.equals(c.getId(), idNumber)) {
                return generateNewId();
            }
        }

        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public static List<Client> getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", id: " + id + ", accounts: " + accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(id, client.id) && Objects.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accounts);
    }
}
