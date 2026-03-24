package org.example;

public class Cliente {

    int id;
    String nome;
    String cidade;

    public Cliente(int id, String nome, String cidade){
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Cliente{id= " + id + ", nome='" + nome + "', Cidade='" + cidade +"'}";
    }
}
