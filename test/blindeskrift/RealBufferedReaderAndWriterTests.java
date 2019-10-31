package blindeskrift;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class RealBufferedReaderAndWriterTests {
		
	@Test
	public void FirstCallReadLine_ShouldReturnFirstLine() throws IOException {		
				
		BufferedReader reader = new BufferedReader(new FileReader("AliceIW_OriginalFile.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("AliceIW_OriginalFileToBraille.txt"));		
		ReadTranslateWrite translator = new ReadTranslateWrite(reader, writer);
		
		assertThat(reader.readLine(), is("                ALICE'S ADVENTURES IN WONDERLAND"));
		
		translator.translateTheFile();
		reader.close();
		writer.close();
	}	
	@Test
	public void translateTheHoleTextToBraille_AndBack_Returns_TextWithAllTheInitialWords() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("AliceIW_OriginalFile.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("AliceIW_OriginalFileToBraille.txt"));		
		ReadTranslateWrite translator = new ReadTranslateWrite(reader, writer);		
		translator.translateTheFile();
						
		BufferedReader newReader = new BufferedReader(new FileReader("AliceIW_OriginalFileToBraille.txt"));
		BufferedWriter newWriter = new BufferedWriter(new FileWriter("AliceIW_OriginalFileToBrailleToText.txt"));
		ReadTranslateWrite newTranslator =  new ReadTranslateWrite(newReader, newWriter);		
		newTranslator.translateTheFile();
						
		BufferedReader originalFileReader = new BufferedReader(new FileReader("AliceIW_OriginalFile.txt"));
		BufferedReader translatedFileReader = new BufferedReader(new FileReader("AliceIW_OriginalFileToBrailleToText.txt"));
				
		while(originalFileReader.readLine() != null && translatedFileReader.readLine() != null) {
			assertThat(Oversetter.getWordsFromText(translatedFileReader.readLine()),is(Oversetter.getWordsFromText(originalFileReader.readLine())));
		}		
		
		originalFileReader.close();
		translatedFileReader.close();
	}	
}
