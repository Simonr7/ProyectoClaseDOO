package co.edu.uco.pch.business.assembler;

import java.util.List;

public interface Assembler<D, X> {

	D toDomain(X data);
	List<D> toDomainCollection(List<X> entityCollection);
}
