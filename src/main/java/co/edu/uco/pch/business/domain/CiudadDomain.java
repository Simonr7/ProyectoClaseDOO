package co.edu.uco.pch.business.domain;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

public final class CiudadDomain {

	private UUID codigo;
	private String nombre;
	private DepartamentoDomain departamento;
	
	private CiudadDomain(final UUID codigo, final String nombre, final DepartamentoDomain departamento)
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	public static final CiudadDomain build(final UUID codigo, final String nombre, final DepartamentoDomain departamento)
	{
		return new CiudadDomain(codigo, nombre, departamento);
	}
	
	public static final CiudadDomain build(final UUID codigo, final String nombre)
	{
		return new CiudadDomain(codigo, nombre, DepartamentoDomain.build());
	}
	
	public static final CiudadDomain build(final UUID codigo)
	{
		return new CiudadDomain(codigo, TextHelper.EMPTY, DepartamentoDomain.build());
	}
	
	public static final CiudadDomain build()
	{
		return new CiudadDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, DepartamentoDomain.build());
	}
	
	// Setters 
	
	private void setCodigo(final UUID codigo) {
		this.codigo = UUIDHelper.getDefault(codigo, UUIDHelper.getDefault());
	}
	
	private void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
	
	private void setDepartamento(DepartamentoDomain departamento) {
		this.departamento = ObjectHelper.getObjectHelper().getDefaultValue(departamento, DepartamentoDomain.build());
	}
	
	// Getters
	
	public final UUID getCodigo() {
		return codigo;
	}
	
	public final String getNombre() {
		return nombre;
	}

	public final DepartamentoDomain getDepartamento() {
		return departamento;
	}
}
