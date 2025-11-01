package Jogo;

import java.io.File;
import java.util.*;

public class ConstrutorJogo {
    String arquivo;
    public ConstrutorJogo(String arquivo){
        this.arquivo =  arquivo;
    }

    public ConstrutorJogo(){};

    public Arvore criarArvore(){
        List<NoTemporario> temp = lerArvores();
        List<Arvore> real = criarArvores(temp);
        return conectarFilhos(temp, real);
    }

    public void executarJogo(int maximo){
        Jogador jogador = new Jogador();
        for (int i = 1; i <= maximo; i++){

            String arq = "src/capitulos/capitulo" + i + ".txt";
            Arvore capitulo = new ConstrutorJogo(arq).criarArvore();

            boolean encerrar = capitulo.executar(jogador);

            if (encerrar){
                break;
            }
            System.out.printf("\n---FIM DO CAPITULO %d---\n", i);

        }
        System.out.print("\n---Fim de jogo---");
    }

    private List<NoTemporario> lerArvores(){
        List<NoTemporario> nos = new ArrayList<>();
        try (Scanner leitor = new Scanner(new File(this.arquivo), "UTF-8")){

            boolean lendo = false;
            StringBuilder texto = new StringBuilder();
            NoTemporario atual = null;

            while (leitor.hasNextLine()){
                String linha = leitor.nextLine().trim();

                if (lendo &&
                        !linha.split(":", 2)[0].equalsIgnoreCase("FAMILIA") &&
                        !linha.split(":", 2)[0].equalsIgnoreCase("OPCAO1") &&
                        !linha.split(":", 2)[0].equalsIgnoreCase("OPCAO 1") &&
                        !linha.split(":", 2)[0].equalsIgnoreCase("OPCAO")){
                    texto.append(linha).append("\n");
                }
                if (linha.isEmpty()){
                    continue;
                }

                String[] partes = linha.split(":", 2);

                if (partes.length < 2){
                    continue;
                }

                String chave = partes[0].trim();
                String valor = partes[1].trim();

                switch (chave.toUpperCase()){
                    case "ID":
                        if (atual != null) {
                            nos.add(atual);
                            atual = null;
                        }
                        atual = new NoTemporario(Integer.parseInt(valor));
                        break;

                    case "TIPO":
                        atual.tipo = valor.toUpperCase();
                        break;

                    case "TEXTO":

                        lendo = true;
                        texto.setLength(0);
                        texto.append(valor).append("\n");
                        break;

                    case "OPCAO":
                    case "OPCAO1":
                    case "OPCAO 1":
                        if (atual!= null && lendo) {
                            atual.texto = texto.toString().trim();
                            lendo = false;
                            //Adiciona o texto
                        }
                        atual.opcao1 = valor;
                        break;

                    case "OPCAO2":
                    case "OPCAO 2":
                        atual.opcao2 = valor;
                        break;

                    case "FILHO":
                    case "FILHO1":
                    case "FILHO 1":
                        atual.filho1 = Integer.parseInt(valor);
                        break;

                    case "FILHO2":
                    case "FILHO 2":
                        atual.filho2 = Integer.parseInt(valor);
                        break;

                    case "FAMILIA":
                        if (atual!= null && lendo) {
                            atual.texto = texto.toString().trim();
                            lendo = false;
                            //Adiciona o texto
                        }
                        atual.familia = Integer.parseInt(valor);
                        break;
                    case "CRIME":
                        atual.crime = Integer.parseInt(valor);
                        break;

                    case "FIM":
                        atual.fim = Boolean.parseBoolean(valor.toLowerCase());
                        break;

                    case "ENCERRAR":
                        atual.encerrar = Boolean.parseBoolean(valor.toLowerCase());
                        break;

                }


            }
            if (atual != null){
                nos.add(atual);
            }

        } catch (Exception e){
            //Ignorar
        }
        return nos;
    }

