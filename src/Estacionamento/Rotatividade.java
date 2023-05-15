
package Estacionamento;

import java.util.Date;

public class Rotatividade {
    int id;
    String modelo;
    String placa;
    String entrada;
    String saida;
    double valor;

    public Rotatividade(int id, String modelo, String placa, String entrada, String saida, double valor) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.entrada = entrada;
        this.saida = saida;
        this.valor = valor;
    }

    public Rotatividade(String modelo, String placa, String entrada, String saida, double valor) {
        this.modelo = modelo;
        this.placa = placa;
        this.entrada = entrada;
        this.saida = saida;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double preco) {
        this.valor = preco;
    }
    
    
    
}
