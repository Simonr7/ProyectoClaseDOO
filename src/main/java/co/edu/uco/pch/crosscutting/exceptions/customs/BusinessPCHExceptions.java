package co.edu.uco.pch.crosscutting.exceptions.customs;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public class BusinessPCHExceptions extends PCHException {

	private static final long serialVersionUID = 1619186187440729387L;

	public BusinessPCHExceptions(String technicalMessage, String userMessage, Throwable rootException) {
		super(technicalMessage, userMessage, Lugar.BUSINESS, rootException);
	}

}
