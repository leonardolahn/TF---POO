package br.edu.exemplo.dados;

public class Evento {
    private String id;
    private String titulo;
    private String descricao;


    public Evento(String id, String titulo, String descricao) {  
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

   public String getId() {
        return id;
    }

    @Override
    public String toString() {
      return "Evento [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + "]";
    }

}
