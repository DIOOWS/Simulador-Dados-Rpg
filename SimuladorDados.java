import java.util.Random;
import java.util.Scanner;

public class SimuladorDados {

    public static  int rolarDados(int faces){
        Random random = new Random();

        // Retorna um número aleatório entre 1 e o número de faces do dado
        return random.nextInt(faces) + 1;

    }

    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Simulador de Dados de RPG!");
        System.out.print("Digite o tipo de dado que deseja rolar (ex.: 6 para D6, 20 para D20): ");

        int faces = scanner.nextInt();// Tipo do dado (número de faces)

        System.out.print("Quantas vezes você deseja rolar o dado? ");
        int quantidade = scanner.nextInt(); // Número de rolagens

        System.out.println("\nRolando o dado...");
        for(int i = 1; i <= quantidade; i++){
            int resultado = rolarDados(faces);
            System.out.println("Rolagem " + i + ": " + resultado);
        }

        System.out.println("\nObrigado por usar o simulador de dados de RPG!");
        scanner.close();
    }
}
