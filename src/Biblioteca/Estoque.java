package biblioteca;

public class Estoque {
    int id;
    String autor;
    String titulo;
    String editora;
    String ano_publicacao;
    int quantidade;

    public Estoque(int id, String autor, String titulo, String editora, String ano_publicacao, int quantidade) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
        this.quantidade = quantidade;
    }

    /*
    public Estoque(String autor, String titulo, String editora, String ano_publicacao, int quantidade) {
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
        this.quantidade = quantidade;
    }*/
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(String ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
