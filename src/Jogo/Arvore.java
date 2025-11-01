package Jogo;

public abstract class Arvore {
    protected String texto;
    protected int familia;
    protected int crime;

    public Arvore(String texto, int familia, int crime) {
        this.texto = texto;
        this.familia = familia;
        this.crime = crime;
    }

    protected void mostrarTexto() {
        Utilidades.imprimirComPausa(this.texto);
    }

    public abstract boolean executar(Jogador jogador);
}

