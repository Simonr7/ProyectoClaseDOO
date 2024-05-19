package co.edu.uco.pch.crosscutting.exceptions.customs;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public class DtoPCHExceptions extends PCHException  {

	private static final long serialVersionUID = -6316182992428832985L;

	public DtoPCHExceptions(final String technicalMessage, final String userMessage, Throwable rootException) {
		super(technicalMessage, userMessage, Lugar.DTO, rootException);
	}
	
}
