package service.arquivo;

import org.junit.Assert;
import org.junit.Test;
import util.ArquivoUtil;

import java.io.File;

public class ArquivoUtilTest {

    @Test
    public void recebendoArquivoFormatoDAT() {
        Assert.assertTrue(ArquivoUtil.isArquivoFormatado(new File("file.DAT")));
    }

    @Test
    public void recebendoArquivoCaixaBaixaDAT() {
        Assert.assertTrue(ArquivoUtil.isArquivoFormatado(new File("file.dat")));
    }

    @Test
    public void recebendoArquivoFormatoInvalidoTEXT() {
        Assert.assertFalse(ArquivoUtil.isArquivoFormatado("TXT"));
    }

    @Test
    public void recebendoArquivoFormatoInvalidoDOC() {
        Assert.assertFalse(ArquivoUtil.isArquivoFormatado(new File("file.doc")));
    }
}
