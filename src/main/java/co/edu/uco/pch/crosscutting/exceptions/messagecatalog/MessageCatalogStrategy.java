package co.edu.uco.pch.crosscutting.exceptions.messagecatalog;

import co.edu.uco.pch.crosscutting.exceptions.customs.CrosscuttingPCHExceptions;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.implement.MessageCatalogBase;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.implement.MessageCatalogExternalService;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;

public final class MessageCatalogStrategy {
	
	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService = new MessageCatalogExternalService();
	
	static { initialize(); }
	
	private MessageCatalogStrategy()
	{
		super();
	}
	
	public static void initialize()
	{
		base.initialize();
		externalService.initialize();
	}
	
	private static final MessageCatalog getStrat( final boolean isBase )
	{
		return isBase ? base : externalService;
	}
	
	public static final Mensaje getMensaje( final CodigoMensaje codigo, final String... params)
	{
		if (ObjectHelper.getObjectHelper().isNull(codigo))
		{
			var userMessage = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var technicalMessage = MessageCatalogStrategy.getContenido(CodigoMensaje.M00001);
			
			throw new CrosscuttingPCHExceptions(technicalMessage, userMessage);
		}
		
		return getStrat(codigo.getIsBase()).getMensaje(codigo, params);
	}
	
	public static final String getContenido( final CodigoMensaje codigo, final String... params )
	{	
		if (TextHelper.messageParameters(getMensaje(codigo).getContenido()) > params.length)
		{
			var userMessage = getContenido(CodigoMensaje.M00002);
			var technicalMessage = getContenido(CodigoMensaje.M00009, codigo.getIdentifier());
			
			throw new CrosscuttingPCHExceptions(technicalMessage, userMessage);
		}
		
		return TextHelper.replaceParams(getMensaje(codigo, params).getContenido(), params) ;
	}
}