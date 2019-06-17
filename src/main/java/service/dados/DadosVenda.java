package service.dados;

import entity.Venda;

import java.util.ArrayList;
import java.util.List;

public class DadosVenda {

    List<Venda> vendas;

    public DadosVenda() {
        vendas = new ArrayList<>();
    }

    public void adicionaVenda(Venda venda) {
        vendas.add(venda);
    }

    /**
     * Buscar o id da maior venda computada no arquivo de entrada
     *
     * @return
     */
    public int buscarMaiorVenda() {
        int id = 0;
        double valorMaiorVenda = 0.0;
        for (Venda venda : vendas) {
            if (venda.getMontante() > valorMaiorVenda) {
                valorMaiorVenda = venda.getMontante();
                id = venda.getId();
            }
        }
        return id;
    }

    /**
     * Buscar o nome do vendedor que tem o menor valor total das vendas computadas
     * no arquivo de entrada
     *
     * @return
     */
    public String buscarNomeVendedorMenorVenda() {
        String nomeVendedor = vendas.isEmpty() ? null : vendas.get(0).getNomeVendedor();

        double valorMenorVenda = vendas.isEmpty() ? 0.0 : vendas.get(0).getMontante();

        for (Venda venda : vendas) {
            if (venda.getMontante() < valorMenorVenda) {
                nomeVendedor = venda.getNomeVendedor();
            }
        }
        return nomeVendedor;
    }

    public void limparLista() {
        vendas.clear();
    }
}
