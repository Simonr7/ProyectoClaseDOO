package co.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.List;

import co.edu.uco.pch.business.assembler.entity.impl.CiudadAssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.usecase.UseCaseWithReturn;
import co.edu.uco.pch.crosscutting.exceptions.customs.BusinessPCHExceptions;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.data.dao.factory.DAOFactory;

public class ConsultarCiudades implements UseCaseWithReturn<CiudadDomain, List<CiudadDomain>> {

	private DAOFactory factory;
	
	public ConsultarCiudades( final DAOFactory factory ) {
		
		if (ObjectHelper.getObjectHelper().isNull(factory))
		{
			String userMessage = "Se ha presentado un problema Consultando la ciudad.";
			String technicalMessage = "El DAOFactory para crear la ciudad llegó nulo...";
			
			throw new BusinessPCHExceptions(technicalMessage, userMessage, null);
		}
		
		this.factory = factory;
	}
	@Override
	public final List<CiudadDomain> execute(CiudadDomain data) {
		var CiudadEntityFilter =
				CiudadAssemblerEntity.getInstance().toEntity(data);
	var resultadosEntity = factory.getCiudadDAO().retrieve(CiudadEntityFilter);
	var resultadosDomain = CiudadAssemblerEntity.getInstance()
			.toDomainCollection(resultadosEntity);
		return resultadosDomain;
	}

}
