package Jogo;

import java.util.Scanner;

public class Valida {
    private static final Scanner leitor = new Scanner(System.in);

    public static boolean Bi(String op1, String op2) {
        while (true) {
            System.out.printf("""
                Você deseja: 
                1- %s
                2- %s
                Digite aqui:\s""", op1, op2);
            try {
                String resposta = leitor.nextLine().trim();
                int num = Integer.parseInt(resposta);
                if (num == 1) {
                    return true;
                }
                else if (num == 2) {
                    return false;
                }
            } catch (Exception e) {
                // Apenas ignorar
            }
            System.out.println("Erro. Digite uma resposta válida.");
        }
    }

    public static void Uni(String op) {
        while (true) {
            System.out.printf("""
                    Você deseja: 
                    1- %s
                    Digite aqui:\s""", op);
            try {
                String resposta = leitor.nextLine();
                int num = Integer.parseInt(resposta);
                if (num == 1) {
                    return;
                }
            } catch (Exception e) {
                // Apenas ignorar
            }
            System.out.println("Erro. Digite uma resposta válida.");
        }
    }

}
