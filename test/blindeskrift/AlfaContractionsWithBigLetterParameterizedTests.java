
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
public class AlfaContractionsWithBigLetterParameterizedTests {

	private String givenWord;
	private String expectedBrailleSymbol;

	@Parameters
	public static List<Object[]> data() {

		return Arrays.asList(new Object[][] {
				{ String.valueOf((char) 10272) + "but", String.valueOf((char) 10272) + ((char) 10243) },
				{ String.valueOf((char) 10272) + "can", String.valueOf((char) 10272) + ((char) 10249) },
				{ String.valueOf((char) 10272) + "do", String.valueOf((char) 10272) + ((char) 10265) },
				{ String.valueOf((char) 10272) + "every", String.valueOf((char) 10272) + ((char) 10257) },
				{ String.valueOf((char) 10272) + "from", String.valueOf((char) 10272) + ((char) 10251) },
				{ String.valueOf((char) 10272) + "go", String.valueOf((char) 10272) + ((char) 10267) },
				{ String.valueOf((char) 10272) + "have", String.valueOf((char) 10272) + ((char) 10259) },
				{ String.valueOf((char) 10272) + "just", String.valueOf((char) 10272) + ((char) 10266) },
				{ String.valueOf((char) 10272) + "knowledge", String.valueOf((char) 10272) + ((char) 10280) },
				{ String.valueOf((char) 10272) + "like", String.valueOf((char) 10272) + ((char) 10296) },
				{ String.valueOf((char) 10272) + "more", String.valueOf((char) 10272) + ((char) 10253) },
				{ String.valueOf((char) 10272) + "not", String.valueOf((char) 10272) + ((char) 10269) },
				{ String.valueOf((char) 10272) + "people", String.valueOf((char) 10272) + ((char) 10255) },
				{ String.valueOf((char) 10272) + "quite", String.valueOf((char) 10272) + ((char) 10271) },
				{ String.valueOf((char) 10272) + "rather", String.valueOf((char) 10272) + ((char) 10263) },
				{ String.valueOf((char) 10272) + "so", String.valueOf((char) 10272) + ((char) 10254) },
				{ String.valueOf((char) 10272) + "that", String.valueOf((char) 10272) + ((char) 10270) },
				{ String.valueOf((char) 10272) + "us", String.valueOf((char) 10272) + ((char) 10277) },
				{ String.valueOf((char) 10272) + "very", String.valueOf((char) 10272) + ((char) 10279) },
				{ String.valueOf((char) 10272) + "it", String.valueOf((char) 10272) + ((char) 10285) },
				{ String.valueOf((char) 10272) + "you", String.valueOf((char) 10272) + ((char) 10301) },
				{ String.valueOf((char) 10272) + "as", String.valueOf((char) 10272) + ((char) 10293) },
				{ String.valueOf((char) 10272) + "and", String.valueOf((char) 10272) + ((char) 10287) },
				{ String.valueOf((char) 10272) + "for", String.valueOf((char) 10272) + ((char) 10303) },
				{ String.valueOf((char) 10272) + "of", String.valueOf((char) 10272) + ((char) 10295) },
				{ String.valueOf((char) 10272) + "the", String.valueOf((char) 10272) + ((char) 10286) },
				{ String.valueOf((char) 10272) + "with", String.valueOf((char) 10272) + ((char) 10302) },
				{ String.valueOf((char) 10272) + "will", String.valueOf((char) 10272) + ((char) 10298) },
				{ String.valueOf((char) 10272) + "his", String.valueOf((char) 10272) + ((char) 10278) },
				{ String.valueOf((char) 10272) + "in", String.valueOf((char) 10272) + ((char) 10260) },
				{ String.valueOf((char) 10272) + "was", String.valueOf((char) 10272) + ((char) 10292) },
				{ String.valueOf((char) 10272) + "to", String.valueOf((char) 10272) + ((char) 10262) }

		});
	}

	public AlfaContractionsWithBigLetterParameterizedTests(String givenWord, String expectedBrailleSymbol) {
		this.givenWord = givenWord;
		this.expectedBrailleSymbol = expectedBrailleSymbol;
	}

	@Test
	public void test() {
		assertThat(Oversetter.contractionMatchAndLetters(givenWord), is(equalTo(expectedBrailleSymbol)));
	}
}