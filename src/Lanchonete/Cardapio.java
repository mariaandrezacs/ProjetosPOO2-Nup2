
package Lanchonete;

public class Cardapio {
    int id;
    String tipo;
    String descricao;
    Double preco;

    public Cardapio(String tipo, String descricao, Double preco) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.preco = preco;
    }
    

    public Cardapio(int id, String tipo, String descricao, Double preco) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
