package blindeskrift;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class ReadTranslateWrite {
	private BufferedReader reader;
	private BufferedWriter writer;
	private String givenLine;
	private String translatedLine;

	ReadTranslateWrite(BufferedReader reader, BufferedWriter writer) {
		this.writer = writer;
		this.reader = reader;
	}
	String readLine() throws IOException {
		givenLine = reader.readLine();
		return givenLine;
	}
	void translateLine() {
		if (Charset.forName("US-ASCII").newEncoder().canEncode(givenLine)) {
			translatedLine = (Oversetter.textToBraille(givenLine));
		} else {
			translatedLine = (Oversetter.brailleToText(givenLine));
		}
	}
	void writeLine() throws IOException {
		writer.write(translatedLine + System.getProperty("line.separator"));
	}	
	void translateTheFile() throws IOException {
		while (readLine() != null) {
			translateLine();
			writeLine();
		}
		closeWriter();
		closeReader();
	}
	void closeReader() throws IOException {
		reader.close();
	}
	void closeWriter() throws IOException {
		writer.flush();
		writer.close();
	}
}
