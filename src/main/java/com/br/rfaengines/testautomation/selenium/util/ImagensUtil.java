package com.br.rfaengines.testautomation.selenium.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class ImagensUtil {

	private static final Logger LOGGER = Logger.getLogger(ImagensUtil.class);

	/**
	 * Copia uma imagem de um local para outro.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param origemImg
	 *            Diretório de origem da imagem.
	 * @param destinoImg
	 *            Diretório onde deve ser salvo a cópia.
	 */
	public static void copiarImagem(String origemImg, String destinoImg) {
		try {
			FileInputStream origem = new FileInputStream(origemImg);
			FileOutputStream destino = new FileOutputStream(destinoImg);
			FileChannel fcOrigem = origem.getChannel();
			FileChannel fcDestino = destino.getChannel();
			fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);
			origem.close();
			destino.close();
		} catch (Exception e) {
			LOGGER.error("Falha ao copiar imagem ", e);
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * Salvar uma imagem da web em um diretório.
	 * 
	 * @author roger_azevedo
	 * @since 18/05/2018
	 * @param urlImg
	 *            Url web da imagem
	 * @param dirDestinoImg
	 *            Diretório onde deve ser salvo a cópia.
	 */
	public static void salvarWebImagem(String urlImg, String dirDestinoImg) {
		try {
			BufferedImage saveImage = ImageIO.read(new URL(urlImg));
			ImageIO.write(saveImage, "png", new File(dirDestinoImg));
		} catch (Exception e) {
			LOGGER.error("Falha ao salvar imagem", e);
		}
	}
	
	/**
	 * Salvar uma imagem em um diretório.
	 * 
	 * @author roger_azevedo
	 * @since 18/05/2018
	 * @param dirOrigemImg
	 *            Diretório de origem da imagem.
	 * @param dirDestinoImg
	 *            Diretório onde deve ser salvo a cópia.
	 */
	public static void salvarImagem(String dirOrigemImg, String dirDestinoImg) {
		try {
			BufferedImage saveImage = ImageIO.read(new File(dirOrigemImg));
			ImageIO.write(saveImage, "png", new File(dirDestinoImg));
		} catch (Exception e) {
			LOGGER.error("Falha ao salvar imagem", e);
		}
	}

}
