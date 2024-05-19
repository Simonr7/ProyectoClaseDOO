package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.implement;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.pch.crosscutting.exceptions.customs.CrosscuttingPCHExceptions;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
	
public final class MessageCatalogBase implements MessageCatalog {

	private final Map<String, Mensaje> mensajes = new HashMap<>();
	
	@Override
	public final void initialize() {
	
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentifier(), new Mensaje(CodigoMensaje.M00001, "El código del mensaje que se quiere obtener del catalogo de messages llegó nulo."));
		mensajes.put(CodigoMensaje.M00002.getIdentifier(), new Mensaje(CodigoMensaje.M00002, "Se ha presentado un problema tratando de llevar a cabo la operación deseada."));
		mensajes.put(CodigoMensaje.M00003.getIdentifier(), new Mensaje(CodigoMensaje.M00003, "El identificador del mensaje \"{0}\" que se intentó obtener no está en el catálogo de messages base."));
		mensajes.put(CodigoMensaje.M00004.getIdentifier(), new Mensaje(CodigoMensaje.M00004, "El mensaje con identificador \"{0}\" que se intentó obtener no está configurado para residir en el catálogo de messages base."));
		mensajes.put(CodigoMensaje.M00005.getIdentifier(), new Mensaje(CodigoMensaje.M00005, "El mensaje con identificador \"{0}\" que se intentó obtener no está configurado para residir en el catálogo de messages externo."));
		mensajes.put(CodigoMensaje.M00006.getIdentifier(), new Mensaje(CodigoMensaje.M00006, "El identificador del mensaje \"{0}\" que se intentó obtener no está en el catálogo de messages externo."));
 
		mensajes.put(CodigoMensaje.M00007.getIdentifier(), new Mensaje(CodigoMensaje.M00007,
				"Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00008.getIdentifier(), new Mensaje(CodigoMensaje.M00008,
				"Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00009.getIdentifier(), new Mensaje(CodigoMensaje.M00009,
				"Se ha intentado realizar el cierre de una conexión SQL que ya estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00010.getIdentifier(), new Mensaje(CodigoMensaje.M00010,
				"Se ha presentado un problema tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00011.getIdentifier(), new Mensaje(CodigoMensaje.M00011,
				"Se ha presentado un problema INESPERADO tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00012.getIdentifier(), new Mensaje(CodigoMensaje.M00012,
				"Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00013.getIdentifier(), new Mensaje(CodigoMensaje.M00013,
				"Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00014.getIdentifier(), new Mensaje(CodigoMensaje.M00014,
				"Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00015.getIdentifier(), new Mensaje(CodigoMensaje.M00015,
				"Se ha presentado un problema INESPERADO tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00016.getIdentifier(), new Mensaje(CodigoMensaje.M00016,
				"Se ha intentado cancelar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00017.getIdentifier(), new Mensaje(CodigoMensaje.M00017,
				"Se ha intentado cancelar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00018.getIdentifier(), new Mensaje(CodigoMensaje.M00018,
				"Se ha presentado un problema tratando de cancelar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00019.getIdentifier(), new Mensaje(CodigoMensaje.M00019,
				"Se ha presentado un problema INESPERADO tratando de cancelar una transacción SQL con la fuente de información deseada..."));
 
		mensajes.put(CodigoMensaje.M00020.getIdentifier(), new Mensaje(CodigoMensaje.M00020,
				"Se ha intentado iniciar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00021.getIdentifier(), new Mensaje(CodigoMensaje.M00022,
				"Se ha presentado un problema tratando de iniciar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00022.getIdentifier(), new Mensaje(CodigoMensaje.M00022,
				"Se ha presentado un problema INESPERADO tratando de iniciar una transacción SQL con la fuente de información deseada..."));
	}

	@Override
	public final String getContenido(CodigoMensaje codigo, String... params) {
		
		return TextHelper.replaceParams(getMensaje(codigo, params).getContenido(), params);
	}

	@Override
	public final Mensaje getMensaje(final CodigoMensaje codigo, final String... params) {
		
		if (ObjectHelper.getObjectHelper().isNull(codigo))
		{
			var userMessage = getContenido(CodigoMensaje.M00002);
			var technicalMessage = getContenido(CodigoMensaje.M00001);
			
			throw new CrosscuttingPCHExceptions(technicalMessage, userMessage);
		}
		
		if (!codigo.getIsBase())
		{
			var userMessage = getContenido(CodigoMensaje.M00002);
			var technicalMessage = getContenido(CodigoMensaje.M00004, codigo.getIdentifier());
			
			throw new CrosscuttingPCHExceptions(technicalMessage, userMessage);
		}
		
		if (!mensajes.containsKey(codigo.getIdentifier()))
		{
			var userMessage = getContenido(CodigoMensaje.M00002);
			var technicalMessage = getContenido(CodigoMensaje.M00003, codigo.getIdentifier());
			
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
