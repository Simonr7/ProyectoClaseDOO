package co.edu.uco.pch.crosscutting.exceptions.messagecatalog;

import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;

public interface MessageCatalog {

	void initialize();
	
	String getMensajeContenido(final CodigoMensaje codigo, String... params);
	
	Mensaje getMensaje(final CodigoMensaje codigo, String... params);

	String getContenido(CodigoMensaje codigo, String... params);
}
