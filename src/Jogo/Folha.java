package Jogo;

public class Folha extends Arvore {

    static final ArvoreDeFinais finaisFamilia = new ConstrutorJogo("src/finais/familia.txt").criarArvoreDeFinais();
    static final ArvoreDeFinais finaisCrime = new ConstrutorJogo("src/finais/crime.txt").criarArvoreDeFinais();

    private boolean encerrar;
    private boolean fim;

    public Folha(String texto, int familia, int crime, boolean fim, boolean encerrar) {
        super(texto, familia, crime);
        this.fim = fim;
        this.encerrar = encerrar;
    }

    protected void mostrarTexto() {
        Utilidades.imprimirComPausa(this.texto);
    }

    @Override
    public boolean executar(Jogador jogador) {
        jogador.addFamilia(familia);
        jogador.addCrime(crime);

        mostrarTexto();

        if (this.fim) {
            finaisFamilia.mostrarFinal(jogador.familia);
            finaisCrime.mostrarFinal(jogador.crime);
        }
        return this.encerrar;
    }
}
