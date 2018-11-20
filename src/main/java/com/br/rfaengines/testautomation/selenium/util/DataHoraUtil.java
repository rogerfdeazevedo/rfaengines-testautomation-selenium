package com.br.rfaengines.testautomation.selenium.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataHoraUtil {

	/**
	 * Recupera a data/hora de acordo com o formato indicado.
	 * 
	 * @author roger_azevedo
	 * @since 17/05/2018
	 * @param formato
	 *            Formato desejado. Ex.: yyyyMMddHHmmss
	 * @return Retorna data/hora de acordo com o formato indicado.
	 */
	public static String getData(String formato) {
		SimpleDateFormat sdfDate = new SimpleDateFormat(formato);
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

}
