
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
public class AlfaPunctuationsParameterizedTests {

	private String givenPunctuation;
	private String expectedBrailleSymbol;

	@Parameters
	public static List<Object[]> data() {

		return Arrays.asList(new Object[][] {

				{ ",",  String.valueOf((char) 10242) }, 
				{ ";",  String.valueOf((char) 10246) },
				{ ":",  String.valueOf((char) 10258) }, 
				{ ".",  String.valueOf((char) 10290) },
				{ "!",  String.valueOf((char) 10262) }, 
				{ "(",  String.valueOf((char) 10294) },
				{ ")",  String.valueOf((char) 10294) }, 
				{ "?",  String.valueOf((char) 10278) },
				{ "/",  String.valueOf((char) 10252) }, 
				{ "#",  String.valueOf((char) 10300) },
				{ "\\", String.valueOf((char) 10273) }, 
				{ "’",  String.valueOf((char) 10244) },
				{ "-",  String.valueOf((char) 10276) }, 
				{ "-",  String.valueOf((char) 10276) },
				{ "_",  String.valueOf((char) 10296) }

		});
	}

	public AlfaPunctuationsParameterizedTests(String givenPunctuation, String expectedBrailleSymbol) {
			this.givenPunctuation = givenPunctuation;
			this.expectedBrailleSymbol = expectedBrailleSymbol;
		}

	@Test
	public void test() {
		assertThat(Oversetter.translatePunctuation(givenPunctuation), is(equalTo(expectedBrailleSymbol)));
	}
}