package Jogo;


public class Teste {
    public static void main(String[] args) {
        Arvore arvore = new ConstrutorJogo("jogar.txt").criarArvore();
        Jogador jogador = new Jogador();
        arvore.Executar(jogador);
    }
}

