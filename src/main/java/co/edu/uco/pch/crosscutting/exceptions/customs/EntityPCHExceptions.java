package co.edu.uco.pch.crosscutting.exceptions.customs;

import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;

public class EntityPCHExceptions extends PCHException  {

	private static final long serialVersionUID = -6316182992428832985L;
	
	public EntityPCHExceptions(final String technicalMessage, final String userMessage, Throwable rootException) {
		super(technicalMessage, userMessage, Lugar.ENTITY, rootException);
	}
}
