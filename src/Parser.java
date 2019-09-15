import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//classe responsavel por ler e parsear o arquivo .log

// o arquivo .log consiste de eventos
//para cada evento que representa uma morte há 3 números, o primeiro é o usuairo que cometeu a morte,
//o segundo do usuario assassinado e o terceiro é referente a como foi a morte
public class Parser {

    //ler o arquivo e retorna um conjunto contendo as suas linhas
    public static ArrayList<String> readFile() {
        BufferedReader br;
        ArrayList<String> strs = new ArrayList<>();

        try {
            FileInputStream fstream = new FileInputStream("src/dados/games.log");
            br = new BufferedReader(new InputStreamReader(fstream));
            String st;
            while ((st = br.readLine()) != null)
                strs.add(st);

            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return strs;

    }

    //exclui horario das linhas
    public static ArrayList<String> excludeTime(ArrayList<String> strs) {
        ArrayList<String> retStrs = new ArrayList<>();

        String horario = "\\d{1,3}:\\d{2}";
        String replace = "";
        Pattern p = Pattern.compile(horario);
        for (String str : strs) {
            Matcher m = p.matcher(str);
            retStrs.add(m.replaceAll(replace));
        }

        return retStrs;
    }

    // metodo que verifica se tem mais que uma palavra, se tem, retorna a primeira, se não retorna ela mesma
//    public static String getFirstWord(String str) {
//        int index = str.indexOf(' ');
//        if (index > -1) {
//            return str.substring(0, index); // .
//        } else {
//            return str;
//        }
//    }

    //metodo principal
    public static ArrayList<Game> coreMethod(ArrayList<String> strs) {
        ArrayList<Game> games = new ArrayList<>();
        for (String str : strs) {
            String[] words = str.trim().split(" ", 2);
            switch (words[0]) {
                case "InitGame:":// instancia um novo jogo
                    games.add(new Game(games.size()));
                    break;
                case "Death:":
                    String[] evento = words[1].trim().split(" ");
                    Integer causa = Integer.parseInt(evento[2].replace(":", ""));// a causa da morte
                    // se essa causa ja aconteceu, incrementa a contagem, se não, insere
                    if (games.get(games.size() - 1).getDeaths().containsKey(Mean.getById(causa))) {
                        games.get(games.size() - 1).getDeaths().put(Mean.getById(causa),
                                games.get(games.size() - 1).getDeaths().get(Mean.getById(causa)) + 1);
                    } else {
                        games.get(games.size() - 1).getDeaths().put(Mean.getById(causa), 1);
                    }
                    break;
                case "ClientConnect:":
                    Player player = new Player(games.size());
                    games.get(games.size() - 1).getPlayers().add(player);

                    break;
                case "ClientUserinfoChanged:":
                    evento = words[1].trim().split(" ", 2);
                    String nome = getName(evento[1]);
                    int playerAtual = Integer.parseInt(evento[0]) - 1;
                    if (games.get(games.size() - 1).getPlayers().size() > playerAtual)
                        games.get(games.size() - 1).getPlayers().get(playerAtual).setName(nome);
                    break;
                case "score:":
                    evento = words[1].trim().split(" ");
                    playerAtual = Integer.parseInt(evento[6]) - 1;
                    Integer killsAtual = Integer.parseInt(evento[0]);
                    games.get(games.size()-1).getPlayers().get(playerAtual).setKills(killsAtual);
                    games.get(games.size()-1).playersToString();
                default:
                    break;
            }
        }
        return games;
    }

    private static String getName(String word) {
        String[] strs = word.split("n\\\\");
        strs = strs[1].split("\\\\t");
        return strs[0];
    }
}
