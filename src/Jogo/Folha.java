package Jogo;

public class Folha extends Arvore {

    static final ArvoreDeFinais finaisFamilia = new ConstrutorJogo("familia.txt").criarArvoreDeFinais();
    static final ArvoreDeFinais finaisCrime = new ConstrutorJogo("crime.txt").criarArvoreDeFinais();

    private boolean fim;

    public Folha(String texto, int familia, int crime, boolean fim) {
        super(texto, familia, crime);
        this.fim = fim;
    }

    protected void mostrarTexto() {
        Utilidades.imprimirComPausa(this.texto, 300, 1500);
    }

    @Override
    public void executar(Jogador jogador) {
        jogador.addFamilia(familia);
        jogador.addCrime(crime);

        mostrarTexto();

        if (this.fim) {
            finaisFamilia.mostrarFinal(jogador.familia);
            finaisCrime.mostrarFinal(jogador.crime);
        }
    }
}
