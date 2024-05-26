package co.edu.uco.pch.business.facade.impl.ciudad;

import java.util.List; 

import co.edu.uco.pch.business.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.business.facade.FacadeWithReturn;
import co.edu.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.customs.BusinessPCHExceptions;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.dto.CiudadDTO;

public final class ConsultarCiudadesFacade implements FacadeWithReturn<CiudadDTO, List<CiudadDTO>> {

	private DAOFactory daoFactory; 
	
	public ConsultarCiudadesFacade() {
		daoFactory = DAOFactory.getFactory();
	}
	@Override
	public void execute(final CiudadDTO dto) {
			
			daoFactory.iniciarTransaccion();
			
			try {
				var useCase = new RegistrarCiudad(daoFactory);
				var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
				useCase.execute(ciudadDomain);
				
				daoFactory.confirmarTransaccion();
			} catch (final PCHException excepcion) {
				daoFactory.cancelarTransaccion();
				throw excepcion;
			} catch (final Exception excepcion) {
				daoFactory.iniciarTransaccion();
				
				var mensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion de la ciudad";
				var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de registrar la informacion de la ciudad";
				
				throw new BusinessPCHExceptions(mensajeTecnico, mensajeUsuario, excepcion);
				
			} finally {
				daoFactory.cerrarConexion();
			}
			
		}
	}

}
