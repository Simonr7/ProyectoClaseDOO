package co.edu.uco.pch.business.assembler.entity.impl;

import co.edu.uco.pch.business.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.entity.CiudadEntity;
import co.edu.uco.pch.entity.DepartamentoEntity;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class CiudadAssemblerEntity implements AssemblerEntity<CiudadDomain, CiudadEntity> {
	
	private static final AssemblerEntity<CiudadDomain, CiudadEntity> INSTANCE = new CiudadAssemblerEntity();
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> deptoAssembler = DepartamentoAssemblerEntity.getInstance();
	
	private CiudadAssemblerEntity() {super();}
	
	public static final AssemblerEntity<CiudadDomain, CiudadEntity> getInstance() {return INSTANCE;}

	@Override
	public CiudadDomain toDomain(CiudadEntity data) {
		
		CiudadEntity ciudadEntityTmp = getObjectHelper().getDefaultValue(data, new CiudadEntity());
		
		return CiudadDomain.build(
				
				ciudadEntityTmp.getCodigo(),
				ciudadEntityTmp.getNombre(),
				deptoAssembler.toDomain(ciudadEntityTmp.getDepartamento())
		);
	}

	@Override
	public CiudadEntity toEntity(CiudadDomain domain) {
		
		CiudadDomain ciudadDomTmp = getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
		
		return new CiudadEntity(
				
				ciudadDomTmp.getCodigo(),
				ciudadDomTmp.getNombre(),
				deptoAssembler.toEntity(ciudadDomTmp.getDepartamento())
		);
	}
}
