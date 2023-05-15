package LocadoraDeCarros;

public class Aluguel {
    int id;
    String marca;
    String modelo;
    int ano; 
    Double valor;
    String completo;

    public Aluguel(int id, String marca, String modelo, int ano, Double valor, String completo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.completo = completo;
    }

    public Aluguel(String marca, String modelo, int ano, Double valor, String completo) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.completo = completo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCompleto() {
        return completo;
    }

    public void setCompleto(String completo) {
        this.completo = completo;
    }
    
    
}
