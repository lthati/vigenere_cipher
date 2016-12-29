import java.io.BufferedReader;

public class Decryption {

	public String decrypt(String keyword, String inputText)
	{
		 String decryptedString = "";
		 inputText = inputText.toUpperCase();
		 int size = inputText.length();
		 for(int i=0, j=0; i<size; i++)
		 {
			 char letter = inputText.charAt(i);
	         if (letter < 'A' || letter > 'Z') continue;
	         decryptedString += (char)((letter - keyword.charAt(j) + 26) % 26 + 'A');
	         j = ++j % keyword.length();
		 }
		 return decryptedString;
	}
	
}
