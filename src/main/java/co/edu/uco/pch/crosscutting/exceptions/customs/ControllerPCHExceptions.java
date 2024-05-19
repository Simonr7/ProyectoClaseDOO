package co.edu.uco.pch.crosscutting.exceptions.customs;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public class ControllerPCHExceptions extends PCHException {

	private static final long serialVersionUID = 1619186187440729387L;

	public ControllerPCHExceptions(String technicalMessage, String userMessage, Throwable rootException) {
		super(technicalMessage, userMessage, Lugar.CONTROLLER, rootException);
	}

}
