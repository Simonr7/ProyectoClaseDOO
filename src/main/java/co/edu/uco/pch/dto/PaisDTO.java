package co.edu.uco.pch.dto;

import java.util.UUID; 

import co.edu.uco.pch.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.dto.CoreDTO;

public final class PaisDTO extends CoreDTO {
	
	private String nombre;
	
	public PaisDTO()
	{
		super();
	}
	
	public PaisDTO( final UUID codigo, final String nombre )
	{
		setCodigo( codigo );
		setNombre( nombre );
	}
	
	// Setters
	
	public final PaisDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}

}
