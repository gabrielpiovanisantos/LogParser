import java.util.ArrayList;
import java.util.Map;

public class Game {
    private ArrayList<Player> players;
    private Map<Mean,Integer> deaths;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Map<Mean, Integer> getDeaths() {
        return deaths;
    }

    public void setDeaths(Map<Mean, Integer> deaths) {
        this.deaths = deaths;
    }
}
