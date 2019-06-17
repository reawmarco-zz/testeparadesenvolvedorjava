package service;

import entity.Venda;
import service.dados.DadosVenda;

public class VendaService {

    private static final DadosVenda DADOS_VENDA;

    static {
        DADOS_VENDA = new DadosVenda();
    }

    /**
     * adiciona uma nova venda a lista
     *
     * @param venda
     */
    public static void adicionaVenda(Venda venda) {
        DADOS_VENDA.adicionaVenda(venda);
    }

    /**
     * Método estático para buscar o ID da maior venda realizada.
     *
     * @return
     */
    public static int buscarIDMaiorVenda() {
        return DADOS_VENDA.buscarMaiorVenda();
    }

    /**
     * Método estático para buscar a pior venda realizada.
     *
     * @return
     */
    public static String buscarNomeVendedorDaPiorVenda() {
        return DADOS_VENDA.buscarNomeVendedorMenorVenda();
    }

    public static void limparLista() {
        DADOS_VENDA.limparLista();
    }
}
