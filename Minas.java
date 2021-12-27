import java.util.Random;
import java.util.Scanner;

public class Minas {

    private boolean[][] matrizBooleana;
    private int[][] matrizInteira;

    public Minas(int m, int n, float p) {
        this.matrizBooleana = gerarMatrizBooleana(m, n, p);
        this.matrizInteira = gerarMatrizInteira();
    }

    private boolean[][] gerarMatrizBooleana( int m, int n, float p) {
        boolean[][] matrizBooleana = new boolean[m][n];

        Random aleatorio = new Random();

        for (int linha = 0; linha < m; linha++) {
            for (int coluna = 0; coluna < n; coluna++) {

                if (aleatorio.nextDouble() <= p) {  // Para gerar baseado na probabilidade
                    matrizBooleana[linha][coluna] = true;
                }

                else {
                    matrizBooleana[linha][coluna] = false;
                }
            }
        }

        return matrizBooleana;
    }

    private boolean contarBombas(int i, int j) {
        /*
        Esse método vai ser utilizado para retornar se o elemento i, j contém bomba,
        ele é utilizado para que no método gerarMatrizIntera a gente possa iterar
        no tabuleiro sem erros de OutOfIndex
        */
        if ( i < 0 || j < 0 || i >= matrizBooleana.length || j >= matrizBooleana[i].length) {
            return false;
        }

        return matrizBooleana[i][j];
    }

    private int[][] gerarMatrizInteira () {
        int[][] matrizInteira = new int[matrizBooleana.length][matrizBooleana[0].length];

        int contadorDeBombas = 0;

        for (int linha = 0; linha < matrizBooleana.length; linha ++) {
            for (int coluna =  0; coluna < matrizBooleana[linha].length; coluna++) {

                // Se o quadrado não for bomba
                if (!contarBombas(linha, coluna)) {
                    /*
                    Checando em volta do quadrado:
                        Para cara elemento i, j ele precisa checar por bombas em:
                            i + (-1, 0, 1), j (-1, 0, 1)

                        Pois dessa forma ele checa todos os quadrados em volta, por isso
                        do loop de -1 a 1. É mais facil que estrever um monte de if na mão
                    */
                    for (int i = -1; i <= 1; i++){
                        for (int j = -1; j <= 1; j++){
                            if (contarBombas(linha + i, coluna + j)) {
                                contadorDeBombas ++;
                            }
                        }
                    }
                }

                else {
                    contadorDeBombas = -1; // Valor pré definido para bombas
                }

                matrizInteira[linha][coluna] = contadorDeBombas;
                contadorDeBombas = 0;
            }
        }
        return matrizInteira;
    }

    public void imprimirMatrizes() {

        for (int linha = 0; linha < matrizBooleana.length; linha ++) {
            // Imprimindo  a linha da matriz booleana
            for (int coluna =  0; coluna < matrizBooleana[linha].length; coluna++) {
                if (matrizBooleana[linha][coluna]) {
                    System.out.print("*");
                }

                else {
                    System.out.print(".");
                }
            }

            System.out.print("\t");

            // Imprimindo a linha da matriz inteira
            for (int coluna =  0; coluna < matrizInteira[linha].length; coluna++) {
                if (matrizInteira[linha][coluna] != -1) {
                    System.out.print(matrizInteira[linha][coluna]);
                }

                else {
                    System.out.print("*");
                }
            }

            System.out.println(); // Para mudar de linha
        }

    }

    public static void main( String args[] ) {
        Scanner input = new Scanner(System.in);

        // m, n e p
        System.out.println("Digite o valor de m: ");
        int m = input.nextInt();

        System.out.println("Digite o valor de n: ");
        int n = input.nextInt();

        System.out.println("Digite o valor de p (0 <= p <= 1): ");
        float p = input.nextFloat();  // Como p é uma probabilidade convencionei que ele deve ser entre 0 e 1.
        //

        // Gestão de erros
        while(p < 0 || p > 1) {
            System.out.println("p deve estar contido entre 0 e 1 por ser uma probabilidade");
            System.out.println("Digite o valor de p(0 <= p <= 1): ");
            p = input.nextFloat();
        }
        //

        input.close();
        System.out.println();  // Só para o output ficar mais agradavel

        Minas minas = new Minas(m, n, p);

        minas.imprimirMatrizes();
    }
}
