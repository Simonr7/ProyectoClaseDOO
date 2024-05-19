package co.edu.uco.pch.data.dao.factory.concrete;

import java.sql.DriverManager; 
import java.sql.SQLException;

import co.edu.uco.pch.crosscutting.helpers.SQLHelper;
import co.edu.uco.pch.data.dao.entity.CiudadDAO;
import co.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import co.edu.uco.pch.data.dao.entity.PaisDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.data.dao.entity.concrete.azuresql.PaisAzureSqlDAO;
import co.edu.uco.pch.data.dao.factory.DAOFactory;

public final class AzureSQLDAOFactory extends SqlConnection implements DAOFactory {
	
	public AzureSQLDAOFactory() {
		
		super();
		
		openConnection();
	}

	@Override
	public void openConnection() {
		
		try
		{
			String connectionString = "jdbc ....";
			setConnection(DriverManager.getConnection(connectionString));
		}
		catch (final SQLException exception)
		{
			
		}
		catch (final Exception exception)
		{
			
		}
	}

	@Override
	public void closeConnection() {
		
		SQLHelper.close(getConnection());
	}

	@Override
	public void startTransaction() {
		
		SQLHelper.initTransaction(getConnection());
		
	}

	@Override
	public void confirmTransaction() {
		
		SQLHelper.commit(getConnection());
		
	}

	@Override
	public void cancelTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisDAO getPaisDAO() {
		
		return new PaisAzureSqlDAO(getConnection());
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
