package br.edu.exemplo.dados;


import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import br.edu.exemplo.dados.LeitorDadosCsv.EventoCsv;
import br.edu.exemplo.dados.LeitorDadosCsv.IngressoCsv;
import br.edu.exemplo.dados.LeitorDadosCsv.ModalidadeEventoCsv;
import br.edu.exemplo.dados.LeitorDadosCsv.VendaCsv;

public class TestaLeitura {
    public static void main(String[] args) {
        System.out.println("Iniciando a leitura dos arquivos CSV...");

        try {
            Path caminhoEventos = Path.of("dados/eventos.csv");
            // Path caminhoModalidades = Path.of("dados/modalidades_evento.csv");
            Path caminhoVendas = Path.of("dados/vendas.csv");
            // Path caminhoIngressos = Path.of("dados/ingressos.csv");


            // List<ModalidadeEventoCsv> modalidades = LeitorDadosCsv.lerModalidades(caminhoModalidades);
            List<VendaCsv> vendas = LeitorDadosCsv.lerVendas(caminhoVendas);
            
            // List<IngressoCsv> ingressos = LeitorDadosCsv.lerIngressos(caminhoIngressos);
            List<EventoCsv> eventos = LeitorDadosCsv.lerEventos(caminhoEventos);

            //
            //  Este código é apenas um exemplo e bem incompleto. 
            //  Você deve adaptá-lo para criar os objetos de domínio 
            //  corretos e armazená-los no GerenciadorEventos.
            // 
            
            GerenciadorEventos gerenciador = GerenciadorEventos.getInstance();
            
            //
            // 1. gerar Eventos a partir de EventoCsv e armazená-los no GerenciadorEventos
            //    iniciar por este que não tem dependentes...
            // 

            for (EventoCsv eventoCsv : eventos) {
                Evento evento = new Evento(eventoCsv.id(), eventoCsv.titulo(), eventoCsv.descricao());
                gerenciador.cadastrarEvento(evento);
            }

            //
            // 2. gerar Vendas a partir de VendaCsv e armazená-las no GerenciadorEventos        
            //   (aqui você precisamos buscar o Evento correspondente a cada Venda)
            //

            for (VendaCsv vendaCsv : vendas) {
                Evento evento = gerenciador.buscarEvento(vendaCsv.eventoId());
                if (evento != null) {
                    Venda venda = new Venda(vendaCsv.id(), evento, vendaCsv.comprador(), vendaCsv.dataHora());
                    gerenciador.cadastrarVenda(venda);
                } else {
                    throw new IllegalStateException("Evento não encontrado para a venda: " + vendaCsv.id());
                }
            }
       

            System.out.println("\nEventos encontrados: " + eventos.size());
            //System.out.println("Modalidades de evento encontradas: " + modalidades.size());
            System.out.println("Vendas registradas: " + vendas.size());
            //System.out.println("Ingressos emitidos: " + ingressos.size());


            //System.out.println("\nEventos: \n" + eventos);
            //System.out.println("\nModalidades de evento: \n" + modalidades);

            // 
            // listagem dos eventos cadastrados no GerenciadorEventos 
            //

            System.out.println("\nEventos cadastrados no GerenciadorEventos:");
            for (Evento evento : gerenciador.getEventos()) {
                System.out.println(evento);
            }

            //
            // listagem das 5 primeiras vendas cadastradas no GerenciadorEventos
            //
            System.out.println("\n5 primeiras vendas cadastradas no GerenciadorEventos:");
            int cont=0;
            for (Venda venda : gerenciador.getVendas()) {
                System.out.println(venda);
                cont++;
                if (cont >= 5) break;  
            }

        } catch (IOException e) {
            System.err.println("Ocorreu um erro de I/O ao ler os arquivos CSV: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Erro na estrutura dos dados (colunas incorretas): " + e.getMessage());
        }
    }
}