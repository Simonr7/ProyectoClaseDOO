package co.edu.uco.pch.crosscutting.helpers;

import java.util.regex.Pattern;

public class TextHelper {

	public static final String EMPTY = "";
	public static final String UNDERSCORE = "_";
	
	private TextHelper()
	{
		super();
	}
	
	public static final boolean isNull( final String text)
	{
		return ObjectHelper.getObjectHelper().isNull(text);
	}
	
	/*
		public static final boolean isNullOrEmpty( final String text )
		{
			return isNull(text) || EMPTY.equals(applyTrim(text));
		}
	*/
	
	public static final String getDefault( final String text, final String defaultValue )
	{
		return ObjectHelper.getObjectHelper().getDefaultValue(text, defaultValue);
	}
	
	public static final String getDefault( final String text )
	{
		return getDefault( text, EMPTY );
	}
	
	public static final String applyTrim( final String text ) {
		return getDefault(text).trim();
	}
	
	public static final String concatenate(String... strings) 
	{
		final var sb = new StringBuilder(EMPTY);
		
		if (!ObjectHelper.getObjectHelper().isNull(strings))
		{
			for (final var str : strings)
			{
				sb.append(applyTrim(str));
			}
		}
		
		return sb.toString();
	}
	
	public static final String replaceParams(final String original, final String... params)
	{
		String newString = original;
		
		for (int i=0; i < params.length; i++)
		{
			final String currentParameter = params[i];
			
			newString = newString.replace("{"+i+"}", currentParameter);
		}
		
		return applyTrim(newString);
	}
	
	public static final long messageParameters(final String original)
	{
		Pattern pattern = Pattern.compile("\\{\\d\\}");
		return pattern.matcher(original).results().count();
	}
}
