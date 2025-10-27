package Jogo;

import java.util.Scanner;

public class Utilidades {
    private static final Scanner leitor = new Scanner(System.in);

    public static void imprimirComPausa(String texto, int menor, int maior){
        String[] linhas = texto.split("\n");
        System.out.println();
        for (String linha: linhas){
            linha = linha.trim();
            if (linha.isEmpty()){
                esperar(maior);
                continue;
            }
            System.out.println(linha);
            esperar(menor);
        }
    }

    public static void esperar(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static boolean escolhaBinaria(String op1, String op2) {
        while (true) {
            System.out.printf("""
                \nVocê deseja: 
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

    public static void escolhaUnaria(String op) {
        while (true) {
            System.out.printf("""
                    \nVocê deseja: 
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
