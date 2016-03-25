package subcadeiascaracteres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class SubcadeiasCaracteres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Ler arquivos de DNA
            String jakarta = lerArquivoDNA("/home/davidbrusius/projects/luiza_longo/EP1/DengueVirus2StrainBA05i_Jakarta.txt");
            String kualaLumpur = lerArquivoDNA("/home/davidbrusius/projects/luiza_longo/EP1/DengueVirus3StrainTB55i_KualaLumpur.txt");
        } catch (IOException ex) {
            Logger.getLogger(SubcadeiasCaracteres.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
    }

    public static String lerArquivoDNA(String path) throws IOException {
        FileReader file = new FileReader(path);
        BufferedReader reader = new BufferedReader(file);
        
        String fileContent = "";
        String line = reader.readLine();
        while (line != null) {
            fileContent += line;
            line = reader.readLine();
        }

        return fileContent;
    }
}
