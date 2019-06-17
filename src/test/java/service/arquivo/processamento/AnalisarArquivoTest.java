package service.arquivo.processamento;

import org.junit.Assert;
import org.junit.Test;
import service.ClienteService;
import service.VendedorService;

import java.io.File;
import java.io.FileNotFoundException;

public class AnalisarArquivoTest {

    @Test(expected = FileNotFoundException.class)
    public void processandoArquivoErroNaoLocalizadoTest() throws FileNotFoundException {
        AnalisarArquivo analisarArquivo = new AnalisarArquivo();
        File file = new File("src/test/resource/file.dat");
        analisarArquivo.processaArquivo(file);
    }

    @Test
    public void processandoArquivoErroLinhaTest() throws FileNotFoundException {
        AnalisarArquivo analisarArquivo = new AnalisarArquivo();
        File file = new File("src/test/resources/file.dat");
        analisarArquivo.processaArquivo(file);
        new AssertionError(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    public void processandoArquivoErroArrayIndexOutOfBoundsTest() throws FileNotFoundException {
        AnalisarArquivo analisarArquivo = new AnalisarArquivo();
        File file = new File("src/test/resources/file.dat");
        analisarArquivo.processaArquivo(file);
        new AssertionError(ArrayIndexOutOfBoundsException.class);
    }

    @Test
    public void processandoArquivoSemErroTest() throws FileNotFoundException {
        AnalisarArquivo analisarArquivo = new AnalisarArquivo();
        File file = new File("src/test/resources/files.dat");
        analisarArquivo.processaArquivo(file);
    }

    @Test
    public void limparListasTest() {
        AnalisarArquivo analisarArquivo = new AnalisarArquivo();
        analisarArquivo.limparListas();
        Assert.assertEquals(0, ClienteService.buscaTotalDeClientes());
        Assert.assertEquals(0, VendedorService.buscaTotalDeVendedores());
    }
}
