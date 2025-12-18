import java.util.Scanner;
import java.util.Locale;
public class AnaliseDesempenhoAcademico {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Deseja utilizar a calculadora antes? (S/N): ");
        String usarCalculadora = scanner.nextLine();
        if (usarCalculadora.equalsIgnoreCase("S")) {
            executarCalculadora(scanner);
            scanner.nextLine();
        }

        System.out.print("Deseja registrar notas? (S/N): ");
        String registrarNotas = scanner.nextLine();
        if (registrarNotas.equalsIgnoreCase("S")) {
            registrarNotasAluno(scanner);
        }

        scanner.close();
    }

    public static void executarCalculadora(Scanner scanner) {
        while (true) {
            System.out.println("[Calculadora]");
            System.out.println("1. Raiz quadrada");
            System.out.println("2. Potência");
            System.out.println("3. Arredondar");
            System.out.println("4. Aleatório");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            double resultado;

            switch (opcao) {
                case 1:
                    System.out.print("Digite um número: ");
                    double num = scanner.nextDouble();
                    if (num >= 0) {
                        resultado = Math.sqrt(num);
                    } else {
                        System.out.println("Número negativo! Raiz não definida nos reais.");
                        continue;
                    }
                    break;
                case 2:
                    System.out.print("Base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Expoente: ");
                    double exp = scanner.nextDouble();
                    resultado = Math.pow(base, exp);
                    break;
                case 3:
                    System.out.print("Digite um número para arredondar: ");
                    double valor = scanner.nextDouble();
                    resultado = Math.round(valor);
                    break;
                case 4:
                    resultado = Math.random();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }
            System.out.println("\nResultado: " + resultado + "\n");
        }
    }

    public static void registrarNotasAluno(Scanner scanner) {
        double[] notas = new double[5];
        int qtdNotas = 0;

        for (int i = 0; i < 5; i++) {
            double nota = lerNotaValida(scanner, i + 1);
            notas[i] = nota;
            qtdNotas++;

            String hora = String.format("%02d:%02d", (int)(Math.random() * 24), (int)(Math.random() * 60));
            System.out.printf("[LOG] Nota %.1f adicionada às %s%n", nota, hora);
            System.out.println();

            if (i < 4) {
                System.out.print("Continuar? (S/N): ");
                String continuar = scanner.nextLine();
                if (continuar.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
        exibirEstatisticas(notas, qtdNotas);
    }

    public static double lerNotaValida(Scanner scanner, int numero) {
        while (true) {
            System.out.print("Digite a nota " + numero + ": ");
            double nota = scanner.nextDouble();

            if (nota >= 0.0 && nota <= 10.0) {
                scanner.nextLine();
                return nota;
            } else {
                System.out.println("Nota inválida! Digite um valor entre 0.0 e 10.0.");
                scanner.nextLine();
            }
        }
    }

    public static double calcularMedia(double[] notas, int qtdNotas) {
        double soma = 0;
        for (int i = 0; i < qtdNotas; i++) {
            soma += notas[i];
        }
        return soma / qtdNotas;
    }

    public static double calcularDesvioPadrao(double[] notas, int qtdNotas) {
        double media = calcularMedia(notas, qtdNotas);
        double soma = 0;
        for (int i = 0; i < qtdNotas; i++) {
            soma += Math.pow(notas[i] - media, 2);
        }
        return Math.sqrt(soma / qtdNotas);
    }

    public static String definirStatus(double media) {
        if (media >= 7.0) {
            return "Aprovado";
        } else if (media >= 5.0) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public static String gerarFeedback(double desvio) {
        if (desvio <= 1.0) {
            return "Seu desempenho é estável.";
        } else {
            return "Há grande variação nas suas notas.";
        }
    }

    public static void exibirEstatisticas(double[] notas, int qtdNotas) {
        double media = calcularMedia(notas, qtdNotas);
        double desvio = calcularDesvioPadrao(notas, qtdNotas);
        String status = definirStatus(media);
        String feedback = gerarFeedback(desvio);

        System.out.println();
        System.out.printf("Média: %.2f%n", media);
        System.out.printf("Desvio padrão: %.2f%n", desvio);
        System.out.println("Status: " + status);
        System.out.println("Feedback: " + feedback);
        System.out.println();
    }
}