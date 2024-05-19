package co.edu.uco.pch.crosscutting.helpers;

import co.edu.uco.pch.crosscutting.exceptions.customs.DtoPCHExceptions;

public final class ExceptionHandler {
	
	private ExceptionHandler() {}
	
	public static <O> void checkDTONullParameter( O parameter )
	{
		if (parameter == null)
		{
			throw new DtoPCHExceptions("Provided parameter was null.", "Null parameter!", null);
		}
	}
}
