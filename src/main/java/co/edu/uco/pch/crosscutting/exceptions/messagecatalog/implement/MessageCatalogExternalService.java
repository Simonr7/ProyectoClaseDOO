package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.implement;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.pch.crosscutting.exceptions.customs.CrosscuttingPCHExceptions;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;

public final class MessageCatalogExternalService implements MessageCatalog {
	
	private final Map<String, Mensaje> mensajes = new HashMap<>();

	@Override
	public final void initialize() {
		
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00007.getIdentifier(), new Mensaje(CodigoMensaje.M00007, "La transacción se ha completado de forma satisfactoria."));
		mensajes.put(CodigoMensaje.M00010.getIdentifier(), new Mensaje(CodigoMensaje.M00010, "No se pudo completar la transacción por que no se enviarion los suficientes parámetros."));
	}

	@Override
	public final String getContenido(CodigoMensaje codigo, String... params) {
		return TextHelper.replaceParams(getMensaje(codigo, params).getContenido(), params);
	}

	@Override
	public final Mensaje getMensaje(CodigoMensaje codigo, String... params) {
		
		if (ObjectHelper.getObjectHelper().isNull(codigo))
		{
			var userMessage = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var technicalMessage = MessageCatalogStrategy.getContenido(CodigoMensaje.M00001);
			
			throw new CrosscuttingPCHExceptions(technicalMessage, userMessage);
		}
		
		if (codigo.getIsBase())
		{
			var userMessage = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var technicalMessage = MessageCatalogStrategy.getContenido(CodigoMensaje.M00005, codigo.getIdentifier());
			
			throw new CrosscuttingPCHExceptions(technicalMessage, userMessage);
		}
		
		if (!mensajes.containsKey(codigo.getIdentifier()))
		{
			var userMessage = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var technicalMessage = MessageCatalogStrategy.getContenido(CodigoMensaje.M00006, codigo.getIdentifier());
			
			throw new CrosscuttingPCHExceptions(technicalMessage, userMessage);
		}
		
		return mensajes.get(codigo.getIdentifier());
	}

	@Override
	public String getMensajeContenido(CodigoMensaje codigo, String... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
