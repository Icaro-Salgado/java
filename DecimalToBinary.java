import java.util.Scanner;

public class DecimalToBinary {
    public static void main( String args[] ) {
        System.out.print("Digite um número decimal: ");


        Scanner scanner= new Scanner(System.in); // Iniciando o scanner
        String decimalStr= scanner.nextLine(); // Lendo o input como string
        scanner.close(); // Fechando o scanner

        Integer decimal = Integer.parseInt(decimalStr); // Converter para inteiro

        String binario = "";
        while (decimal > 0)
        {
                binario =  ( (decimal % 2 ) == 0 ? "0" : "1") + binario;
                decimal = decimal / 2;
        }
        // String binario = Integer.toBinaryString(decimal); // Metodo do java para a conversão

        System.out.println("O numero " + decimalStr + " em valor binario e: " + binario);
    }
 }
