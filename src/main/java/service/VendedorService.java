package service;

import entity.Vendedor;
import service.dados.DadosVendedor;

public class VendedorService {

    private static final DadosVendedor DADOS_VENDEDOR;

    static {
        DADOS_VENDEDOR = new DadosVendedor();
    }

    public static void adicionaVendedor(Vendedor vendedor) {
        DADOS_VENDEDOR.adicionaVendedor(vendedor);
    }

    /**
     * Método estático para buscar o total de vendedores.
     *
     * @return
     */
    public static int buscaTotalDeVendedores() {
        return DADOS_VENDEDOR.buscarTotalDeVendedores();
    }

    /**
     * Método estático para buscar um vendedor.
     *
     * @param nome
     * @return
     */
    public static Vendedor buscarVendedorPeloNome(String nome) {
        Vendedor vendedor = DADOS_VENDEDOR.buscarVendedorPeloNome(nome);
        return vendedor;
    }

    public static void limparLista() {
        DADOS_VENDEDOR.limparLista();
    }
}
