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
public class BrailleCharactersAreNotDigitsParameterizedTests {

	private String givenBrailleCharacter;
	private String expectedBrailleCharacter;

	@Parameters
	public static List<Object[]> data() {

		return Arrays.asList(new Object[][] {

				{ String.valueOf((char) 10241), String.valueOf((char) 10241) },
				{ String.valueOf((char) 10243), String.valueOf((char) 10243) },
				{ String.valueOf((char) 10249), String.valueOf((char) 10249) },
				{ String.valueOf((char) 10265), String.valueOf((char) 10265) },
				{ String.valueOf((char) 10257), String.valueOf((char) 10257) },
				{ String.valueOf((char) 10251), String.valueOf((char) 10251) },
				{ String.valueOf((char) 10267), String.valueOf((char) 10267) },
				{ String.valueOf((char) 10259), String.valueOf((char) 10259) },
				{ String.valueOf((char) 10250), String.valueOf((char) 10250) },
				{ String.valueOf((char) 10266), String.valueOf((char) 10266) } });
	}

	public BrailleCharactersAreNotDigitsParameterizedTests(String givenBrailleCharacter,
			String expectedBrailleCharacter) {
		this.givenBrailleCharacter = givenBrailleCharacter;
		this.expectedBrailleCharacter = expectedBrailleCharacter;
	}

	@Test
	public void test() {
		assertThat(Oversetter.translateBrailleNumbers(givenBrailleCharacter), is(equalTo(expectedBrailleCharacter)));
	}
}