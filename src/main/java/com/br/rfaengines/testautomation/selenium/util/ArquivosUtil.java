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
	 * @param dir
	 *            Caminho onde deve ser criado o novo diretório.
	 */
	public static void criarDir(String dir) {
		File directory = new File(dir);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	/**
	 * Lê um arquivo de texto, linha por linha.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param dirArquivo
	 *            Caminho e nome do arquivo.
	 * @return Retorna uma lista com o conteúdo do arquivo, lido de cada linha.
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
	 * Listar os arquivos de texto (.txt) em um diretório.
	 * 
	 * @author roger_azevedo
	 * @since 27/11/2018
	 * @param dirArquivo
	 *            Caminho e nome do arquivo.
	 * @return Retorna uma lista com o nome dos arquivos de texto no diretorio.
	 */
	public static ArrayList<String> listarArquivosDeTexto(String dirArquivos) {
		ArrayList<String> listaArquivos = new ArrayList<String>();
		try {
			File arquivos[];
			File diretorio = new File(dirArquivos);	
			arquivos = diretorio.listFiles();				
			for(int i = 0; i < arquivos.length; i++){					
				if (arquivos[i].getName().endsWith(".txt")) {					
					String nomeArquivo = arquivos[i].getName();						
					listaArquivos.add(nomeArquivo);							
				} 				   
			}
		} catch (Exception e) {
			LOGGER.error("Falha ao listar arquivos em:  " + dirArquivos, e);
		}
		return listaArquivos;
	}

	/**
	 * Salva um arquivo de texto.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param dirDestino
	 *            Caminho e nome do arquivo.
	 * @param linhasDoArquivo
	 *            Lista com o conteúdo do arquivo, lido de cada linha
	 * 
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
	 * @param dirArquivo
	 *            Caminho e nome do arquivo.
	 * @return Retorna verdadeiro se o arquivo existe, e falso se não existe.
	 */
	public static boolean arquivoExisteNoDir(String dirArquivo) {
		return new File(dirArquivo).exists();
	}
	
	/**
	 * Renomeia um arquivo, alterando sua extensão para ".PROC".
	 * 
	 * @author roger_azevedo
	 * @since 27/11/2018
	 * @param dirArquivo
	 *            Caminho e nome do arquivo.
	 */
	public static void renomearArquivoParaProcessado(String dirArquivo) {
		try {
			if(arquivoExisteNoDir(dirArquivo)) {
				new File(dirArquivo).renameTo(new File(dirArquivo + ".PROC"));
			}			
		} catch (Exception e) {
			LOGGER.error("Falha ao tentar renomear arquivo para processado ", e);
		}
	}

}
