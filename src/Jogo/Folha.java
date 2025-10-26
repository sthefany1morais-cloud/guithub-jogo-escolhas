package Jogo;


public class Folha extends Arvore {
    static final Busca finalFamilia = new ConstrutorJogo("familia.txt").criarBusca();
    static final Busca finalCrime = new ConstrutorJogo("crime.txt").criarBusca();
    private boolean fim;
    public Folha(String texto, int familia, int crime, boolean fim){
        super(texto, familia, crime);
        this.fim = fim;
    }
    protected void mostrarTexto(){
        System.out.println("\n" + texto);
    }

    @Override
    public void Executar(Jogador jogador) {
        jogador.addFamilia(familia);
        jogador.addCrime(crime);
        mostrarTexto();
        if (this.fim){
            finalFamilia.Finais(jogador.familia);
            finalCrime.Finais(jogador.crime);
        }
    }
}