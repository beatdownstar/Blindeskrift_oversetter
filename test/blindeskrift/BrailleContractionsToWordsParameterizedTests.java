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
public class BrailleContractionsToWordsParameterizedTests {

	private String givenBrailleContraction;
	private String expectedWord;

	@Parameters
	public static List<Object[]> data() {

		return Arrays.asList(
				new Object[][] { 
					{String.valueOf((char)10243), "but"},		
					{String.valueOf((char)10249), "can"},
					{String.valueOf((char)10265), "do"},
					{String.valueOf((char)10257), "every"},
					{String.valueOf((char)10251), "from"},
					{String.valueOf((char)10267), "go"},
					{String.valueOf((char)10259), "have"},
					{String.valueOf((char)10266), "just"},
					{String.valueOf((char)10280), "knowledge"},
					{String.valueOf((char)10296), "like"},
					{String.valueOf((char)10253), "more"},
					{String.valueOf((char)10269), "not"},
					{String.valueOf((char)10255), "people"},
					{String.valueOf((char)10271), "quite"},
					{String.valueOf((char)10263), "rather"},
					{String.valueOf((char)10254), "so"},
					{String.valueOf((char)10270), "that"},
					{String.valueOf((char)10277), "us"},
					{String.valueOf((char)10279), "very"},
					{String.valueOf((char)10285), "it"},
					{String.valueOf((char)10301), "you"},
					{String.valueOf((char)10293), "as"},
					{String.valueOf((char)10287), "and"},
					{String.valueOf((char)10303), "for"},
					{String.valueOf((char)10295), "of"},
					{String.valueOf((char)10286), "the"},
					{String.valueOf((char)10302), "with"},
					{String.valueOf((char)10298), "will"},
					{String.valueOf((char)10278), "his"},
					{String.valueOf((char)10260), "in"},
					{String.valueOf((char)10292), "was"},
					{String.valueOf((char)10262), "to"}
				});
	}
	public BrailleContractionsToWordsParameterizedTests(String givenBrailleContraction, String expectedWord) {
			this.givenBrailleContraction = givenBrailleContraction;
			this.expectedWord = expectedWord;
		}
	@Test
	public void test() {
		assertThat(Oversetter.brailleContractionsToWords(givenBrailleContraction), is(equalTo(expectedWord)));
	}
}
