package blindeskrift;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BrailleCharactersParameterizedTests {

	private String givenBrailleCharacter;
	private String expectedLetter;

	@Parameters
	public static List<Object[]> data() {

		return Arrays.asList(new Object[][] {

				{ String.valueOf((char) 10241), "a" }, { String.valueOf((char) 10243), "b" },
				{ String.valueOf((char) 10249), "c" }, { String.valueOf((char) 10265), "d" },
				{ String.valueOf((char) 10257), "e" }, { String.valueOf((char) 10251), "f" },
				{ String.valueOf((char) 10267), "g" }, { String.valueOf((char) 10259), "h" },
				{ String.valueOf((char) 10250), "i" }, { String.valueOf((char) 10266), "j" },
				{ String.valueOf((char) 10245), "k" }, { String.valueOf((char) 10247), "l" },
				{ String.valueOf((char) 10253), "m" }, { String.valueOf((char) 10269), "n" },
				{ String.valueOf((char) 10261), "o" }, { String.valueOf((char) 10255), "p" },
				{ String.valueOf((char) 10271), "q" }, { String.valueOf((char) 10263), "r" },
				{ String.valueOf((char) 10254), "s" }, { String.valueOf((char) 10270), "t" },
				{ String.valueOf((char) 10277), "u" }, { String.valueOf((char) 10279), "v" },
				{ String.valueOf((char) 10298), "w" }, { String.valueOf((char) 10285), "x" },
				{ String.valueOf((char) 10301), "y" }, { String.valueOf((char) 10293), "z" }, });
	}

	public BrailleCharactersParameterizedTests(String givenBrailleCharacter, String expectedLetter) {
		this.givenBrailleCharacter = givenBrailleCharacter;
		this.expectedLetter = expectedLetter;
	}

	@Test
	public void test() {
		assertThat(Oversetter.translateBrailleCharacters(givenBrailleCharacter), is(equalTo(expectedLetter)));
	}
}