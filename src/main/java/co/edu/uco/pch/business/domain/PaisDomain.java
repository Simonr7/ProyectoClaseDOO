package co.edu.uco.pch.business.domain;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

public final class PaisDomain {

	private UUID codigo;
	private String nombre;
	
	private PaisDomain(final UUID codigo, final String nombre)
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static final PaisDomain build(final UUID codigo, final String nombre)
	{
		return new PaisDomain(codigo, nombre);
	}
	
	public static final PaisDomain build(final UUID codigo)
	{
		return new PaisDomain(codigo, TextHelper.EMPTY);
	}
	
	public static final PaisDomain build()
	{
		return new PaisDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}
	
	// Setters
	
	private void setCodigo(final UUID codigo) {
		this.codigo = UUIDHelper.getDefault(codigo, UUIDHelper.getDefault());
	}
	
	private void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
	
	// Getters
	
	public final UUID getCodigo() {
		return codigo;
	}
	
	public final String getNombre() {
		return nombre;
	}
	
	
}
