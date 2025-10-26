package Jogo;

public class Jogador {
    int familia = 0;
    int crime = 0;
    public Jogador(){};

    public void addFamilia(int familia){
        this.familia += familia;
    }

    public void addCrime(int crime) {
        this.crime += crime;
    }
}
