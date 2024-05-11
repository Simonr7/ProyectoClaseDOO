package co.edu.uco.pch.crosscutting.exceptions.customs;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class DefaultPCHExceptions extends PCHException {
	
	private static final long serialVersionUID = -9112438537604124056L;

	public DefaultPCHExceptions(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DEFAULT);
	
	}

	public DefaultPCHExceptions(final String mensajeTecnico, final String mensajeUsuario, Throwable exceptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DEFAULT, exceptionRaiz);
	
	}

}
