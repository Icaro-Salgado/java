import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class VetorFiguras {
    private List<Figura> vetFiguras = new ArrayList<Figura>();

    public VetorFiguras(){

    }

    public Figura getFigura(int ind) {
        return vetFiguras.get(ind);
    }

    public int getNumFiguras() {
        return vetFiguras.size();
    }

    public int getNumRetangulos() {
        int numRetangulos = 0;

        for (Figura figura: vetFiguras) {
            if (figura instanceof Retangulo) {
                numRetangulos ++;
            }
        }

        return numRetangulos;
    }

    public int getNumQuadrados() {
        int numQuadrados = 0;

        for (Figura figura: vetFiguras) {
            if (figura instanceof Quadrado) {
                numQuadrados ++;
            }
        }

        return numQuadrados;
    }

    public int getNumCirculos() {
        int numCirculos = 0;

        for (Figura figura: vetFiguras) {
            if (figura instanceof Circulo) {
                numCirculos ++;
            }
        }

        return numCirculos;
    }

    public void insereFigura(Figura fig) throws FiguraDuplicadaException {
        if (this.buscaFigura(fig)) {
            throw new FiguraDuplicadaException("A figura ja existe!");
        }

        vetFiguras.add(fig);
    }

    public boolean buscaFigura(Figura fig) {
        for (Figura figura: vetFiguras) {

            if (figura.equals(fig)) {
                return true;
            }
        }

        return false;
        // return vetFiguras.contains(fig);
    }

    public void visualizar() {

        System.out.println("");
        System.out.println("-- Contagem -- ");
        System.out.println("Numero de retangulos: " + this.getNumRetangulos());
        System.out.println("Numero de quadrados: " + this.getNumQuadrados());
        System.out.println("Numero de circulos: " + this.getNumCirculos());

        System.out.println("");
        System.out.println("-- Figuras --");
        for (Figura fig: vetFiguras) {
            System.out.println(fig.toString());
        }

        System.out.println("--------------");
        System.out.println("");

    }

    public void lerFigura(java.util.Scanner entrada) throws FiguraDuplicadaException {
        System.out.print("Digite a figura desejada (retangulo, quadrado, circulo): ");
        String figuraDesejada = entrada.nextLine();

        switch (figuraDesejada.toLowerCase()){
            case "retangulo": {
                System.out.print("Digite a largura do retangulo que sera criado: ");
                int largura = entrada.nextInt();

                while(largura < 0) {
                    // Tratamento de erro
                    System.out.println("\nA largura deve ser positiva\n");
                    System.out.print("Digite a largura do retangulo que sera criado: ");
                    largura = entrada.nextInt();
                }

                System.out.print("Digite a altura do retangulo que sera criado: ");
                int altura = entrada.nextInt();

                while(altura < 0) {
                    // Tratamento de erro
                    System.out.println("\nA altura deve ser positiva\n");
                    System.out.print("Digite a altura do retangulo que sera criado: ");
                    altura = entrada.nextInt();
                }

                System.out.print("Digite x0 do retangulo que sera criado (caso não queira adicionar digite -): ");
                String possivelX0 = entrada.next();

                System.out.print("Digite y0 do retangulo que sera criado (caso não queira adicionar digite -): ");
                String possivelY0 = entrada.next();

                switch (possivelX0) {
                    case "-": {
                        this.insereFigura(new Retangulo(largura, altura));

                        break;
                    }

                    default: {
                        int x0 = Integer.parseInt(possivelX0);
                        int y0 = Integer.parseInt(possivelY0);

                        while(x0 < 0) {
                            // Tratamento de erro
                            System.out.println("\n O x0 deve ser positiv0\n");
                            System.out.print("Digite x0 do retangulo que sera criado ");
                            x0 = entrada.nextInt();
                        }

                        while(y0 < 0) {
                            // Tratamento de erro
                            System.out.println("\n O y0 deve ser positiv0\n");
                            System.out.print("Digite y0 do retangulo que sera criado ");
                            y0 = entrada.nextInt();
                        }

                        this.insereFigura(new Retangulo(x0, y0, largura, altura));

                        break;
                    }
                }

                break;
            }

            case "quadrado": {
                System.out.print("Digite o lado do quadrado que sera criado: ");
                int lado = entrada.nextInt();

                while(lado < 0) {
                    // Tratamento de erro
                    System.out.println("\nA lado deve ser positiva\n");
                    System.out.print("Digite a lado do retangulo que sera criado: ");
                    lado = entrada.nextInt();
                }


                System.out.print("Digite x0 do quadrado que sera criado (caso não queira adicionar digite -): ");
                String possivelX0 = entrada.next();

                System.out.print("Digite y0 do quadrado que sera criado (caso não queira adicionar digite -): ");
                String possivelY0 = entrada.next();

                switch (possivelX0) {
                    case "-": {
                        this.insereFigura(new Quadrado(lado));

                        break;
                    }

                    default: {
                        int x0 = Integer.parseInt(possivelX0);
                        int y0 = Integer.parseInt(possivelY0);

                        while(x0 < 0) {
                            // Tratamento de erro
                            System.out.println("\n O x0 deve ser positiv0\n");
                            System.out.print("Digite x0 do quadrado que sera criado ");
                            x0 = entrada.nextInt();
                        }

                        while(y0 < 0) {
                            // Tratamento de erro
                            System.out.println("\n O y0 deve ser positiv0\n");
                            System.out.print("Digite y0 do quadrado que sera criado ");
                            y0 = entrada.nextInt();
                        }

                        this.insereFigura(new Quadrado(x0, y0, lado));

                        break;
                    }
                }

                break;
            }

            case "circulo": {
                System.out.print("Digite o raio do circulo que sera criado: ");
                int raio = entrada.nextInt();

                while(raio < 0) {
                    // Tratamento de erro
                    System.out.println("\nA raio deve ser positiva\n");
                    System.out.print("Digite a raio do retangulo que sera criado: ");
                    raio = entrada.nextInt();
                }

                System.out.print("Digite x0 do circulo que sera criado (caso não queira adicionar digite -): ");
                String possivelX0 = entrada.next();

                System.out.print("Digite y0 do circulo que sera criado (caso não queira adicionar digite -): ");
                String possivelY0 = entrada.next();

                switch (possivelX0) {
                    case "-": {
                        this.insereFigura(new Circulo(raio));

                        break;
                    }

                    default: {
                        int x0 = Integer.parseInt(possivelX0);
                        int y0 = Integer.parseInt(possivelY0);

                        while(x0 < 0) {
                            // Tratamento de erro
                            System.out.println("\n O x0 deve ser positiv0\n");
                            System.out.print("Digite x0 do circulo que sera criado ");
                            x0 = entrada.nextInt();
                        }

                        while(y0 < 0) {
                            // Tratamento de erro
                            System.out.println("\n O y0 deve ser positiv0\n");
                            System.out.print("Digite y0 do circulo que sera criado ");
                            y0 = entrada.nextInt();
                        }

                        this.insereFigura(new Circulo(x0, y0, raio));

                        break;
                    }
                }

                break;
            }

            default: {
                System.out.println("Figura não disponivel");
                break;
            }
        }
    }

    public Figura procurar(java.util.Scanner  entrada) throws figuraNaoEcontrada{
        System.out.print("Digite qual a figura deseja procurar (retangulo, quadrado, circulo): ");
        String figuraDesejada = entrada.next();

        switch (figuraDesejada){

            case "retangulo": {
                System.out.print("Digite a largura do retangulo que deseja buscar: ");
                int largura = entrada.nextInt();

                System.out.print("Digite a altura do retangulo que deseja buscar: ");
                int altura = entrada.nextInt();

                System.out.print("Digite x0 do retangulo que deseja buscar (caso não queira adicionar digite -): ");
                String possivelX0 = entrada.next();

                System.out.print("Digite y0 do retangulo que deseja buscar (caso não queira adicionar digite -): ");
                String possivelY0 = entrada.next();

                switch (possivelX0) {
                    case "-": {
                        for (Figura fig: vetFiguras) {
                            if ((fig instanceof Retangulo) && (fig.area() == (largura * altura))){
                                return fig;
                            }
                        }

                        break;
                    }

                    default: {
                        int x0 = Integer.parseInt(possivelX0);
                        int y0 = Integer.parseInt(possivelY0);

                        for (Figura fig: vetFiguras) {
                            if ((fig instanceof Retangulo) && (fig.getX0() == x0) && (fig.getY0() == y0) && (fig.area() == (largura * altura))){
                                return fig;
                            }
                        }

                        break;
                    }
                }
            }

            case "quadrado": {
                System.out.print("Digite o lado do quadrado que deseja buscar: ");
                int lado = entrada.nextInt();

                System.out.print("Digite x0 do quadrado que deseja buscar (caso não queira adicionar digite -): ");
                String possivelX0 = entrada.next();

                System.out.print("Digite y0 do quadrado que deseja buscar (caso não queira adicionar digite -): ");
                String possivelY0 = entrada.next();

                switch (possivelX0) {
                    case "-": {
                        for (Figura fig: vetFiguras) {
                            if ((fig instanceof Quadrado) && (fig.area() == (lado * lado))){
                                return fig;
                            }
                        }

                        break;
                    }

                    default: {
                        int x0 = Integer.parseInt(possivelX0);
                        int y0 = Integer.parseInt(possivelY0);

                        for (Figura fig: vetFiguras) {
                            if ((fig instanceof Quadrado) && (fig.getX0() == x0) && (fig.getY0() == y0) && (fig.area() == (lado * lado))){
                                return fig;
                            }
                        }

                        break;
                    }
                }
            }

            case "circulo": {
                System.out.print("Digite o lado do circulo que deseja buscar: ");
                int raio = entrada.nextInt();

                System.out.print("Digite x0 do circulo que deseja buscar (caso não queira adicionar digite -): ");
                String possivelX0 = entrada.next();

                System.out.print("Digite y0 do circulo que deseja buscar (caso não queira adicionar digite -): ");
                String possivelY0 = entrada.next();

                switch (possivelX0) {
                    case "-": {
                        for (Figura fig: vetFiguras) {
                            if ((fig instanceof Circulo) && (fig.area() == (Math.PI * Math.pow(raio, 2)))){
                                return fig;
                            }
                        }

                        break;
                    }

                    default: {
                        int x0 = Integer.parseInt(possivelX0);
                        int y0 = Integer.parseInt(possivelY0);

                        for (Figura fig: vetFiguras) {
                            if ((fig instanceof Circulo) && (fig.getX0() == x0) && (fig.getY0() == y0) && (fig.area() == (Math.PI * Math.pow(raio, 2)))){
                                return fig;
                            }
                        }

                        break;
                    }
                }
            }
        }

        throw new figuraNaoEcontrada("Figura não encontrada");

    }

    public void ordenar() {
        java.util.Collections.sort(vetFiguras);
    }

    public static void main(String[] args) {
        boolean programaExecutando = true;

        java.util.Scanner entrada = new java.util.Scanner(System.in); // Para ler as opções

        VetorFiguras vetorFiguras = new VetorFiguras();

        while (programaExecutando){
            // Menu
            printarMenu();

            try {
                int escolhaDoUsuário = entrada.nextInt();

                entrada.nextLine();
                switch (escolhaDoUsuário) {
                    case 0: {
                        programaExecutando = false;
                        break;
                    }

                    case 1: {
                        // Tratamento de erro
                        try {
                            vetorFiguras.lerFigura(entrada);

                        } catch (FiguraDuplicadaException figDuplicada) {
                            System.out.println("\n" + figDuplicada.getMessage() + "\n");
                            System.out.println("\nVoltando ao menu principal...\n");
                            break;
                        }
                        break;
                    }

                    case 2: {
                        try {
                            Figura figuraEncontrada = vetorFiguras.procurar(entrada);

                            System.out.println("");
                            System.out.println("Figura encontrada:");
                            System.out.println(figuraEncontrada.toString());
                            System.out.println("");

                            break;

                        } catch (figuraNaoEcontrada figNaoEncontrada){
                            System.err.println(figNaoEncontrada.getMessage());
                            break;
                        }
                    }

                    case 3: {
                        vetorFiguras.visualizar();
                    }

                    case 4: {
                        vetorFiguras.ordenar();
                    }

                }

            }

            catch (InputMismatchException opçãoInvalida) {
                System.err.println("Opção invalida, digite uma opção valida!");
                entrada.nextLine();
            }
        }

        // Fechando scanner
        entrada.close();
    }

    // Apenas para facilitar o trabalho na função main vou definir alguns métodos
    private static void printarMenu() {
        System.out.println("");
        System.out.println("=============================== Menu principal ===============================");
        System.out.println("1 - Adicionar figuras \t 2 - Procurar determinada figura \t 3 - Visualizar sumário de figuras no vetor");
        System.out.println("4 - Ordenar figuras \t 0 - Sair do programa");
        System.out.println("");
        System.out.print("Digite a opção desejada: ");
    }

}

