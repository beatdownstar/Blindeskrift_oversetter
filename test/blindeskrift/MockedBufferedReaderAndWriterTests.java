
package blindeskrift;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class MockedBufferedReaderAndWriterTests {
	private ReadTranslateWrite translator;
	private BufferedWriter writer;
	private BufferedReader reader;

	@Before
	public void setUp() {
		writer = mock(BufferedWriter.class);
		reader = mock(BufferedReader.class);
		translator = new ReadTranslateWrite(reader, writer);
	}

	@Test
	public void ifReadLineHasMoreToRead_ItShouldReturnLine() throws IOException {
		when(reader.readLine()).thenReturn("ALICE'S ADVENTURES IN WONDERLAND");
		assertThat(translator.readLine(), is("ALICE'S ADVENTURES IN WONDERLAND"));
	}

	@Test
	public void ifReadLineReachedTheEndOfFile_ItShouldReturnNull() throws IOException {
		when(reader.readLine()).thenReturn(null);
		assertNull(translator.readLine());
	}

	@Test
	public void translateTheFile_TextInput_ShouldTranslateAndWriteToFile() throws IOException {
		when(reader.readLine()).thenReturn("Down, down, down.", "Would the fall NEVER come to an end!", null);

		translator.translateTheFile();

		verify(writer).write("⠠⠙⠕⠺⠝⠂ ⠙⠕⠺⠝⠂ ⠙⠕⠺⠝⠲" + System.getProperty("line.separator"));
		verify(writer).write("⠠⠺⠕⠥⠇⠙ ⠮ ⠋⠁⠇⠇ ⠠⠝⠠⠑⠠⠧⠠⠑⠠⠗ ⠉⠕⠍⠑ ⠖ ⠁⠝ ⠑⠝⠙⠖" + System.getProperty("line.separator"));

		verify(writer).flush();
		verify(writer).close();
		verify(reader).close();
	}

	@Test
	public void translateTheFile_BrailleInput_ShouldTranslateAndWriteToFile() throws IOException {
		when(reader.readLine()).thenReturn("⠠⠉⠠⠓⠠⠁⠠⠏⠠⠞⠠⠑⠠⠗ ⠠⠊", "⠠⠙⠕⠺⠝ ⠮ ⠠⠗⠁⠃⠃⠊⠞⠤⠠⠓⠕⠇⠑", null);

		translator.translateTheFile();

		verify(writer).write("CHAPTER I " + System.getProperty("line.separator"));
		verify(writer).write("Down the Rabbit-Hole " + System.getProperty("line.separator"));

		verify(writer).flush();
		verify(writer).close();
		verify(reader).close();
	}

	@Test
	public void translateTheFile_OnlyWhiteSpaces_ShouldRemoveWhitespacesAndWriteNewLineToFile() throws IOException {
		when(reader.readLine()).thenReturn("\n \n     \n      ", "      \n", "       ", null);

		translator.translateTheFile();

		verify(writer, times(3)).write("" + System.getProperty("line.separator"));

		verify(writer).flush();
		verify(writer).close();
		verify(reader).close();
	}

	@Test
	public void translateTheFile_WhenEndOfFileIsReached_ShouldNotWriteAnything() throws IOException {
		when(reader.readLine()).thenReturn(null);

		translator.translateTheFile();

		verify(writer, never()).write(anyString());

		verify(writer).flush();
		verify(writer).close();
		verify(reader).close();
	}
}
