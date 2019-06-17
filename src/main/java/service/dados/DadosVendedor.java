package service.dados;

import entity.Vendedor;

import java.util.HashMap;

public class DadosVendedor {

    private HashMap<String, Vendedor> vendedorHashMap;

    public DadosVendedor() {
        vendedorHashMap = new HashMap<>();
    }

    /**
     * adicionar um novo vendedor a lista
     *
     * @param vendedor
     */
    public void adicionaVendedor(Vendedor vendedor) {
        vendedorHashMap.put(vendedor.getCpf(), vendedor);
    }

    /**
     * Buscar o vendedor pelo nome
     *
     * @param nome
     * @return
     */
    public Vendedor buscarVendedorPeloNome(String nome) {
        return vendedorHashMap.get(nome);
    }

    /**
     * buscar o total de vendedores armazenados
     *
     * @return
     */
    public int buscarTotalDeVendedores() {
        return vendedorHashMap.size();
    }

    public void limparLista() {
        vendedorHashMap.clear();
    }
}
