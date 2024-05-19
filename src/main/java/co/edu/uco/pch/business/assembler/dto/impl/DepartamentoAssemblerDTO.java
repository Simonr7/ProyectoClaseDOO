package co.edu.uco.pch.business.assembler.dto.impl;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.dto.DepartamentoDTO;
import co.edu.uco.pch.dto.PaisDTO;

public final class DepartamentoAssemblerDTO implements AssemblerDTO<DepartamentoDomain, DepartamentoDTO>{
	
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> INSTANCE = new DepartamentoAssemblerDTO();
	private static final AssemblerDTO<PaisDomain, PaisDTO> paisAssembler = PaisAssemblerDTO.getInstance();
	
	private DepartamentoAssemblerDTO() {super();}
	
	public static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> getInstance() {return INSTANCE;}
	
	@Override
	public DepartamentoDomain toDomain(DepartamentoDTO data) {
		
		DepartamentoDTO deptoDtoTmp = getObjectHelper().getDefaultValue(data, new DepartamentoDTO());
		
		return DepartamentoDomain.build(
				
				deptoDtoTmp.getCodigo(), 
				deptoDtoTmp.getNombre(), 
				paisAssembler.toDomain(deptoDtoTmp.getPais())
		);
	}

	@Override
	public DepartamentoDTO toDTO(DepartamentoDomain domain) {
		
		DepartamentoDomain deptoDomainTmp = getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		
		return new DepartamentoDTO(
				deptoDomainTmp.getCodigo(), 
				deptoDomainTmp.getNombre(), 
				paisAssembler.toDTO(deptoDomainTmp.getPais())
		);
	}	
}
