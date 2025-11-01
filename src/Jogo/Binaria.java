package Jogo;

public class Binaria extends Arvore {

    private String opcao1;
    private String opcao2;
    Arvore filho1;
    Arvore filho2;

    public Binaria(String texto, String opcao1, String opcao2,
                   Arvore filho1, Arvore filho2,
                   int familia, int crime) {

        super(texto, familia, crime);
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.filho1 = filho1;
        this.filho2 = filho2;
    }

    protected void mostrarTexto() {
        Utilidades.imprimirComPausa(this.texto);
    }

    private boolean escolherOpcao() {
        return Utilidades.escolhaBinaria(opcao1, opcao2);
    }

    @Override
    public boolean executar(Jogador jogador) {
        jogador.addFamilia(familia);
        jogador.addCrime(crime);

        mostrarTexto();

        if (escolherOpcao()) {
            return filho1.executar(jogador);
        } else {
            return filho2.executar(jogador);
        }
    }
}

