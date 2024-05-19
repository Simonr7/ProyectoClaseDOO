package co.edu.uco.pch.business.assembler;

public interface Assembler<D, X> {

	D toDomain(X data);
}
