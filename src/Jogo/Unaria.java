package Jogo;

public class Unaria extends Arvore {

    private String opcao;
            Arvore filho;

    public Unaria(String texto,
                   String opcao, Arvore filho,
                   int familia, int crime){

        super(texto, familia, crime);
        this.opcao = opcao;
        this.filho = filho;
    }
    protected void mostrarTexto(){
        System.out.println("\n" + texto+"\n");
    }

    private void Escolha(){
        Valida.Uni(opcao);
    }

    @Override
    public void Executar(Jogador jogador) {
        jogador.addFamilia(familia);
        jogador.addCrime(crime);

        mostrarTexto();
        Escolha();

        filho.Executar(jogador);

    }
}
