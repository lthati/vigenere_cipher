import java.io.BufferedReader;

public class Encryption {

	public String encrypt(String keyword, String inputText)
	{
		 String encryptedString = "";
		 inputText = inputText.toUpperCase();
		 int size = inputText.length();
		 for(int i=0, j=0; i<size; i++)
		 {
			 char letter = inputText.charAt(i);
	         if (letter < 'A' || letter > 'Z') continue;
	         encryptedString += (char)((letter + keyword.charAt(j) - 2 * 'A') % 26 + 'A');
	         j = ++j % keyword.length();
		 }
         return encryptedString;
	}
	
}