// Excessões criadas
class FiguraDuplicadaException extends Exception {
    public FiguraDuplicadaException (String message) {
        super(message);
    }
}

class figuraNaoEcontrada extends Exception {
    public figuraNaoEcontrada (String message) {
        super(message);
    }
}
//

// Classes para serem utilizadas
abstract class Figura implements Comparable<Figura>{
    public int x0, y0;

    public Figura() {
    }

    public Figura(int x, int y) {
        x0 = x;
        y0= y;
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int val){
        y0 = val;
    }

    public String toString() {
        return "Figura -> " + "x0, y0" + x0 + "," + y0;
    }

    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        return false;
    }

    public abstract double perimetro();

    public abstract double area();

    public int compareTo(Figura obj) {
        if (this.area() == obj.area()) {
            return 0;
        }

        else if (this.area() > obj.area()) {
            return 1;
        }

        else {
            return -1;
        }
    }
}

class Retangulo extends Figura {
    int largura, altura;

    public Retangulo(int b, int a) {
        super();

        largura = b;
        altura = a;
    }

    public Retangulo(int x, int y, int b, int a) {
        super(x, y);

        largura = b;
        altura = a;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int val) {
        largura = val;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int val) {
        altura = val;
    }

    @Override
    public String toString() {
        return "Retangulo -> Altura: " + altura + "    Largura: " + largura + "    x0, y0: " + x0 + ", " + y0;
    }

