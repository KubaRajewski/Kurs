package dalsze.podstawy.daty.turniej;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private String surname;
    private String nick;

    private List<Result> results = new ArrayList<>();

    private static List<Player> extension = new ArrayList<>();

    public Player(String name, String surname, String nick) {
        this.name = name;
        this.surname = surname;
        this.nick = nick;

        extension.add(this);
    }

    //TODO Napisz metode która znajduje najlepszego gracza z danego miesiąca.
    public static Player bestPlayerCertainMonth(List<Player> players, Month month) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Player bestPlayer = players.get(0);

        for (Player player : players) {
            if (player.getPointsCertainMonth(month) > bestPlayer.getPointsCertainMonth(month)) {
                bestPlayer = player;
            }
        }

        return bestPlayer;
    }

    private int getPointsCertainMonth(Month month) {
        int points = 0;

        for (Result result : results) {
            if (result.getTournament().getDate().getMonth() == month) {
                points += result.getPoints();
            }
        }

        return points;
    }

    //TODO Napisz metode ktora znajduje najlepszego gracza z danego okresu czasu.
    public static Player bestPlayerCertainPeriod(List<Player> players, LocalDate beginning, LocalDate end) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Player bestPlayer = players.get(0);

        for (Player player : players) {
            if (player.getPointsCertainPeriod(beginning, end) > bestPlayer.getPointsCertainPeriod(beginning, end)) {
                bestPlayer = player;
            }
        }

        return bestPlayer;
    }

    private int getPointsCertainPeriod(LocalDate beginning, LocalDate end) {
        int points = 0;

        for (Result result : results) {
            if (result.getTournament().getDate().isAfter(beginning) && result.getTournament().getDate().isBefore(end)) {
                points += result.getPoints();
            }
        }

        return points;
    }

    //TODO Napisz metode ktora znajduje wszystkich graczy z danego okresu czasu.
    public static List<Player> playersCertainPeriod(List<Player> players, LocalDate beginning, LocalDate end) {
        if (players == null) {
            throw new IllegalArgumentException();
        }

        List<Player> playersCertainPeriod = new ArrayList<>();

        for (Player player : players) {
            if (player.getPointsCertainPeriod(beginning, end) >= 0) {
                playersCertainPeriod.add(player);
            }
        }

        return playersCertainPeriod;
    }

    //TODO Napisz metoda która zwraca liste graczy którzy zajeli 1 miejsce przynajmniej w dwoch roznych miesiącach
    public static List<Player> hadCertainPositionInNDifferentMonths(List<Player> players, int place, int differentMonths) {
        if (players == null) {
            throw new IllegalArgumentException();
        }

        List<Player> List = new ArrayList<>();

        for (Player player : players) {
            if (getUniqueMonthsForPlace(player, place).size() >= differentMonths) {
                List.add(player);
            }
        }

        return List;
    }

    public static Set<Month> getUniqueMonthsForPlace(Player player, int place) {
        Set<Month> uniqueMonths = new HashSet<>();

        for (Result result : player.getResults()) {
            if (result.getPlace() == place) {
                uniqueMonths.add(result.getTournament().getDate().getMonth());
            }
        }

        return uniqueMonths;
    }

    // Druga wersja ze streamem
    public static List<Player> hadCertainPositionInNDifferentMonthsSTREAM(List<Player> players, int place, int differentMonths) {
        if (players == null) {
            throw new IllegalArgumentException();
        }
        return players.stream()
                .filter(player -> player.getResults().stream()
                        .filter(result -> result.getPlace() == place)
                        .map(result -> result.getTournament().getDate().getMonthValue() + "-" + result.getTournament().getDate().getYear())
                        .distinct()
                        .count() >= differentMonths)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static List<Player> getExtension() {
        return extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Objects.equals(name, player.name) && Objects.equals(surname, player.surname) && Objects.equals(nick, player.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, nick);
    }

    @Override
    public String toString() {
        return name + " " + surname + ", nick: " + nick;
    }
}
