package org.example;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class BancoComIndiceSimulado {

    private Map<Integer, Cliente> tabela;

    private NoIndice raiz;

    public BancoComIndiceSimulado() {
        tabela = new HashMap<>();
        carregarTabela();
        montarIndice();
    }

    private void carregarTabela(){
        tabela.put(101, new Cliente(101, "Ana", "Araraquara"));
        tabela.put(205, new Cliente(205, "João", "Matão"));
        tabela.put(310, new Cliente(310, "Ana", "Ribeirão"));
        tabela.put(450, new Cliente(450, "Ana", "Araraquara"));
        tabela.put(550, new Cliente(550, "João", "Matão"));
        tabela.put(650, new Cliente(650, "Ana", "Ribeirão"));
    }

    private void montarIndice(){
        raiz = new NoIndice(false);
        raiz.chaves.add(310);
        raiz.chaves.add(520);

        NoIndice folha1 = new NoIndice(true);
        folha1.chaves.add(101);
        folha1.chaves.add(205);

        NoIndice folha2 = new NoIndice(true);
        folha2.chaves.add(310);
        folha2.chaves.add(450);

        NoIndice folha3 = new NoIndice(true);
        folha3.chaves.add(610);
        folha3.chaves.add(10);

        raiz.filhos.add(folha1);
        raiz.filhos.add(folha2);
        raiz.filhos.add(folha3);

    }

    public Cliente buscaClientePorId(int idBuscado) {
        System.out.println("Iniciando a busca pelo cliente Id: " + idBuscado + "...");
        boolean encontrado = buscarNoIndice(raiz, idBuscado);

        if(encontrado) {
            System.out.println("ID encontrado no Indice. Buscando registro na tabvela...");
            return tabela.get(idBuscado);
        } else {
            System.out.println("ID Não encontrado no indice. ");
            return null;
        }
    }

    private boolean buscarNoIndice(NoIndice no, int valor) {
        System.out.println("Visitando nó indice: " + no.chaves);

        int i =0;
        while (i<no.chaves.size() && valor > no.chaves.get(i)){
            i++;
        }
        if(no.folha){
            if(no.chaves.contains(valor)){
                System.out.println("ID: " + valor + " encontrado na folha " + no.chaves);
                return true;
            } else {
                System.out.println("Cheguei na folha " + no.chaves + " e não encontrei o ID");
                return false;
            }
        }
        System.out.println("Descendo para o filho " + i + "...");
        return buscarNoIndice(no.filhos.get(i), valor);
    }

}
