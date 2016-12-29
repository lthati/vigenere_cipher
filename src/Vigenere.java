import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Stack;

public class Vigenere {

	public static void main(String[] args) throws Exception{
		
		boolean isEncrypt;
		String keyword;
		String inputFileName;
		
		
		// Read the command line input
		try
		{
			String operation = args[0];
			if(!(operation.equals("-e")||operation.equals("-d")))
			{
				throw new IllegalArgumentException("Please choose Encryption (-e) or Decryption (-d) operation");
			}
			isEncrypt = operation.equals("-e") ? true : false;
			keyword = args[1].toUpperCase();
			inputFileName = args[2];
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		try
		{
			//Read the input file text
			BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName));
			Writer outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir")+"/output")));
			String inputText="", line;

			while ((line = inputFile.readLine()) != null)
			{
				inputText = inputText.concat(line);
			}
			
			String outputText = isEncrypt ? new Encryption().encrypt(keyword, inputText) : new Decryption().decrypt(keyword, inputText);
			outputWriter.write(outputText);
			
			
			if(isEncrypt)
				System.out.print("After Encryption ");
			else
				System.out.print("After Decryption ");
			Stack<Integer> s = new Stack<Integer>();
			Stack<Boolean> s1 = new Stack<>();
			System.out.println("the ouput text file is stored at: "+System.getProperty("user.dir")+"/output");
			
			
			inputFile.close();
			outputWriter.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return;
		}
	}

}
