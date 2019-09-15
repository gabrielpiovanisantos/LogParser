import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> strs = Parser.readFile();
        ArrayList<Game> games = new ArrayList<Game>();
        strs = Parser.excludeTime(strs);

        games = Parser.coreMethod(strs);

//        System.out.println(Mean.getById(22));
    }
}
