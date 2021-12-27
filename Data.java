import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {  // Construtor
        this.mes = checaMes(mes);  // Precisa ser inicado antes do dia para a verificação
        this.dia = checaDia(dia);
        this.ano = ano;
    }

    private int checaMes(int mes) {
        if(mes > 12) {
            System.err.printf("Mês incorreto, valor padrão 1 foi aplicado \n");
            return 1;
        }

        return mes;
    }

    private int checaDia(int dia) {
        int [] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  // Para verificação se o dia condiz com o mês

        if(dia >  diasPorMes[mes - 1]){
            System.err.printf(String.format("Dia incorreto, o mes %02d possui %02d dias, valor padrão 1 foi aplicado \n", mes, dia));
            return 1;
        }

        return dia;
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Lendo a primeira data
        System.out.println("Digite o dia da primeira data: ");
        int dia = input.nextInt();

        System.out.println("Digite o mes da primeira data: ");
        int mes = input.nextInt();

        System.out.println("Digite o ano da primeira data: ");
        int ano = input.nextInt();

        Data primeiraData = new Data(dia, mes, ano);

        // Lendo a segunda data
        System.out.println("Digite o dia da segunda data: ");
        dia = input.nextInt();

        System.out.println("Digite o mes da segunda data: ");
        mes = input.nextInt();

        System.out.println("Digite o ano da segunda data: ");
        ano = input.nextInt();

        Data segundaData = new Data(dia, mes, ano);

        System.out.println("Primeira data digitada: " + primeiraData.toString());
        System.out.println("Segunda data digitada: " + segundaData.toString());

        input.close();
    }
}
