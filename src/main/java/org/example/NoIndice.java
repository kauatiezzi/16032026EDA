package org.example;

import java.util.ArrayList;
import java.util.List;

public class NoIndice {

    List<Integer> chaves;
    List<NoIndice> filhos;
    boolean folha;

    public NoIndice(boolean folha){
        this.folha = folha;
        this.chaves = new ArrayList<>();
        this.filhos = new ArrayList<>();
    }
}
