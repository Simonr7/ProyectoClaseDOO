package co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data;

public final class Mensaje {
	
	private CodigoMensaje codigo;
	private String contenido;
	
	
	
	public Mensaje(final CodigoMensaje codigo,final  String contenido) {
		setCodigo(codigo);
		setContenido(contenido);
	}



	private final void setCodigo(CodigoMensaje codigo) {
		this.codigo = codigo;
	}


	private final void setContenido(String contenido) {
		this.contenido = contenido;
	}



	public final CodigoMensaje getCodigo() {
		return codigo;
	}

	public final String getContenido() {
		return contenido;
	}
	
	public final boolean esBase() {
		
		return getCodigo().isBase();
		
	}
	
	public final String getIdentificador() {
		
		return getCodigo().getIdentificador();
		
	}
	
	
	


	

}
