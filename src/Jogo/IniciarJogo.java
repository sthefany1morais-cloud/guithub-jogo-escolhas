package Jogo;

public class IniciarJogo {
    public static void main(String[] args) {
        Arvore arvore = new ConstrutorJogo("jogar.txt").criarArvore();
        Jogador jogador = new Jogador();
        arvore.executar(jogador);
    }
}

