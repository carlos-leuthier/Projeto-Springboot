package com.example.springboot.model;

public abstract class Pagamento {
    private Long id;
    private double valor;

    public Pagamento(Long id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public abstract void processarPagamento();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
