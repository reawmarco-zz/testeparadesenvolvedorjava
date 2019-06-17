package service.dados;

import entity.Cliente;

import java.util.HashMap;

public class DadosCliente {

    private HashMap<String, Cliente> clienteHashMap;

    public DadosCliente() {
        clienteHashMap = new HashMap<>();
    }

    /**
     * Adicionar um novo cliente a lista
     *
     * @param cliente
     */
    public void adicionaCliente(Cliente cliente) {
        clienteHashMap.put(cliente.getCnpj(), cliente);
    }

    /**
     * Buscar o total de clientes armazenados
     *
     * @return
     */
    public int buscarTotalClientes() {
        return clienteHashMap.size();
    }

    public void limparLista() {
        clienteHashMap.clear();
    }
}
