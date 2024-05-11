package co.edu.uco.pch.crosscutting.exceptions.customs;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class DataPCHExceptions extends PCHException {
	
	private static final long serialVersionUID = -9112438537604124056L;

	public DataPCHExceptions(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DATA);
	
	}
	
	public DataPCHExceptions(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario, Lugar.DATA);
	}


	public DataPCHExceptions(final String mensajeTecnico, final String mensajeUsuario, Throwable exceptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DATA, exceptionRaiz);
	
	}


}
