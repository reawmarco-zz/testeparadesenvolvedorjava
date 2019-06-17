package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    private static List<String> arquivos = new ArrayList<>();

    static {
        arquivos.add("DAT");
    }

    /**
     * Verifica se o arquivo está no formato correto
     *
     * @param strArquivo
     * @return
     */
    public static boolean isArquivoFormatado(String strArquivo) {
        return arquivos.contains(strArquivo.toUpperCase());
    }

    /**
     * Verifica se o arquivo está no formato correto
     *
     * @param file
     * @return
     */
    public static boolean isArquivoFormatado(File file) {
        if (file == null) {
            return false;
        }
        String extencao = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        return arquivos.contains(extencao.toUpperCase());
    }
}
