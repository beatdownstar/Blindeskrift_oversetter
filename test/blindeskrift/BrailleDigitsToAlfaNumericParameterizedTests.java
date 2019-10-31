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
public class BrailleDigitsToAlfaNumericParameterizedTests {

	private String givenBrailleDigit;
	private String expectedAlfanumericSymbol;

	@Parameters
	public static List<Object[]> data() {

		return Arrays.asList(new Object[][] {

				{ String.valueOf((char) 10300) + (char) 10241, "1" },
				{ String.valueOf((char) 10300) + (char) 10243, "2" },
				{ String.valueOf((char) 10300) + (char) 10249, "3" },
				{ String.valueOf((char) 10300) + (char) 10265, "4" },
				{ String.valueOf((char) 10300) + (char) 10257, "5" },
				{ String.valueOf((char) 10300) + (char) 10251, "6" },
				{ String.valueOf((char) 10300) + (char) 10267, "7" },
				{ String.valueOf((char) 10300) + (char) 10259, "8" },
				{ String.valueOf((char) 10300) + (char) 10250, "9" },
				{ String.valueOf((char) 10300) + (char) 10266, "0" } });
	}

	public BrailleDigitsToAlfaNumericParameterizedTests(String givenBrailleDigit, String expectedAlfanumericSymbol) {
		this.givenBrailleDigit = givenBrailleDigit;
		this.expectedAlfanumericSymbol = expectedAlfanumericSymbol;
	}

	@Test
	public void test() {
		assertThat(Oversetter.translateBrailleNumbers(givenBrailleDigit), is(equalTo(expectedAlfanumericSymbol)));
	}
}