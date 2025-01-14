
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SimuladorDadosavancado {

    public static int rolarDados(int faces, int modificador) {
        Random random = new Random();

        // Retorna um número aleatório entre 1 e o número de faces do dado
        return random.nextInt(faces) + 1;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("🎲 Bem-vindo ao Simulador de Dados de RPG Avançado! 🎲");

        while (continuar) {
            System.out.print("\nDigite o tipo de dado que deseja rolar (ex.: 6 para D6, 20 para D20): ");
            int faces = scanner.nextInt(); // Tipo do dado (número de faces)

            System.out.print("Quantas vezes você deseja rolar o dado? ");
            int quantidade = scanner.nextInt(); // Número de rolagens

            System.out.print("Digite o Modificador de Rolagens (ex.: +2,  -1, ou 0 para nehuma rolagem): ");
            int modificador = scanner.nextInt();

            List<Integer> resultados = new ArrayList<>();

            if (quantidade > 0) {
                System.out.println("\n🎲 Rolando o dado...");
                for (int i = 1; i <= quantidade; i++) {
                    int resultado = rolarDados(faces, modificador);
                    resultados.add(resultado);
                    System.out.println("Rolagem " + i + ": " + resultado);
                }

                // Calcula estatísticas
                int soma = resultados.stream().mapToInt(Integer::intValue).sum();
                double media = (double) soma / resultados.size();
                int maior = Collections.max(resultados);
                int menor = Collections.min(resultados);


                // Exibe as estatísticas
                System.out.println("\n📊 Estatísticas:");
                System.out.println("➡️ Soma total: " + soma);
                System.out.println("➡️ Média: " + String.format("%.2f", media));
                System.out.println("➡️ Maior rolagem: " + maior);
                System.out.println("➡️ Menor rolagem: " + menor);


                //Menu interativo

                System.out.println("\nDeseja realizar outra rolagem ? (S/N): ");
                String resposta = scanner.next();
                continuar = resposta.equalsIgnoreCase("S");


            }

        }
            System.out.println("\nObrigado por usar o simulador de dados de RPG!");
            scanner.close();
    }
}
