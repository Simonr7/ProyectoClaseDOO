package co.edu.uco.pch.entity;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.entity.CoreEntity;

public final class CiudadEntity extends CoreEntity {
	
	private String nombre;
	private DepartamentoEntity departamento;
	
	public CiudadEntity()
	{
		super();
	}
	
	public CiudadEntity( UUID codigo, String nombre, DepartamentoEntity departamento )
	{
		setCodigo( codigo );
		setNombre( nombre );
		setDepartamento( departamento );
	}
	
	// Setters
	
	public final CiudadEntity setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final CiudadEntity setDepartamento( DepartamentoEntity departamento )
	{
		ExceptionHandler.checkDTONullParameter(departamento);
		
		this.departamento = departamento;
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}
	
	public final DepartamentoEntity getDepartamento() {return this.departamento;}

}
