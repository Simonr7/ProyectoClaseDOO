package co.edu.uco.pch.business.assembler.entity;

import co.edu.uco.pch.business.assembler.Assembler;

public interface AssemblerEntity<D, X> extends Assembler<D, X> {

	X toEntity(D domain);
}
