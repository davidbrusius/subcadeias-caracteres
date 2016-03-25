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
        String line, columns[];
        String cadeiaDNA = "";
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null) {
            columns = line.split(" ");
            cadeiaDNA = cadeiaDNA.concat(columns[1] + columns[2] + columns[3] +
                    columns[4] + columns[5] + columns[6]);
        }

        return cadeiaDNA;
    }
}
