package service;

import entity.Cliente;
import service.dados.DadosCliente;

public class ClienteService {

    private static final DadosCliente DADOS_CLIENTE;

    static {
        DADOS_CLIENTE = new DadosCliente();
    }

    public static void adicionaCliente(Cliente cliente) {
        DADOS_CLIENTE.adicionaCliente(cliente);
    }

    /**
     * Método estático para buscar o total de clientes.
     *
     * @return
     */
    public static int buscaTotalDeClientes() {
        return DADOS_CLIENTE.buscarTotalClientes();
    }

    public static void limparLista() {
        DADOS_CLIENTE.limparLista();
    }
}
