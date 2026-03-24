package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main(String[] args) {
        BancoComIndiceSimulado bancoComIndiceSimulado = new BancoComIndiceSimulado();

        int idBuscado = 450;

        Cliente cliente = bancoComIndiceSimulado.buscaClientePorId(idBuscado);
        System.out.println();

        if (cliente != null){
            System.out.println("Registro Encontrado: ");
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
