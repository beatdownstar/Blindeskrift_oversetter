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
	public class BrailleBigLetterIndicatorParameterizedTests {

		private String givenCharacterWithBigLetterIndicator;
		private String expectedBigLetter;

		@Parameters
		public static List<Object[]> data() {

			return Arrays.asList(new Object[][] {

				{ String.valueOf((char) 10272) + 'a' , "A"},			
				{ String.valueOf((char) 10272) + 'b' , "B"},
				{ String.valueOf((char) 10272) + 'c' , "C"},
				{ String.valueOf((char) 10272) + 'd' , "D"},
				{ String.valueOf((char) 10272) + 'e' , "E"},
				{ String.valueOf((char) 10272) + 'f' , "F"},
				{ String.valueOf((char) 10272) + 'g' , "G"},
				{ String.valueOf((char) 10272) + 'h' , "H"},
				{ String.valueOf((char) 10272) + 'i' , "I"},
				{ String.valueOf((char) 10272) + 'j' , "J"},
				{ String.valueOf((char) 10272) + 'k' , "K"},
				{ String.valueOf((char) 10272) + 'l' , "L"},
				{ String.valueOf((char) 10272) + 'm' , "M"},
				{ String.valueOf((char) 10272) + 'n' , "N"},
				{ String.valueOf((char) 10272) + 'o' , "O"},
				{ String.valueOf((char) 10272) + 'p' , "P"},
				{ String.valueOf((char) 10272) + 'q' , "Q"},
				{ String.valueOf((char) 10272) + 'r' , "R"},
				{ String.valueOf((char) 10272) + 's' , "S"},
				{ String.valueOf((char) 10272) + 't' , "T"},
				{ String.valueOf((char) 10272) + 'u' , "U"},
				{ String.valueOf((char) 10272) + 'v' , "V"},
				{ String.valueOf((char) 10272) + 'w' , "W"},
				{ String.valueOf((char) 10272) + 'x' , "X"},
				{ String.valueOf((char) 10272) + 'y' , "Y"},
				{ String.valueOf((char) 10272) + 'z' , "Z"}

	});
		}
		public  BrailleBigLetterIndicatorParameterizedTests(String givenCharacterWithBigLetterIndicator, String expectedBigLetter) {
					this.givenCharacterWithBigLetterIndicator = givenCharacterWithBigLetterIndicator;
					this.expectedBigLetter = expectedBigLetter;
		}
		@Test
		public void test() {
			assertThat(Oversetter.makeSmallLettersBig(givenCharacterWithBigLetterIndicator), is(equalTo(expectedBigLetter)));
		}
	}