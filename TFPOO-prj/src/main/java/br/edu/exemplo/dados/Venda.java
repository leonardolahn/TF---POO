package br.edu.exemplo.dados;

import java.time.LocalDateTime;

//
//  esta classe está bem incompleta...
//

public class Venda {
    private  String id;
    private  String comprador;
    private  LocalDateTime dataHora;
    private  Evento evento;


    public Venda(String id, Evento evento,  String comprador, LocalDateTime dataHora) {
        this.id = id.trim().toUpperCase();
        this.evento = evento;
        this.comprador = comprador.trim();
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
      return "Venda [id=" + id + ", comprador=" + comprador + ", dataHora=" + dataHora + ", evento=" + evento + "]";
    }

    
}
