package co.edu.uco.pch.crosscutting.exceptions.customs;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class DtoPCHExceptions extends PCHException {
	
	private static final long serialVersionUID = -9112438537604124056L;

	public DtoPCHExceptions(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DTO);
	
	}

	public DtoPCHExceptions(final String mensajeTecnico, final String mensajeUsuario, Throwable exceptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DTO, exceptionRaiz);
	
	}

}
