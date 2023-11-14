import java.util.*;

public class VaiNaWeb {
    public static void Loteria() {
        ArrayList<Integer> numerosEscolhidos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        inicio();

        while (numerosEscolhidos.size() < 7) {
            try {
                System.out.print("Digite um numero: ");
                int numero = sc.nextInt();

                if (numero > 0 && !numerosEscolhidos.contains(numero)) {
                    numerosEscolhidos.add(numero);
                } else {
                    System.out.println("Por favor, digite um número positivo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Somente numeros sao aceitos");
                sc.nextLine();
            }

        }
        sc.close();

        ArrayList<Integer> numerosSorteiados = sorteio();

        int resultado = resultado(numerosEscolhidos, numerosSorteiados);

        switch (resultado) {
            case 5:
                System.out.println(" → Você acertou 5 números → Ganhou o prêmio de 10 mil reais");

                break;
            case 6:
                System.out.println("→ Você acertou 6 números → Ganhou o prêmio de 50 mil reais");

                break;
            case 7:
                System.out.println("→ Você acertou 7 números → Ganhou o prêmio de 200 mil reais");
                break;
            default:
                System.out.println("Infelizmente você nao teve nenhum acerto.");
        }
    }

    private static int resultado(ArrayList<Integer> numerosEscolhidos, ArrayList<Integer> numerosSorteiados) {
        int acertos = 0;

        for (Integer numerosEscolhido : numerosEscolhidos) {
            for (Integer numerosSorteiado : numerosSorteiados) {
                if (Objects.equals(numerosEscolhido, numerosSorteiado)) {
                    acertos += 1;
                }
            }
        }
        return 0;
    }

    public static void inicio() {
        System.out.println("Bem vindo a loteria VaiNaWeb");
        System.out.println("Escolha seus 7 numeros de 01 a 100 e boa sorte.");
    }

    public static ArrayList<Integer> sorteio() {
        ArrayList<Integer> sorteados = new ArrayList<>();
        Random random = new Random();
        while (sorteados.size() < 7) {
            int numeroAleatorios = random.nextInt(100) + 1;

            if (!sorteados.contains(numeroAleatorios)) {
                sorteados.add(numeroAleatorios);
            }
        }
        return sorteados;

    }
}
