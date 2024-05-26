package co.edu.uco.pch.dto;

import java.util.UUID; 

import co.edu.uco.pch.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.dto.CoreDTO;

public final class CiudadDTO extends CoreDTO {
	
	private String nombre;
	private DepartamentoDTO departamento;
	
	public CiudadDTO()
	{
		super();
	}
	
	public CiudadDTO( UUID codigo, String nombre, DepartamentoDTO departamento )
	{
		setCodigo( codigo );
		setNombre( nombre );
		setDepartamento( departamento );
	}
	
	// Setters
	
	public final CiudadDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	
	public final CiudadDTO setDepartamento( DepartamentoDTO departamento )
	{
		ExceptionHandler.checkDTONullParameter(departamento);
		
		this.departamento = departamento;
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}
	
	public final DepartamentoDTO getDepartamento() {return this.departamento;}

}
