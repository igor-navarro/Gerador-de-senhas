import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    // Pools de caracteres
    private static final String MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789";
    private static final String SIMBOLOS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.println("=== Gerador de Senhas Seguras ===");

        // 1. Definir tamanho
        System.out.print("Informe o tamanho desejado da senha: ");
        int tamanho = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (tamanho <= 0) {
            System.out.println("Erro: O tamanho da senha deve ser maior que 0.");
            return;
        }

        // 2. Escolher tipos de caracteres
        System.out.print("Incluir letras maiúsculas? (s/n): ");
        boolean usarMaiusculas = scanner.nextLine().trim().equalsIgnoreCase("s");

        System.out.print("Incluir letras minúsculas? (s/n): ");
        boolean usarMinusculas = scanner.nextLine().trim().equalsIgnoreCase("s");

        System.out.print("Incluir números? (s/n): ");
        boolean usarNumeros = scanner.nextLine().trim().equalsIgnoreCase("s");

        System.out.print("Incluir símbolos? (s/n): ");
        boolean usarSimbolos = scanner.nextLine().trim().equalsIgnoreCase("s");

        // 3. Montar a base de caracteres permitidos
        StringBuilder poolCaracteres = new StringBuilder();
        if (usarMaiusculas) poolCaracteres.append(MAIUSCULAS);
        if (usarMinusculas) poolCaracteres.append(MINUSCULAS);
        if (usarNumeros) poolCaracteres.append(NUMEROS);
        if (usarSimbolos) poolCaracteres.append(SIMBOLOS);

        // Validação de segurança
        if (poolCaracteres.length() == 0) {
            System.out.println("Erro: Você deve selecionar pelo menos um tipo de caractere.");
            return;
        }

        // 4. Gerar a senha
        StringBuilder senha = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(poolCaracteres.length());
            senha.append(poolCaracteres.charAt(index));
        }

        // 5. Exibir resultado
        System.out.println("\n-----------------------------------");
        System.out.println("Senha gerada: " + senha.toString());
        System.out.println("-----------------------------------");

        scanner.close();
    }
}