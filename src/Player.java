public class Player {
    private String name;
    private Integer kills;
    private Integer id;

    public Player(Integer id) {
        this.id = id;
        this.kills = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public void decreaseKills(){
        this.kills--;
    }

    public void increaseKills(){
        this.kills++;
    }

    public void setName(String name) {
        this.name = name;
    }
}
