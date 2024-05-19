package co.edu.uco.pch.crosscutting.helpers;

import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;

public final class ObjectHelper {
	
	private static final ObjectHelper INSTANCE = new ObjectHelper();

	private ObjectHelper()
	{
		super();
	}
	
	public static final ObjectHelper getObjectHelper()
	{
		return INSTANCE;
	}
	
	public <Any> boolean isNull(Any object)
	{
		return object == null;
	}
	
	public <Any> Any getDefaultValue(Any object, Any defaultValue)
	{
		return this.isNull(object) ? defaultValue : object;
	}
}
