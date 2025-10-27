package Jogo;

public class Unaria extends Arvore {

    private String opcao;
    Arvore filho;

    public Unaria(String texto, String opcao, Arvore filho, int familia, int crime) {
        super(texto, familia, crime);
        this.opcao = opcao;
        this.filho = filho;
    }

    protected void mostrarTexto() {
        Utilidades.imprimirComPausa(this.texto, 300, 1500);
    }

    private void escolherOpcao() {
        Utilidades.escolhaUnaria(opcao);
    }

    @Override
    public void executar(Jogador jogador) {
        jogador.addFamilia(familia);
        jogador.addCrime(crime);

        mostrarTexto();
        escolherOpcao();

        filho.executar(jogador);
    }
}
