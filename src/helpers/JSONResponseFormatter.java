package helpers;

public class JSONResponseFormatter {
	
	public static String addObject(String originalText, String objectName, String objectValue, Boolean comma)
	{
		if(comma)
			return originalText + "\"" + objectName + "\":\"" + objectValue +"\",";
		else
			return originalText + "\"" + objectName + "\":\"" + objectValue +"\"";
	}
}
