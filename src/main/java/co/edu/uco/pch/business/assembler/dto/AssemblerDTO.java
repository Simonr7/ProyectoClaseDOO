package co.edu.uco.pch.business.assembler.dto;

import co.edu.uco.pch.business.assembler.Assembler;

public interface AssemblerDTO<D, X> extends Assembler<D, X> {

	X toDTO(D domain);
}
