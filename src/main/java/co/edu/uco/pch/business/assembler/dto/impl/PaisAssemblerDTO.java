package co.edu.uco.pch.business.assembler.dto.impl;

import co.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.business.domain.PaisDomain;
import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;
import co.edu.uco.pch.dto.PaisDTO;

public final class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisDTO>{
	
	private static final AssemblerDTO<PaisDomain, PaisDTO> INSTANCE = new PaisAssemblerDTO();
	
	private PaisAssemblerDTO() {super();}
	
	public static final AssemblerDTO<PaisDomain, PaisDTO> getInstance() {return INSTANCE;}

	@Override
	public PaisDomain toDomain(PaisDTO data) {
		
		PaisDTO paisDtoTmp = getObjectHelper().getDefaultValue(data, new PaisDTO());
		
		return PaisDomain.build(paisDtoTmp.getCodigo(), paisDtoTmp.getNombre());
	}

	@Override
	public PaisDTO toDTO(PaisDomain domain) {
		
		PaisDomain paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		
		return new PaisDTO(paisDomainTmp.getCodigo(), paisDomainTmp.getNombre());
	}
}
