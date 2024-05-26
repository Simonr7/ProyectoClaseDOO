package co.edu.uco.pch.business.assembler.entity.impl;

import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.PaisDomain;
import co.edu.uco.pch.entity.PaisEntity;
import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class PaisAssemblerEntity implements AssemblerEntity<PaisDomain, PaisEntity> {
	
	private static final AssemblerEntity<PaisDomain, PaisEntity> INSTANCE = new PaisAssemblerEntity();
	
	private PaisAssemblerEntity() {super();}
	
	public static final AssemblerEntity<PaisDomain, PaisEntity> getInstance() {return INSTANCE;}

	@Override
	public PaisDomain toDomain(PaisEntity data) {
		
		PaisEntity paisEntityTmp = getObjectHelper().getDefaultValue(data, new PaisEntity());
		
		return PaisDomain.build(
				
				paisEntityTmp.getId(),
				paisEntityTmp.getNombre()
		);
	}

	@Override
	public PaisEntity toEntity(PaisDomain domain) {
		
		PaisDomain paisDomTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		
		return new PaisEntity(
				
				paisDomTmp.getCodigo(),
				paisDomTmp.getNombre()
		);
	}
}