    @Override
    public boolean equals(Object obj) {
        // Check de identidade de objeto
        if (this == obj) {
            return true;
        }

        // Check para ver se não é nulo
        if (obj == null) {
            return false;
        }

        // Check para ver se é classe diferente
        if (getClass() != obj.getClass()) {
            return false;
        }

        // Se nenhum passar a gente checa os valores
        // repare que x0 e y0 não são checados pois a gente quer ver só se o retangulo é o mesmo e não se estão na mesma posição
        Retangulo retangulo = (Retangulo) obj;

        return (retangulo.getAltura() == altura) && (retangulo.getLargura() == largura);
    }

    @Override
    public double area() {
        return altura * largura;
    }

    @Override
    public double perimetro() {
        return (altura + largura) * 2;
    }
}

class Quadrado extends Retangulo {
    public Quadrado(int a) {
        super(a, a);
    }

    public Quadrado(int x, int y, int a) {
        super(x, y, a, a);
    }

    @Override
    public String toString() {
        return "Quadrado -> Lado: " + largura + "    x0, y0: " + x0 + ", " + y0;
    }

    @Override
    public boolean equals(Object obj) {
        // Check de identidade de objeto
        if (this == obj) {
            return true;
        }

        // Check para ver se não é nulo
        if (obj == null) {
            return false;
        }

        // Check para ver se é classe diferente
        if (getClass() != obj.getClass()) {
            return false;
        }

        // Se nenhum passar a gente checa os valores
        // repare que x0 e y0 não são checados pois a gente quer ver só se o quadrado é o mesmo e não se estão na mesma posição
        Quadrado quadrado = (Quadrado) obj;

        return (quadrado.getAltura() == altura);
    }
}

class Circulo extends Figura {
    int raio;

    public Circulo(int r) {
        super();

        raio = r;
    }

    public Circulo(int x, int y, int r) {
        super(x, y);

        raio = r;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int val) {
        raio = val;
    }

    @Override
    public String toString() {
        return "Circulo -> Raio: " +  "    x0, y0: " + x0 + ", " + y0;
    }

    @Override
    public boolean equals(Object obj) {
        // Check de identidade de objeto
        if (this == obj) {
            return true;
        }

        // Check para ver se não é nulo
        if (obj == null) {
            return false;
        }

        // Check para ver se é classe diferente
        if (getClass() != obj.getClass()) {
            return false;
        }

        // Se nenhum passar a gente checa os valores
        // repare que x0 e y0 não são checados pois a gente quer ver só se o circulo é o mesmo e não se estão na mesma posição
        Circulo circulo = (Circulo) obj;

        return (circulo.getRaio() == raio);
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * raio;
    }
}