package co.edu.uco.pch.data.dao.entity.concrete;

import java.sql.Connection;

import co.edu.uco.pch.crosscutting.exceptions.customs.DataPCHExceptions;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.helpers.SQLHelper;
public class SqlConnection {
	
	private Connection conexion;
	
	

	protected SqlConnection(Connection conexion) {
		
		setConexion(conexion);
		
	}
	
	protected SqlConnection() {
		
		super();
		
	}

	protected final Connection getConexion() {
		return conexion;
	}
	
	protected final void setConexion(Connection conexion) {
		
		if(SQLHelper.isOpen(conexion)) {
			
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No es posible crear el DAO deseado con una conexión cerrada";
			
			throw new DataPCHExceptions(mensajeUsuario, mensajeTecnico);
		}
		this.conexion = conexion;
	}

}
