package co.edu.uco.pch.dto;

import java.util.UUID;

import co.edu.uco.qiu.config.crosscutting.helpers.ExceptionHandler;
import co.edu.uco.qiu.config.crosscutting.helpers.StringTool;
import co.edu.uco.qiu.config.dto.CoreDTO;

public final class DepartamentoDTO extends CoreDTO {

	private String nombre;
	private PaisDTO pais;
	
	public DepartamentoDTO()
	{
		super();
	}
	
	public DepartamentoDTO( UUID code, String name, PaisDTO pais )
	{
		setCodigo( code );
		setNombre( name );
		setPais( pais );
	}
	
	// Setters
	
	public final DepartamentoDTO setNombre( String nombre )
	{
		ExceptionHandler.checkDTONullParameter(nombre);
		
		this.nombre = StringTool.applyTrim(nombre);
		return this;
	}
	
	public final DepartamentoDTO setPais( PaisDTO pais )
	{
		ExceptionHandler.checkDTONullParameter(pais);
		
		this.pais = pais;
		return this;
	}
	
	// Getters
	
	public final String getNombre() {return this.nombre;}
	
	public final PaisDTO getPais() {return this.pais;}
	
}
