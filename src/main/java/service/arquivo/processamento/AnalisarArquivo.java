package service.arquivo.processamento;

import entity.Cliente;
import entity.Venda;
import entity.Vendedor;
import exception.ExErroLinhaArquivo;
import service.ClienteService;
import service.VendaService;
import service.VendedorService;
import service.arquivo.ISalvarArquivo;
import service.arquivo.ResultadoAnalise;
import util.ArquivoUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class AnalisarArquivo implements IProcessaArquivo {

    private static final Logger LOGGER = Logger.getLogger(AnalisarArquivo.class.getName());

    private static final String CARACTERE_SEPARADOR = "ç";

    private ISalvarArquivo salvarArquivo = new ResultadoAnalise();
    private IProcessaLinha linhaCliente = new AnalisarLinhaCliente();
    private IProcessaLinha linhaVendedor = new AnalisarLinhaVendedor();
    private IProcessaLinha linhaVenda = new AnalisarLinhaVenda();

    /**
     * Processa as informações do arquivo contido na pasta C:/temp/in no formato .DAT
     *
     * @param file
     */
    @Override
    public void processaArquivo(File file) throws FileNotFoundException {
        linhaCliente = new AnalisarLinhaCliente();
        linhaVenda = new AnalisarLinhaVenda();
        linhaVendedor = new AnalisarLinhaVendedor();

        limparListas();


        if (!file.exists()) {
            throw new FileNotFoundException("Arquivo não localizado");
        }


        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                LOGGER.info("processando linhas do arquivo...");
                processaLinha(new String(linha.getBytes(), StandardCharsets.UTF_8));
            }

            fileReader.close();
            bufferedReader.close();

            salvarArquivo.salvar(file.getName());

        } catch (IOException ioException) {
            LOGGER.warning("Erro! " + ioException.toString());
            ioException.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException arrayEx) {
            LOGGER.warning("Erro! " + arrayEx.toString());
            arrayEx.printStackTrace();
        } catch (ExErroLinhaArquivo exErroLinhaArquivo) {
            LOGGER.warning("Erro! " + exErroLinhaArquivo.toString());
            exErroLinhaArquivo.printStackTrace();
        }
    }

    /**
     * Verifica se o arquivo está no formato padrão para realizar o processando das informações do mesmo
     *
     * @param file
     */
    @Override
    public void verificaArquivo(File file) throws FileNotFoundException {
        if (ArquivoUtil.isArquivoFormatado(file)) {
            LOGGER.info("Analisando o arquivo: " + file.toString());
            processaArquivo(file);
        } else {
            LOGGER.warning("Arquivo não é valido " + file.toString());
            throw new FileNotFoundException("Arquivo não localizado");
        }
    }

    /**
     * Verifica qual linha deve processar e distribui para o processo correto.
     *
     * @param linha
     * @throws ExErroLinhaArquivo
     */
    public void processaLinha(String linha) throws ExErroLinhaArquivo {
        String[] str = linha.split(CARACTERE_SEPARADOR);

        String tipoLinha = str[0];

        if (tipoLinha.equals(EDados.VENDEDOR.getDescricao())) {
            processaLinhaVendedor(str);
        } else if (tipoLinha.equals(EDados.CLIENTE.getDescricao())) {
            processaLinhaCliente(str);
        } else if (tipoLinha.equals(EDados.VENDA.getDescricao())) {
            processaLinhaVendas(str);
        } else {
            throw new ExErroLinhaArquivo("Formato de linha do arquivo não é suportado");
        }
    }

    /**
     * Processa as linhas referente ao Cliente.
     *
     * @param linha
     */
    private void processaLinhaCliente(String[] linha) {
        LOGGER.info("Processando linha cliente");
        ClienteService.adicionaCliente((Cliente) linhaCliente.processaLinha(linha));
    }

    /**
     * Processa as linhas referente ao Vendedor.
     *
     * @param linha
     */
    private void processaLinhaVendedor(String[] linha) {
        LOGGER.info("Processando linha vendedor");
        VendedorService.adicionaVendedor((Vendedor) linhaVendedor.processaLinha(linha));
    }

    /**
     * Processa as linhas referente as Vendas.
     *
     * @param linha
     */
    private void processaLinhaVendas(String[] linha) {
        LOGGER.info("Processando linha venda");
        VendaService.adicionaVenda((Venda) linhaVenda.processaLinha(linha));
    }

    public void limparListas() {
        VendaService.limparLista();
        VendedorService.limparLista();
        ClienteService.limparLista();
    }
}
