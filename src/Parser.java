
import java.io.*;

//classe responsavel por ler e parsear o arquivo .log

// o arquivo .log consiste de eventos
//para cada evento que representa uma morte há 3 números, o primeiro é o usuairo que cometeu a morte,
//o segundo do usuario assassinado e o terceiro é referente a como foi a morte
public class Parser {

    public static BufferedReader lerArquivo() {
        BufferedReader br = null;
        try {
            FileInputStream fstream = new FileInputStream("dados/games.log");
            br = new BufferedReader(new InputStreamReader(fstream));
            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return br;
    }



}
