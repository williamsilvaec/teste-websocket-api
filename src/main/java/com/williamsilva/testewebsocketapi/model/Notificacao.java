package com.williamsilva.testewebsocketapi.model;

public class Notificacao {

    private int contador;

    public Notificacao(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }

    public void incrementar() {
        this.contador++;
    }
}
