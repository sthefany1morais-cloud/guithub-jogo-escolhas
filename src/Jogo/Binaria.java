package Jogo;

public class Binaria extends Arvore {

    private String opcao1;
    private String opcao2;

             Arvore filho1;
             Arvore filho2;

    public Binaria(String texto,
                   String opcao1, String opcao2,
                   Arvore filho1, Arvore filho2,
                   int familia, int crime){

        super(texto, familia, crime);
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.filho1 = filho1;
        this.filho2 = filho2;
    }
    protected void mostrarTexto(){System.out.println("\n" + texto+"\n");
    }

    private boolean Escolha(){
        return Valida.Bi(opcao1, opcao2);
    }

    @Override
    public void Executar(Jogador jogador) {
        jogador.addFamilia(familia);
        jogador.addCrime(crime);

        mostrarTexto();

        if(Escolha()){
            filho1.Executar(jogador);
        } else {
            filho2.Executar(jogador);
        }

    }
}
