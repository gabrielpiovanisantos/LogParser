import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Game {
    private ArrayList<Player> players;
    private Map<Mean,Integer> deaths;
    private Integer id;

    public Game(Integer id) {
        this.id = id;
        this.players = new ArrayList<Player>(Collections.singletonList(new Player(1022)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
