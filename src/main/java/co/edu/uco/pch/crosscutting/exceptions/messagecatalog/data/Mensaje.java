package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data;

import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;

public final class Mensaje{

	private CodigoMensaje codigo;
	private String contenido;
	
	public Mensaje( final CodigoMensaje codigo, final String contenido)
	{
		setCodigo(codigo);
		setContenido(contenido);
	}

	public final CodigoMensaje getCodigo() {
		return this.codigo;
	}

	public void setCodigo(CodigoMensaje codigo) {
		this.codigo = codigo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public final String getIdentifier()
	{
		return this.getCodigo().getIdentifier();
	}
	
	public boolean isBase()
	{
		return this.codigo.getIsBase();
	}
}

