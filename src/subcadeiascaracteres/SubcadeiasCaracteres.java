package subcadeiascaracteres;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author
 */
public class SubcadeiasCaracteres {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Iniciando algoritmo de busca de subcadeias de caracteres.\n");
        String jakarta = "", kualaLumpur = "";
        try {
            // Ler arquivos de DNA
            System.out.print("Lendo arquivos de DNA dos Vírus da Dengue Jakarta e Kuala Lumpur...");
            jakarta = lerArquivoDNA("/home/davidbrusius/projects/luiza_longo/"
                    + "EP1/DengueVirus2StrainBA05i_Jakarta.txt");
            kualaLumpur = lerArquivoDNA("/home/davidbrusius/projects/luiza_longo/"
                    + "EP1/DengueVirus3StrainTB55i_KualaLumpur.txt");
            System.out.println(" Ok");
        } catch (IOException ex) {
            System.err.println("Erro ao ler os arquivos de DNA, verifique se o "
                    + "arquivo existe e se o caminho para o arquivo está correto");
            System.exit(-1);
        }

        int distanciaMax = getDistanceFromUser();
        String[] padroesP = carregarPadroesP();
        List<Subcadeia> subcadeiasJakartaEncontradas = analisarSubcadeias(distanciaMax, padroesP, jakarta);
        List<Subcadeia> subcadeiasKualaLumpurEncontradas = analisarSubcadeias(distanciaMax, padroesP, kualaLumpur);
        System.out.println("Subcadeias encontradas para o Vírus Jakarta");
        mostrarResultados(subcadeiasJakartaEncontradas);
        System.out.println("\nSubcadeias encontradas para o Vírus Kuala Lumpur");
        mostrarResultados(subcadeiasKualaLumpurEncontradas);

        System.out.println("Fim");
    }

    public static String lerArquivoDNA(String path) throws IOException {
        String line, columns[];
        String cadeiaDNA = "";
        BufferedReader br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null) {
            columns = line.split(" ");
            cadeiaDNA = cadeiaDNA.concat(columns[1] + columns[2] + columns[3]
                    + columns[4] + columns[5] + columns[6]);
        }

        return cadeiaDNA;
    }

    public static String[] carregarPadroesP() {
        String[] padroesP = new String[]{"actgcttctg", "aggaggctgg", "tacatgccat", "cctcagcatc", "gcaacgttca", "gacattgact"};

        return padroesP;
    }

    private static int getDistanceFromUser() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the maximum distance to be considered: ");
        return keyboard.nextInt();
    }

    private static int medirDistancia(int distanciaMax, String subcadeia, String padraoP) {
        if(subcadeia.equals(padraoP)) return 0;
        if(distanciaMax == 0) return -1;

        int distancia = 0;
        char[] charSubcadeia = subcadeia.toCharArray();
        char[] charPadraoP = padraoP.toCharArray();
        for (int i = 0; i < charSubcadeia.length; i++) {
            if (charSubcadeia[i] != charPadraoP[i]) {
                distancia++;
            }            
        }

        return distancia;
    }

    private static List<Subcadeia> analisarSubcadeias(int distanciaMax, String[] padroesP, String DNA) {
        List<Subcadeia> subcadeiasEncontradas = new ArrayList<Subcadeia>();
        for (int c = 0; c < padroesP.length; c++) {
            String padraoP = padroesP[c];
            for (int i = 0; i < DNA.length() - padraoP.length() + 1; i++) {
                String subcadeia = DNA.substring(i, padraoP.length() + i);
                int distancia = medirDistancia(distanciaMax, subcadeia, padraoP);
                if(distancia >= 0 && distancia <= distanciaMax) {
                    subcadeiasEncontradas.add(new Subcadeia(i, subcadeia, padraoP, distancia));
                }
            }
        }

        return subcadeiasEncontradas;
    }

    private static void mostrarResultados(List<Subcadeia> listaSubcadeias) {
        for(Subcadeia subcadeia : listaSubcadeias) {
            System.out.println(subcadeia.toString());
        }
    }
}
