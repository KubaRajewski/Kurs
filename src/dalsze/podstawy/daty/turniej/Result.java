package dalsze.podstawy.daty.turniej;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Result {
    private final Player player;
    private final Tournament tournament;
    private final int place;
    private final double points;

    public static List<Result> extension = new ArrayList<>();

    public Result(Player player, Tournament tournament, int place, double points) {

        if (player == null || tournament == null) {
            throw new IllegalArgumentException();
        }

        this.player = player;
        this.tournament = tournament;
        this.place = place;
        this.points = points;



        player.getResults().add(this);
        tournament.getResults().add(this);
    }

    public Player getPlayer() {
        return player;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public int getPlace() {
        return place;
    }

    public double getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result result)) return false;
        return place == result.place && Double.compare(result.points, points) == 0 && Objects.equals(player, result.player) && Objects.equals(tournament, result.tournament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, tournament, place, points);
    }

    @Override
    public String toString() {
        return "Player: " + player.getName() + " " + player.getSurname() + ", nick: " + player.getNick() + ", Tournament: " + tournament.getName() + ", Place: " + place + ", Points: " + points;
    }
}
