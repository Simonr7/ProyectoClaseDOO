package co.edu.uco.pch.entity;

import java.util.UUID; 

import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

public class CoreEntity {
	
	private UUID codigo;
	
	protected CoreEntity () { super(); }
	
	public final CoreEntity setCodigo( UUID newCode )
	{
		this.codigo = UUIDHelper.getDefault(newCode, UUIDHelper.getDefault());
		return this;
	}
	
	public final UUID getCodigo() { return this.codigo; }

}
