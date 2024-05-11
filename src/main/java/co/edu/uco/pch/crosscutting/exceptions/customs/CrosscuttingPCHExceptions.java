package co.edu.uco.pch.crosscutting.exceptions.customs;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public final class CrosscuttingPCHExceptions extends PCHException {
	
	private static final long serialVersionUID = -7289308713860840516L;
	private static final Lugar lugar = Lugar.CROSSCUTTTING;

	public CrosscuttingPCHExceptions(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}
	
	public CrosscuttingPCHExceptions(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario,lugar);
	}

	public CrosscuttingPCHExceptions(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
