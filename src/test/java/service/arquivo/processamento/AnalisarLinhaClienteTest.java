package service.arquivo.processamento;

import entity.Cliente;
import org.junit.Assert;
import org.junit.Test;
import service.ClienteService;

public class AnalisarLinhaClienteTest {

    @Test
    public void adicionaClienteTest(){
        Cliente cliente = new Cliente(1,"1231313123123", "Teste", "TI");
        ClienteService.adicionaCliente(cliente);
        Assert.assertEquals(1, ClienteService.buscaTotalDeClientes());
    }
}
