package Jogo;

public class ArvoreDeFinais {
    int valor;
    String texto;
    private ArvoreDeFinais esquerda;
    private ArvoreDeFinais direita;

    public ArvoreDeFinais(String texto, int valor) {
        this.texto = texto;
        this.valor = valor;
    }

    public void inserir(String texto, int valor) {
        System.out.println(valor);
        if (valor < this.valor) {
            if (this.esquerda == null) {
                this.esquerda = new ArvoreDeFinais(texto, valor);
            } else {
                this.esquerda.inserir(texto, valor);
            }
        } else if (valor > this.valor) {
            if (this.direita == null) {
                this.direita = new ArvoreDeFinais(texto, valor);
            } else {
                this.direita.inserir(texto, valor);
            }
        } else {
            this.texto = texto;
        }
    }

    public void mostrarFinal(int pontos) {

        if (pontos < this.valor && esquerda != null && Math.abs(this.valor - pontos) > Math.abs(esquerda.valor - pontos)) {
            this.esquerda.mostrarFinal(pontos);
        } else if (pontos > this.valor && direita != null && Math.abs(pontos - this.valor) > Math.abs(pontos - direita.valor)) {
            this.direita.mostrarFinal(pontos);
        }else {
            Utilidades.imprimirComPausa(this.texto);
        }

    }
}

