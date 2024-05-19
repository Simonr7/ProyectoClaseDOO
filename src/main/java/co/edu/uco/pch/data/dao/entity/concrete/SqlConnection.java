package co.edu.uco.pch.data.dao.entity.concrete;

import java.sql.Connection; 

import co.edu.uco.pch.crosscutting.exceptions.customs.CrosscuttingPCHExceptions;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.helpers.SQLHelper;

public class SqlConnection {

	private Connection connection;
	
	protected SqlConnection(final Connection connection)
	{
		setConnection(connection);
	}
	
	protected SqlConnection()
	{
		super();
	}
	
	protected final void setConnection(Connection connection) {
		
		if (!SQLHelper.isOpen(connection))
		{
			var mensajeUsuario = MessageCatalogStrategy.getContenido(CodigoMensaje.M00002);
			var mensajeTecnico = "No es posible crear el DAO con una conexión cerrada.";

			throw new CrosscuttingPCHExceptions(mensajeTecnico, mensajeUsuario);
		}
		
		this.connection = connection;
	}

	protected final Connection getConnection() {
		return connection;
	}
	
}
