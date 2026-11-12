package br.edu.exemplo.dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorEventos {
    private static GerenciadorEventos instance = null;

    private List<Venda> vendas = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();
  
    public static GerenciadorEventos getInstance() {
      if (instance == null) {
          instance = new GerenciadorEventos();
      }
      return instance;
    }

    private GerenciadorEventos() {
      this.vendas = new ArrayList<>();
      this.eventos = new ArrayList<>();
    }

    // ---------- Eventos ----------


    public void cadastrarEvento(Evento evento) {
        // se já existe id --> erro
        eventos.add(evento);
    }

    public Evento buscarEvento(String id) {
        Optional<Evento> evento = eventos.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
        return evento.orElse(null);
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    // ---------- Vendas ----------

    public void cadastrarVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Venda> getVendas() {
        return vendas;
    }
  
}
