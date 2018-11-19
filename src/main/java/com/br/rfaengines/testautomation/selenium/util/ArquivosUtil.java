package com.br.rfaengines.testautomation.selenium.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class ArquivosUtil {

	private static final Logger LOGGER = Logger.getLogger(ArquivosUtil.class);

	/**
	 * Cria um novo diretório no caminho indicado, caso não exista.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param Caminho
	 *            onde deve ser criado o novo diretório.
	 */
	public static void criarDir(String dir) {
		File directory = new File(dir);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	/**
	 * Lê cada linha de um arquivo de texto.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param Caminho
	 *            e nome do arquivo.
	 * @return Retorna uma lista do tipo string, com o conteúdo do arquivo.
	 */
	public static ArrayList<String> lerArquivo(String dirArquivo) {
		ArrayList<String> linhasDoArquivo = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(dirArquivo));
			while (br.ready()) {
				String line = br.readLine();
				linhasDoArquivo.add(line);
			}
			br.close();
		} catch (IOException e) {
			LOGGER.error("Falha ao ler arquivo ", e);
		}
		return linhasDoArquivo;
	}

	/**
	 * Salva um arquivo de texto.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param Caminho
	 *            e nome do arquivo. Lista do tipo string com o conteúdo do arquivo.
	 * @return Retorna uma lista do tipo string, com o conteúdo do arquivo.
	 */
	public static void salvarArquivo(String dirDestino, ArrayList<String> linhasDoArquivo) {
		try {
			if (!linhasDoArquivo.isEmpty()) {
				BufferedWriter StrW = new BufferedWriter(new FileWriter(dirDestino));
				for (int i = 0; i < linhasDoArquivo.size(); i++) {
					StrW.write(linhasDoArquivo.get(i) + "\n");
				}
				StrW.close();
			} else {
				LOGGER.warn("Conteudo do arquivo está vazio.");
			}
		} catch (IOException e) {
			LOGGER.error("Falha ao tentar salvar arquivo ", e);
		}
	}

	/**
	 * Verifica se um arquivo de texto existe no diretório indicado.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param Caminho
	 *            e nome do arquivo.
	 * @return Retorna true se o arquivo existe, e false se não existe.
	 */
	public static boolean arquivoExisteNoDir(String dirArquivo) {
		return new File(dirArquivo).exists();
	}

}
