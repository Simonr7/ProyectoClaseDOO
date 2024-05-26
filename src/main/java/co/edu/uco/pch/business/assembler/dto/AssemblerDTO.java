package co.edu.uco.pch.business.assembler.dto;

import java.util.List;

import co.edu.uco.pch.business.assembler.Assembler;

public interface AssemblerDTO<D, X> extends Assembler<D, X> {

	X toDTO(D domain);
	
	List<X> toDTOCollection(List<D> domain);
}
