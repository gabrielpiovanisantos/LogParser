public class Player {
    private String name;
    private Integer kills;
    private Integer id;

    public Player(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
