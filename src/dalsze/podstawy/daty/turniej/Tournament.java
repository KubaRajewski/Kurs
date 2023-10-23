package dalsze.podstawy.daty.turniej;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tournament {
    private final String name;
    private final double entryFee;
    private final LocalDate date;
    private final List<Result> results = new ArrayList<>();

    private static List<Tournament> extension = new ArrayList<>();

    public Tournament(String name, double entryFee, LocalDate date) {
        this.name = name;
        this.entryFee = entryFee;
        this.date = date;

        extension.add(this);
    }

    public String getName() {
        return name;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Result> getResults() {
        return results;
    }

    public static List<Tournament> getExtension() {
        return extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tournament that)) return false;
        return Double.compare(that.entryFee, entryFee) == 0 && Objects.equals(name, that.name) && Objects.equals(date, that.date) && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, entryFee, date, results);
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "name='" + name + '\'' +
                ", entryFee=" + entryFee +
                ", date='" + date + '\'' +
                ", results=" + results +
                '}';
    }
}
