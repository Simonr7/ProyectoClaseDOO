package co.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.UUID;

import co.edu.uco.pch.business.assembler.entity.impl.CiudadAssemblerEntity;
import co.edu.uco.pch.business.assembler.entity.impl.DepartamentoAssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.usecase.UseCaseNoReturn;
import co.edu.uco.pch.crosscutting.exceptions.customs.BusinessPCHExceptions;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.entity.CiudadEntity;
import co.edu.uco.pch.entity.DepartamentoEntity;

public final class RegistrarCiudad implements UseCaseNoReturn<CiudadDomain> {
	
	private DAOFactory factory;
	
	public RegistrarCiudad( final DAOFactory factory ) {
		
		if (ObjectHelper.getObjectHelper().isNull(factory))
		{
			String userMessage = "Se ha presentado un problema registrando la ciudad.";
			String technicalMessage = "El DAOFactory para crear la ciudad llegó nulo.";
			
			throw new BusinessPCHExceptions(technicalMessage, userMessage, null);
		}
		
		this.factory = factory;
	}
	
	private final UUID generateCiudadUUID()
	{
		UUID codigo = UUIDHelper.generate();
		boolean codigoExists = true;
		
		while (codigoExists)
		{
			codigo = UUIDHelper.generate();
			CiudadEntity ciudadEnt = new CiudadEntity(codigo, TextHelper.EMPTY, new DepartamentoEntity());
			var result = factory.getCiudadDAO().retrieve(ciudadEnt);
			codigoExists = !result.isEmpty();
		}
		
		return codigo;
	}
	
	private final void validateSimilaridadCiudadDepartamento(final String nombreCiudad, final String departamento, UUID idDepto)
	{
		CiudadEntity ciudadEnt = new CiudadEntity(UUIDHelper.getDefault(), nombreCiudad, new DepartamentoEntity());
				
		var result = factory.getCiudadDAO().retrieve(ciudadEnt);
		
		if (result.isEmpty())
		{
			
		}
		else
		{
			String userMessage = "Ya existe una ciudad con el mismo nombre ({0}) y departamento ({1}).";
			
			throw new BusinessPCHExceptions(userMessage, userMessage, null);
		}
	}

	@Override
	public final void execute(CiudadDomain data) {
		
		// 1. Validar que los datos requeridos por el case de uso sean correctos según las especificaciones establecidas
		// 2. Validar que no exista otra ciudad con el mismo nombre y departamento
		// 3. Validar que no exista otra ciudad con el mismo código
		CiudadEntity ciudadEnt = new CiudadEntity(generateCiudadUUID(), data.getNombre(), DepartamentoAssemblerEntity.getInstance().toEntity(data.getDepartamento()));
		// Guardar la ciudad
		factory.getCiudadDAO().create(ciudadEnt);
	}
}
