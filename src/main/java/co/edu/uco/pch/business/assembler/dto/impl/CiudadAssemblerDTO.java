package co.edu.uco.pch.business.assembler.dto.impl;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.dto.DepartamentoDTO;

public final class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO>{
	
	private static final AssemblerDTO<CiudadDomain, CiudadDTO> INSTANCE = new CiudadAssemblerDTO();
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> departamentoAssembler = DepartamentoAssemblerDTO.getInstance();
	
	private CiudadAssemblerDTO() {super();}
	
	public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance() {return INSTANCE;}

	@Override
	public CiudadDomain toDomain(CiudadDTO data) {
		
		CiudadDTO ciudadDtoTmp = getObjectHelper().getDefaultValue(data, new CiudadDTO());
		
		return CiudadDomain.build(
				
				ciudadDtoTmp.getCodigo(), 
				ciudadDtoTmp.getNombre(), 
				departamentoAssembler.toDomain(ciudadDtoTmp.getDepartamento())
		);
	}

	@Override
	public CiudadDTO toDTO(CiudadDomain domain) {
		
		CiudadDomain ciudadDomainTmp = getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
		
		return new CiudadDTO(
				
				ciudadDomainTmp.getCodigo(), 
				ciudadDomainTmp.getNombre(), 
				departamentoAssembler.toDTO(ciudadDomainTmp.getDepartamento())
		);
	}	
}
