package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.pch.crosscutting.exceptions.customs.DataPCHExceptions;
import co.edu.uco.pch.data.dao.entity.CiudadDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.entity.CiudadEntity;



public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

	public CiudadAzureSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final CiudadEntity data) {
		
		final StringBuilder sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO Ciudad (id, nombre, departamento) ");
		sentenciaSql.append("SELECT ?, ?, ?");
		
		try(final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())){
			
			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());
			
			sentenciaSqlPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			
			var mensajeUsuario = "Se ha presentado un problema tratando de crear una ciudad, Si el problema persiste contacte al administrador";
			var mensajeTecnico = "Se ha presentado una excepción tipo SQLException tratando de realizar el insert de la ciudad ... en la tabla Pais de la base de datos Azure SQL. Para más detalles, revise de forma completa la excepción raíz presentada";
			
			
			throw new DataPCHExceptions(mensajeUsuario, mensajeTecnico, excepcion);
		} catch (final Exception excepcion) {
			
			var mensajeUsuario = "Se ha presentado un problema tratando de crear una ciudad, Si el problema persiste contacte al administrador";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar el insert de la ciudad ... en la tabla Pais de la base de datos Azure SQL. Para más detalles, revise de forma completa la excepción raíz presentada";
			
			
			throw new DataPCHExceptions(mensajeUsuario, mensajeTecnico, excepcion);
			
			
		}
		
	}

	public List<CiudadEntity> consultar(CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(CiudadEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}


	

}
