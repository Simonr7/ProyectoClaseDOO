package co.edu.uco.pch.crosscutting.exceptions;

import co.edu.uco.pch.crosscutting.exceptions.enums.Lugar;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;

public class PCHException extends RuntimeException {

	private static final long serialVersionUID = -1119971647684852037L;

	protected String _userMesaage;
	protected Lugar _exceptionLugar;
	protected String _techMessage;
	
	public PCHException(final String technicalMessage, final String userMessage, final Lugar exceptionLugar, final Throwable rootException)
	{
		super(technicalMessage, rootException);
		
		setUserMessage(userMessage);
		setExceptionLugar(exceptionLugar);
		setTechMessage(technicalMessage);
	}
	
	public PCHException(final String userMessage, final Lugar exceptionLugar)
	{
		super(userMessage, new Exception());
		
		setUserMessage(userMessage);
		setExceptionLugar(exceptionLugar);
	}
	
	public PCHException(final String technicalMessage, final String userMessage, final Lugar exceptionLugar)
	{
		super(technicalMessage, new Exception());
		
		setUserMessage(userMessage);
		setExceptionLugar(exceptionLugar);
		setTechMessage(technicalMessage);
	}

	public void setUserMessage(final String userMesaage) {
		this._userMesaage = TextHelper.applyTrim(userMesaage);
	}
	
	public void setTechMessage(final String techMessage)
	{
		this._techMessage = techMessage;
	}

	public void setExceptionLugar(final Lugar lugar) {
		this._exceptionLugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, Lugar.CONFIG);
	}

	public final String getUserMesaage() {
		return this._userMesaage;
	}

	public final Lugar getExceptionLugar() {
		return this._exceptionLugar;
	}
	
	public String getTehMessage()
	{
		return this._techMessage;
	}
	
}
