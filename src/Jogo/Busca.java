package Jogo;

public class Busca {
    int valor;
    String texto;
    private Busca esquerda;
    private Busca direita;

    public Busca(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    public void inserir(String texto, int valor){
        if (valor < this.valor){
            if (this.esquerda == null){
                this.esquerda = new Busca(texto, valor);
            } else {
                this.esquerda.inserir(texto, valor);
            }
        }
        else if (valor > this.valor){
            if (this.direita == null){
                this.direita = new Busca(texto,valor);
            } else {
                this.direita.inserir(texto, valor);
            }
        }
        else {
            this.texto = texto;
        }
    }
    public void Finais(int pontos){
        if (pontos < this.valor && esquerda != null && (this.valor - pontos) > (esquerda.valor - pontos)){
            this.esquerda.Finais(pontos);
        } else if (pontos > this.valor && direita != null && (pontos - this.valor) > (pontos - direita.valor)) {
            this.direita.Finais(pontos);
        } else {
            System.out.println("\n" + texto);
        }
    }
}
