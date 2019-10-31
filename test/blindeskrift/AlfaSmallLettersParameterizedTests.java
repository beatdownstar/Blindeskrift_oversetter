
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
public class AlfaSmallLettersParameterizedTests {

	private String givenLetter;
	private String expectedBrailleSymbol;

	@Parameters
	public static List<Object[]> data() {

		return Arrays.asList(new Object[][] {

				{ "a", String.valueOf((char) 10241) }, { "b", String.valueOf((char) 10243) },
				{ "c", String.valueOf((char) 10249) }, { "d", String.valueOf((char) 10265) },
				{ "e", String.valueOf((char) 10257) }, { "f", String.valueOf((char) 10251) },
				{ "g", String.valueOf((char) 10267) }, { "h", String.valueOf((char) 10259) },
				{ "i", String.valueOf((char) 10250) }, { "j", String.valueOf((char) 10266) },
				{ "k", String.valueOf((char) 10245) }, { "l", String.valueOf((char) 10247) },
				{ "m", String.valueOf((char) 10253) }, { "n", String.valueOf((char) 10269) },
				{ "o", String.valueOf((char) 10261) }, { "p", String.valueOf((char) 10255) },
				{ "q", String.valueOf((char) 10271) }, { "r", String.valueOf((char) 10263) },
				{ "s", String.valueOf((char) 10254) }, { "t", String.valueOf((char) 10270) },
				{ "u", String.valueOf((char) 10277) }, { "v", String.valueOf((char) 10279) },
				{ "w", String.valueOf((char) 10298) }, { "x", String.valueOf((char) 10285) },
				{ "y", String.valueOf((char) 10301) }, { "z", String.valueOf((char) 10293) }

		});
	}

	public AlfaSmallLettersParameterizedTests(String givenLetter, String expectedBrailleSymbol) {
		this.givenLetter = givenLetter;
		this.expectedBrailleSymbol = expectedBrailleSymbol;
	}

	@Test
	public void test() {
		assertThat(Oversetter.contractionMatchAndLetters(givenLetter), is(equalTo(expectedBrailleSymbol)));
	}

}
