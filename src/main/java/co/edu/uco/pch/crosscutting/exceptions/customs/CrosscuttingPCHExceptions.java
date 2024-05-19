package co.edu.uco.pch.crosscutting.exceptions.customs;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public class CrosscuttingPCHExceptions extends PCHException  {

	private static final long serialVersionUID = -6316182992428832985L;

	public CrosscuttingPCHExceptions(final String technicalMessage, final String userMessage, Throwable rootException) {
		super(technicalMessage, userMessage, Lugar.CROSSCUTTING, rootException);
	}
	
	public CrosscuttingPCHExceptions(final String technicalMessage, final String userMessage) {
		super(technicalMessage, userMessage, Lugar.CROSSCUTTING);
	}
	
}
