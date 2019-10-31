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
public class AlfaContractionsParameterizedTests {

	private String givenWord;
	private String expectedBrailleSymbol;

	@Parameters
	public static List<Object[]> data() {

		return Arrays.asList(
				new Object[][] { 
					{ "but", 		String.valueOf((char) 10243) }, 
					{ "can", 		String.valueOf((char) 10249) },
					{ "do", 		String.valueOf((char) 10265) }, 
					{ "every", 		String.valueOf((char) 10257) },
					{ "from", 		String.valueOf((char) 10251) }, 
					{ "go", 		String.valueOf((char) 10267) },
					{ "have", 		String.valueOf((char) 10259) }, 
					{ "just", 		String.valueOf((char) 10266) },
					{ "knowledge", 	String.valueOf((char) 10280) }, 
					{ "like", 		String.valueOf((char) 10296) },
					{ "more", 		String.valueOf((char) 10253) }, 
					{ "not", 		String.valueOf((char) 10269) },
					{ "people", 	String.valueOf((char) 10255) }, 
					{ "quite", 		String.valueOf((char) 10271) },
					{ "rather", 	String.valueOf((char) 10263) }, 
					{ "so", 		String.valueOf((char) 10254) },
					{ "that", 		String.valueOf((char) 10270) }, 
					{ "us", 		String.valueOf((char) 10277) },
					{ "very", 		String.valueOf((char) 10279) }, 
					{ "it", 		String.valueOf((char) 10285) },
					{ "you", 		String.valueOf((char) 10301) }, 
					{ "as", 		String.valueOf((char) 10293) },
					{ "and", 		String.valueOf((char) 10287) }, 
					{ "for", 		String.valueOf((char) 10303) },
					{ "of", 		String.valueOf((char) 10295) }, 
					{ "the", 		String.valueOf((char) 10286) },
					{ "with", 		String.valueOf((char) 10302) }, 
					{ "will", 		String.valueOf((char) 10298) },
					{ "his", 		String.valueOf((char) 10278) }, 
					{ "in", 		String.valueOf((char) 10260) },
					{ "was", 		String.valueOf((char) 10292) }, 
					{ "to", 		String.valueOf((char) 10262) }

				});
	}

	public AlfaContractionsParameterizedTests(String givenWord, String expectedBrailleSymbol) {
		this.givenWord = givenWord;
		this.expectedBrailleSymbol = expectedBrailleSymbol;
	}

	@Test
	public void test() {
		assertThat(Oversetter.contractionMatchAndLetters(givenWord), is(equalTo(expectedBrailleSymbol)));
	}
}