    private List<Arvore> criarArvores(List<NoTemporario> temporarios){
        List<Arvore> arvores = new ArrayList<>();

        for (NoTemporario no: temporarios){

            Arvore muda;

            switch (no.tipo){
                case "BIN":
                case "BINARIA":
                    muda = new Binaria(no.texto, no.opcao1, no.opcao2, null, null, no.familia, no.crime);
                    break;
                case "UNA":
                case "UNARIA":
                    muda = new Unaria(no.texto, no.opcao1, null, no.familia, no.crime);
                    break;
                case "FOL":
                default:
                    muda = new Folha(no.texto, no.familia, no.crime, no.fim, no.encerrar);
                    break;
            }
            arvores.add(muda);
        }
        return arvores;
    }

    private Arvore conectarFilhos(List<NoTemporario> temporarios, List<Arvore> reais){
        Map<Integer, Arvore> mapa = new HashMap<>();
        for (int i = 0; i < temporarios.size(); i++){
            mapa.put(temporarios.get(i).id, reais.get(i));
        }
        for (int i = 0; i < temporarios.size(); i++){
            NoTemporario temp = temporarios.get(i);
            Arvore real = reais.get(i);

            if (real instanceof Binaria b){
                b.filho1 = mapa.get(temp.filho1);
                b.filho2 = mapa.get(temp.filho2);
            } else if (real instanceof  Unaria u) {
                u.filho = mapa.get(temp.filho1);
            }
        }
        return reais.getFirst();
    }

    private Map<Integer, String> lerFinais(){
        Map<Integer, String> nos = new TreeMap<>();
        try (Scanner leitor = new Scanner(new File(this.arquivo), "UTF-8")) {
            boolean lendo = false;
            String atual = null;
            StringBuilder texto = new StringBuilder();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine().trim();

                if (lendo &&
                        !linha.split(":", 2)[0].equalsIgnoreCase("VALOR")){
                    texto.append(linha).append("\n");
                }

                if (linha.isEmpty()) {
                    continue;
                }

                String[] partes = linha.split(":", 2);

                if (partes.length < 2) {
                    continue;
                }

                String chave = partes[0].trim();
                String valor = partes[1].trim();

                switch (chave.toUpperCase()) {
                    case "VALOR":
                        if (atual != null){
                            nos.put(Integer.parseInt(atual), texto.toString().trim());
                            texto.setLength(0);
                            lendo = false;
                        }
                            atual = valor;
                        break;

                    case "TEXTO":
                    default:
                        lendo = true;
                        texto.append(valor).append("\n");
                        break;

                }

            } if (atual != null) {
                nos.put(Integer.parseInt(atual), texto.toString().trim());
            }
        } catch (Exception e){
            //Apenas ignorar
        }
        return nos;
    }

    private ArvoreDeFinais montarArvoreDeFinais(Map<Integer, String> mapa, List<Integer> chaves, int inicio, int fim){
        if (inicio> fim){
            return null;
        }

        int meio = (inicio + fim)/2;
        int valor = chaves.get(meio);

        ArvoreDeFinais raiz = new ArvoreDeFinais(mapa.get(valor), valor);

        ArvoreDeFinais esquerda = montarArvoreDeFinais( mapa, chaves, inicio, meio-1);
        ArvoreDeFinais direita = montarArvoreDeFinais( mapa, chaves, meio+1, fim);

        if (esquerda != null){
            raiz.inserir(esquerda.texto, esquerda.valor);
        }
        if (direita != null){
            raiz.inserir(direita.texto, direita.valor);
        }
        return raiz;
    }

    public ArvoreDeFinais criarArvoreDeFinais(){
        Map<Integer, String> correspondentes = lerFinais();
        List<Integer> valores = new ArrayList<>(correspondentes.keySet());
        return montarArvoreDeFinais(correspondentes, valores, 0, valores.size()-1);

    }
}
