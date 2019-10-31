package blindeskrift;

import static org.junit.Assert.*;


import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OversetterTest {

	@Before
	public void setUp() {
	}
	@After
	public void tearDown() {
	}
	@Test
	public void emptyTextReturnsEmptyText() {
		assertThat(Oversetter.getWordsFromText(""),is(equalTo(new String[] {})));
	}
	@Test
	public void textWithOnlyWhiteSpacesReturnsEmptyText() {
		assertThat(Oversetter.getWordsFromText(" \n   \n\n    \n\n\n  \n    \n"),is(equalTo(new String[] {})));
	}
	@Test
	public void oneWordReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("hi"),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithOneSpaceBeforeReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText(" hi"),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithOneSpaceAfterReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("hi "),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithOneSpaceBeforeAndAfterReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText(" hi "),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithMultipleSpacesBeforeReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("           hi"),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithMultipleSpacesAfterReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("hi          "),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithMultipleSpacesBeforeAndAfterReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("          hi          "),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithOneNewLineBeforeReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("\nhi"),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithOneNewLineAfterReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("hi\n"),is(equalTo(new String[] {"hi"})));
	}	
	@Test
	public void oneWordWithOneNewLineBeforeAndAfterReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("\nhi\n"),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithMultipleNewLineBeforeReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("\n\n\n\nhi"),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithMultipleNewLineAfterReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("hi\n\n\n\n"),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithMultipleNewLineBeforeAndAfterReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText("\n\n\nhi\n\n\n"),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void oneWordWithMultipleWhiteSpacesBeforeAndAfterReturnsTheSameWord() {
		assertThat(Oversetter.getWordsFromText(" \n \n\n     \n hi\n  \n \n   \n \n"),is(equalTo(new String[] {"hi"})));
	}
	@Test
	public void severalWordsWithOneSpaceBetweenThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText("1 2 3"),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithOneSpaceBetweenBeforeAndAfterThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText(" 1 2 3 "),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithMultipleSpacesBetweenThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText("1  2    3"),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithMultipleSpacesBetweenBeforeAndAfterThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText("      1   2    3    "),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithOneNewLineBetweenThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText("1\n2\n3"),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithOneNewLineBetweenBeforeAndAfterThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText("\n1\n2\n3\n"),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithMultipleNewLineBetweenThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText("1\n\n\n2\n\n3"),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithMultipleNewLineBetweenBeforeAndAfterThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText("\n\n1\n\n\n2\n\n3\n\n\n\n"),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithWhitespacesBetweenThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText("1\n2 3"),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithMultipleWhitespacesBetweenThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText("1\n    \n \n2 \n \n\n \n 3"),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void severalWordsWithMultipleWhitespacesBetweenBeforeAndAfterThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText(" \n\n \n      1\n    \n \n2 \n \n\n \n 3  \n  \n\n\n  \n"),is(equalTo(new String[] {"1","2","3"})));
	}
	@Test
	public void processDigitsForNumberOneWorksFine() {
		assertThat(Oversetter.processDigits("1"),is(equalTo(String.valueOf((char)10300)+(char)10241)));
	}
	@Test
	public void processDigitsForNumberTwoWorksFine() {
		assertThat(Oversetter.processDigits("2"),is(equalTo(String.valueOf((char)10300)+(char)10243)));
	}	
	@Test
	public void processDigitsForNumberThreeWorksFine() {
		assertThat(Oversetter.processDigits("3"),is(equalTo(String.valueOf((char)10300)+(char)10249)));
	}	
	@Test
	public void processDigitsForNumberFourWorksFine() {
		assertThat(Oversetter.processDigits("4"),is(equalTo(String.valueOf((char)10300)+(char)10265)));
	}	
	@Test
	public void processDigitsForNumberFiveWorksFine() {
		assertThat(Oversetter.processDigits("5"),is(equalTo(String.valueOf((char)10300)+(char)10257)));
	}	
	@Test
	public void processDigitsForNumberSixWorksFine() {
		assertThat(Oversetter.processDigits("6"),is(equalTo(String.valueOf((char)10300)+(char)10251)));
	}	
	@Test
	public void processDigitsForNumberSevenWorksFine() {
		assertThat(Oversetter.processDigits("7"),is(equalTo(String.valueOf((char)10300)+(char)10267)));
	}	
	@Test
	public void processDigitsForNumberEightWorksFine() {
		assertThat(Oversetter.processDigits("8"),is(equalTo(String.valueOf((char)10300)+(char)10259)));
	}
	@Test
	public void processDigitsForNumberNineWorksFine() {
		assertThat(Oversetter.processDigits("9"),is(equalTo(String.valueOf((char)10300)+(char)10250)));
	}
	@Test
	public void processDigitsForNumberZeroWorksFine() {
		assertThat(Oversetter.processDigits("0"),is(equalTo(String.valueOf((char)10300)+(char)10266)));
	}
	@Test
	public void processDigitsForNumberWithManyDigitsWorksFine() {
		assertThat(Oversetter.processDigits("0987654321"),is(equalTo(
				String.valueOf((char)10300)+
				
				(char)10266+
				(char)10250+
				(char)10259+
				(char)10267+
				(char)10251+
				(char)10257+
				(char)10265+
				(char)10249+
				(char)10243+
				(char)10241				
				)));
	}
	@Test
	public void processDigitsForDigitsAndPunctuationsWorksFine() {
		assertThat(Oversetter.processDigits(",0;9:8.7!6(5)4?3/2#1\\’--_"),is(equalTo(
				"," +
				(char)10300 + (char)10266 +';'+
				(char)10300 + (char)10250 +':'+
				(char)10300 + (char)10259 +'.'+
				(char)10300 + (char)10267 +'!'+
				(char)10300 + (char)10251 +'('+
				(char)10300 + (char)10257 +')'+
				(char)10300 + (char)10265 +'?'+
				(char)10300 + (char)10249 +'/'+
				(char)10300 + (char)10243 +'#'+
				(char)10300 + (char)10241 +'\\'+ '’' + '-' + '-'+'_'			
				)));
	}
	@Test
	public void processDigitsForDigitsAndMultiplePunctuationsWorksFine() {
		assertThat(Oversetter.processDigits(",_0;-9:’8.#7!\\6(/5?)4?:3/’2,#1\\’--_"),is(equalTo(
				",_" +
				(char)10300 + (char)10266 +";-" +
				(char)10300 + (char)10250 +":’" +
				(char)10300 + (char)10259 +".#" +
				(char)10300 + (char)10267 +"!\\"+
				(char)10300 + (char)10251 +"(/"+
				(char)10300 + (char)10257 +"?)"+
				(char)10300 + (char)10265 +"?:"+
				(char)10300 + (char)10249 +"/’"+
				(char)10300 + (char)10243 +",#"+
				(char)10300 + (char)10241 +"\\’--_"			
				)));
	}
	@Test
	public void processDigitsForDigitsAndLettersWorksFine() {
		assertThat(Oversetter.processDigits("a0b9c8d7e6f5g4h3i2j1k"),is(equalTo(
				"a" +
				(char)10300 + (char)10266 +'b'+
				(char)10300 + (char)10250 +'c'+
				(char)10300 + (char)10259 +'d'+
				(char)10300 + (char)10267 +'e'+
				(char)10300 + (char)10251 +'f'+
				(char)10300 + (char)10257 +'g'+
				(char)10300 + (char)10265 +'h'+
				(char)10300 + (char)10249 +'i'+
				(char)10300 + (char)10243 +'j'+
				(char)10300 + (char)10241 +'k'			
				)));
	}
	@Test
	public void processDigitsForDigitsAndMultipleLettersWorksFine() {
		assertThat(Oversetter.processDigits("ab0bc9cd8de7ef6fg5gh4hi3ij2jk1kl"),is(equalTo(
				"ab" +
				(char)10300 + (char)10266 +"bc"+
				(char)10300 + (char)10250 +"cd"+
				(char)10300 + (char)10259 +"de"+
				(char)10300 + (char)10267 +"ef"+
				(char)10300 + (char)10251 +"fg"+
				(char)10300 + (char)10257 +"gh"+
				(char)10300 + (char)10265 +"hi"+
				(char)10300 + (char)10249 +"ij"+
				(char)10300 + (char)10243 +"jk"+
				(char)10300 + (char)10241 +"kl"			
				)));
	}
	@Test
	public void processDigitsForDigitsLettersAndPunctuationsWorksFine() {
		assertThat(Oversetter.processDigits("-0,9c8;7!6f5g4h3-2j1k’-_"),is(equalTo(
				"-" +
				(char)10300 + (char)10266 +','+
				(char)10300 + (char)10250 +'c'+
				(char)10300 + (char)10259 +';'+
				(char)10300 + (char)10267 +'!'+
				(char)10300 + (char)10251 +'f'+
				(char)10300 + (char)10257 +'g'+
				(char)10300 + (char)10265 +'h'+
				(char)10300 + (char)10249 +'-'+
				(char)10300 + (char)10243 +'j'+
				(char)10300 + (char)10241 +'k'+ '’' + '-'+'_'			
				)));
	}
	@Test
	public void processDigitsForDigitsAndMultipleLettersAndPunctuationsWorksFine() {
		assertThat(Oversetter.processDigits("-a0,b9c_8d;7!e6.f5g\\4/h3x-2j;1k’--_"),is(equalTo(
				"-a" +
				(char)10300 + (char)10266 +",b"+
				(char)10300 + (char)10250 +"c_"+
				(char)10300 + (char)10259 +"d;"+
				(char)10300 + (char)10267 +"!e"+
				(char)10300 + (char)10251 +".f"+
				(char)10300 + (char)10257 +"g\\"+
				(char)10300 + (char)10265 +"/h"+
				(char)10300 + (char)10249 +"x-"+
				(char)10300 + (char)10243 +"j;"+
				(char)10300 + (char)10241 +'k'+ '’' + '-' + '-'+'_'			
				)));
	}
	@Test
	public void processDigitsForNumbersWithMinimumTwoDigitsAndLetterWorksFine() {
		assertThat(Oversetter.processDigits("a09d87y654h321k"),is(equalTo(
				"a"+
				(char)10300 + (char)10266 + (char)10250 +'d'+
				(char)10300 + (char)10259 + (char)10267 +"y"+
				(char)10300 + (char)10251 + (char)10257 + (char)10265 +'h'+
				(char)10300 + (char)10249 + (char)10243 + (char)10241 +'k'			
				)));
	}
	@Test
	public void processDigitsForNumbersWithMinimumTwoDigitsAndMultipleLettersWorksFine() {
		assertThat(Oversetter.processDigits("ba09cd87vy654nh321kq"),is(equalTo(
				"ba"+
				(char)10300 + (char)10266 + (char)10250 +"cd"+
				(char)10300 + (char)10259 + (char)10267 +"vy"+
				(char)10300 + (char)10251 + (char)10257 + (char)10265 +"nh"+
				(char)10300 + (char)10249 + (char)10243 + (char)10241 +"kq"			
				)));
	}
	@Test
	public void processDigitsForNumbersWithMinimumTwoDigitsAndPunctuationWorksFine() {
		assertThat(Oversetter.processDigits("_09-87’654#321."),is(equalTo(
				"_"+
				(char)10300 + (char)10266 + (char)10250 +'-'+
				(char)10300 + (char)10259 + (char)10267 +'’'+
				(char)10300 + (char)10251 + (char)10257 + (char)10265 +'#'+
				(char)10300 + (char)10249 + (char)10243 + (char)10241 +'.'			
				)));
	}
	@Test
	public void processDigitsForNumbersWithMinimumTwoDigitsAndMultiplePunctuationWorksFine() {
		assertThat(Oversetter.processDigits("09,-87;’654_#321..."),is(equalTo(
				
				String.valueOf((char)10300) + (char)10266 + (char)10250 +",-"+
				(char)10300 + (char)10259 + (char)10267 +";’"+
				(char)10300 + (char)10251 + (char)10257 + (char)10265 +"_#"+
				(char)10300 + (char)10249 + (char)10243 + (char)10241 +"..."			
				)));
	}
	@Test
	public void processDigitsForNumbersAndMultipleLettersAndPunctuationsWorksFine() {
		assertThat(Oversetter.processDigits(",09a:c876(5)43/2#1--_"),is(equalTo(
				 ","+				
				(char)10300 + (char)10266 + (char)10250 +"a:c"+
				(char)10300 + (char)10259 +	(char)10267 + (char)10251 +'('+
				(char)10300 + (char)10257 +')'+
				(char)10300 + (char)10265 + (char)10249 +'/'+
				(char)10300 + (char)10243 +'#'+
				(char)10300 + (char)10241 + '-' + '-'+'_'			
				)));
	}
	@Test
	public void makeBigLettersSmallForAllBigLettersWorksFine() {
		assertThat(Oversetter.makeBigLettersSmall("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),is(equalTo(
				String.valueOf((char) 10272) + 'a'+
				String.valueOf((char) 10272) + 'b'+
				String.valueOf((char) 10272) + 'c'+
				String.valueOf((char) 10272) + 'd'+
				String.valueOf((char) 10272) + 'e'+
				String.valueOf((char) 10272) + 'f'+
				String.valueOf((char) 10272) + 'g'+
				String.valueOf((char) 10272) + 'h'+
				String.valueOf((char) 10272) + 'i'+
				String.valueOf((char) 10272) + 'j'+
				String.valueOf((char) 10272) + 'k'+
				String.valueOf((char) 10272) + 'l'+
				String.valueOf((char) 10272) + 'm'+
				String.valueOf((char) 10272) + 'n'+
				String.valueOf((char) 10272) + 'o'+
				String.valueOf((char) 10272) + 'p'+
				String.valueOf((char) 10272) + 'q'+
				String.valueOf((char) 10272) + 'r'+
				String.valueOf((char) 10272) + 's'+
				String.valueOf((char) 10272) + 't'+
				String.valueOf((char) 10272) + 'u'+
				String.valueOf((char) 10272) + 'v'+
				String.valueOf((char) 10272) + 'w'+
				String.valueOf((char) 10272) + 'x'+
				String.valueOf((char) 10272) + 'y'+
				String.valueOf((char) 10272) + 'z'				
				)));
	}
	@Test
	public void makeBigLettersSmallForSmallLetterFollowedByBigLetterWorksFine() {
		assertThat(Oversetter.makeBigLettersSmall("aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ"),is(equalTo(
				
				"a"+String.valueOf((char) 10272) + 'a'+
				'b'+String.valueOf((char) 10272) + 'b'+
				'c'+String.valueOf((char) 10272) + 'c'+
				'd'+String.valueOf((char) 10272) + 'd'+
				'e'+String.valueOf((char) 10272) + 'e'+
				'f'+String.valueOf((char) 10272) + 'f'+
				'g'+String.valueOf((char) 10272) + 'g'+
				'h'+String.valueOf((char) 10272) + 'h'+
				'i'+String.valueOf((char) 10272) + 'i'+
				'j'+String.valueOf((char) 10272) + 'j'+
				'k'+String.valueOf((char) 10272) + 'k'+
				'l'+String.valueOf((char) 10272) + 'l'+
				'm'+String.valueOf((char) 10272) + 'm'+
				'n'+String.valueOf((char) 10272) + 'n'+
				'o'+String.valueOf((char) 10272) + 'o'+
				'p'+String.valueOf((char) 10272) + 'p'+
				'q'+String.valueOf((char) 10272) + 'q'+
				'r'+String.valueOf((char) 10272) + 'r'+
				's'+String.valueOf((char) 10272) + 's'+
				't'+String.valueOf((char) 10272) + 't'+
				'u'+String.valueOf((char) 10272) + 'u'+
				'v'+String.valueOf((char) 10272) + 'v'+
				'w'+String.valueOf((char) 10272) + 'w'+
				'x'+String.valueOf((char) 10272) + 'x'+
				'y'+String.valueOf((char) 10272) + 'y'+
				'z'+String.valueOf((char) 10272) + 'z'				
				)));	
	}
	@Test
	public void makeBigLettersSmallForDigitFollowedBySmallAndBigLetterWorksFine() {
		assertThat(Oversetter.makeBigLettersSmall("1aA2bB3cC4dD5eE6fF7gG8hH9iI0jJ"),is(equalTo(
				"1a"+String.valueOf((char) 10272) + 'a'+
				"2b"+String.valueOf((char) 10272) + 'b'+
				"3c"+String.valueOf((char) 10272) + 'c'+
				"4d"+String.valueOf((char) 10272) + 'd'+
				"5e"+String.valueOf((char) 10272) + 'e'+
				"6f"+String.valueOf((char) 10272) + 'f'+
				"7g"+String.valueOf((char) 10272) + 'g'+
				"8h"+String.valueOf((char) 10272) + 'h'+
				"9i"+String.valueOf((char) 10272) + 'i'+
				"0j"+String.valueOf((char) 10272) + 'j'								
				)));	
	}
	@Test
	public void makeBigLettersSmallForBigLetterFollowedBySmallLetterAndDigitWorksFine() {
		assertThat(Oversetter.makeBigLettersSmall("Aa1Bb2Cc3Dd4Ee5Ff6Gg7Hh8Ii9Jj0"),is(equalTo(
				String.valueOf((char) 10272) + "aa1"+
				String.valueOf((char) 10272) + "bb2"+
				String.valueOf((char) 10272) + "cc3"+
				String.valueOf((char) 10272) + "dd4"+
				String.valueOf((char) 10272) + "ee5"+
				String.valueOf((char) 10272) + "ff6"+
				String.valueOf((char) 10272) + "gg7"+
				String.valueOf((char) 10272) + "hh8"+
				String.valueOf((char) 10272) + "ii9"+
				String.valueOf((char) 10272) + "jj0"									
				)));	
	}
	@Test
	public void makeBigLettersSmallForPunctuationFollowedByBigAndSmallLetterAndDigitWorksFine() {
		assertThat(Oversetter.makeBigLettersSmall(",Aa1;Bb2:Cc3.Dd4!Ee5(Ff6)Gg7?Hh8/Ii9#Jj0"),is(equalTo(
				","+String.valueOf((char) 10272) + "aa1"+
				";"+String.valueOf((char) 10272) + "bb2"+
				":"+String.valueOf((char) 10272) + "cc3"+
				"."+String.valueOf((char) 10272) + "dd4"+
				"!"+String.valueOf((char) 10272) + "ee5"+
				"("+String.valueOf((char) 10272) + "ff6"+
				")"+String.valueOf((char) 10272) + "gg7"+
				"?"+String.valueOf((char) 10272) + "hh8"+
				"/"+String.valueOf((char) 10272) + "ii9"+
				"#"+String.valueOf((char) 10272) + "jj0"									
				)));	
	}
	@Test
	public void removePunctuationsForSimpleWordWorksFine() {
		assertThat(Oversetter.removePunctuations("junk"),is(equalTo("junk")));				
	}
	@Test
	public void removePunctuationsBeforeWordWorksFine() {
		assertThat(Oversetter.removePunctuations("?sweet"),is(equalTo("sweet")));				
	}
	@Test
	public void removePunctuationsAfterWordWorksFine() {
		assertThat(Oversetter.removePunctuations("the!..."),is(equalTo("the")));				
	}
	@Test
	public void removePunctuationsBeforeAndAfterWordWorksFine() {
		assertThat(Oversetter.removePunctuations("?end!..."),is(equalTo("end")));				
	}
	@Test
	public void removePunctuationsForBigLettersWorksFine() {
		assertThat(Oversetter.removePunctuations(
				String.valueOf((char) 10272)+'t'+
				String.valueOf((char) 10272)+'h'+
				String.valueOf((char) 10272)+'e'
				
				),is(equalTo( 
						String.valueOf((char) 10272)+'t'+
						String.valueOf((char) 10272)+'h'+
						String.valueOf((char) 10272)+'e'
						)));				
	}
	@Test
	public void removePunctuationsBeforeAndAfterBigLettersWorksFine() {
		assertThat(Oversetter.removePunctuations(
				"!"+ 
				String.valueOf((char) 10272)+'t'+
				String.valueOf((char) 10272)+'h'+
				String.valueOf((char) 10272)+'e'+"."
				
				),is(equalTo(
						String.valueOf((char) 10272)+'t'+
						String.valueOf((char) 10272)+'h'+
						String.valueOf((char) 10272)+'e'							
						)));				
	}
	@Test
	public void contractionMatchForContractionsWithOnlyBigLettersDoesNotContract() {
		assertThat(Oversetter.contractionMatchAndLetters(
				String.valueOf((char) 10272)+'t'+
				String.valueOf((char) 10272)+'h'+
				String.valueOf((char) 10272)+'e')
				
				, is(equalTo(
				
				String.valueOf((char) 10272)+(char) 10270+
				String.valueOf((char) 10272)+(char) 10259+
				String.valueOf((char) 10272)+(char) 10257		
						)));
	}
	@Test
	public void translatePunctuationForMultipleSymbolsAndSpaceWorksFine() {
		assertThat(Oversetter.translatePunctuation(
				", ;: .!( )?/# \\’-- _")
				 , is(equalTo(
				String.valueOf((char) 10242) + " "+
				(char) 10246 +
				(char) 10258 + " " +
				(char) 10290 + 
				(char) 10262 + 
				(char) 10294 + " " +
				(char) 10294 +  
				(char) 10278 +
				(char) 10252 + 
				(char) 10300 + " " +
				(char) 10273 + 
				(char) 10244 +
				(char) 10276 + 
			    (char) 10276 + " "+
				(char) 10296  				
						 )));	
	}
	@Test
	public void textToBrailleWorksFineForAGivenText() {
		assertThat(Oversetter.textToBraille("Narvik; the 4285 GRT Cate B, the 1712 GRT Eldrid, the 1758 GRT Haalegg and the 4306 GRT Saphir. "
				+ "In addition to the Norwegian vessels, four foreign, neutral ships were present; the 951 GRT Dutch steamer Bernisse, and the"
				+ " three Swedish steamships Boden (4264 GRT), Oxelosund (5613 GRT) and Strassa (5603 GRT). As well as neutral ships, the warring"
				+ " parties had vessels at Narvik, riding anchor in the same port. "),
				is(equalTo("⠠⠝⠁⠗⠧⠊⠅⠆ ⠮ ⠼⠙⠃⠓⠑ ⠠⠛⠠⠗⠠⠞ ⠠⠉⠁⠞⠑ ⠠⠃⠂ ⠮ ⠼⠁⠛⠁⠃ ⠠⠛⠠⠗⠠⠞ ⠠⠑⠇⠙⠗⠊⠙⠂ ⠮ ⠼⠁⠛⠑⠓ ⠠⠛⠠⠗⠠⠞ ⠠⠓⠁⠁⠇⠑⠛⠛ ⠯ ⠮ ⠼⠙⠉⠚⠋ ⠠⠛⠠⠗⠠⠞ ⠠⠎⠁⠏⠓⠊⠗⠲ ⠠⠔ ⠁⠙⠙⠊⠞⠊⠕⠝ ⠖ ⠮ "
						+ "⠠⠝⠕⠗⠺⠑⠛⠊⠁⠝ ⠧⠑⠎⠎⠑⠇⠎⠂ ⠋⠕⠥⠗ ⠋⠕⠗⠑⠊⠛⠝⠂ ⠝⠑⠥⠞⠗⠁⠇ ⠎⠓⠊⠏⠎ ⠺⠑⠗⠑ ⠏⠗⠑⠎⠑⠝⠞⠆ ⠮ ⠼⠊⠑⠁ ⠠⠛⠠⠗⠠⠞ ⠠⠙⠥⠞⠉⠓ ⠎⠞⠑⠁⠍⠑⠗ ⠠⠃⠑⠗⠝⠊⠎⠎⠑⠂ ⠯ ⠮ ⠞⠓⠗⠑⠑ ⠠⠎⠺⠑⠙⠊⠎⠓ ⠎⠞⠑⠁⠍⠎⠓⠊⠏⠎ "
						+ "⠠⠃⠕⠙⠑⠝ ⠶⠼⠙⠃⠋⠙ ⠠⠛⠠⠗⠠⠞⠶⠂ ⠠⠕⠭⠑⠇⠕⠎⠥⠝⠙ ⠶⠼⠑⠋⠁⠉ ⠠⠛⠠⠗⠠⠞⠶ ⠯ ⠠⠎⠞⠗⠁⠎⠎⠁ ⠶⠼⠑⠋⠚⠉ ⠠⠛⠠⠗⠠⠞⠶⠲ ⠠⠵ ⠺⠑⠇⠇ ⠵ ⠝⠑⠥⠞⠗⠁⠇ ⠎⠓⠊⠏⠎⠂ ⠮ ⠺⠁⠗⠗⠊⠝⠛ ⠏⠁⠗⠞⠊⠑⠎ ⠓⠁⠙ ⠧⠑⠎⠎⠑⠇⠎ ⠁⠞"
						+ " ⠠⠝⠁⠗⠧⠊⠅⠂ ⠗⠊⠙⠊⠝⠛ ⠁⠝⠉⠓⠕⠗ ⠔ ⠮ ⠎⠁⠍⠑ ⠏⠕⠗⠞⠲")));
	}
	@Test
	public void textToBrailleRemovesSpaceBeforeAndAfterFirstAndLastWord() {
		assertThat(Oversetter.textToBraille("    will will   "),is(equalTo(
				String.valueOf((char) 10298)+ " "+
				(char) 10298
				)));
	}
	@Test
	public void textToBrailleKeepsSpaceBetweenWords() {
		assertThat(Oversetter.textToBraille(" 1 2 3 "),is(equalTo(
				String.valueOf((char) 10300)+ (char)10241 + " "+
							   (char) 10300 + (char)10243 + " "+
							   (char) 10300 + (char)10249
				)));
	}
	@Test
	public void textToBrailleForContractionsWithShavingsWorksFine() {
		assertThat(Oversetter.textToBraille("The, ?The! will "),is(equalTo(
				String.valueOf((char) 10272)+
				(char) 10286+				
				(char) 10242+ " "+
				
				(char) 10278+
				(char) 10272+
				(char) 10286+
				(char) 10262+ " "+				
				
				(char) 10298
				
				)));
	}
	@Test
	public void textToBrailleForFloatingNumberWithPunctuationWorksFine() {
		assertThat(Oversetter.textToBraille("(4,285)"),is(equalTo(
				String.valueOf((char) 10294)+
				
				String.valueOf((char) 10300)+
				String.valueOf((char)10265)+				
				
				String.valueOf((char) 10242)+
				
				String.valueOf((char) 10300)+
				String.valueOf((char)10243)+
				String.valueOf((char)10259)+
				String.valueOf((char)10257)+
				
				String.valueOf((char) 10294)
				)));	
	}	
	@Test
	public void brailleContractionsToWordsForPunctuationAndContractionWorksFine() {
		assertThat(Oversetter.brailleContractionsToWords(String.valueOf((char) 10298)+(char) 10278),
				is(equalTo("will"+(char) 10278)));
	}
	@Test
	public void brailleContractionsToWordsForSpecialCaseToWorksFine() {
		assertThat(Oversetter.brailleContractionsToWords(String.valueOf((char) 10262)+String.valueOf((char) 10262)),
				is(equalTo("to"+(char) 10262)));
	}
	@Test
	public void brailleContractionsToWordsForSpecialCaseToWithBigLetterWorksFine() {
		assertThat(Oversetter.brailleContractionsToWords(String.valueOf((char) 10272)+ (char) 10262 + (char) 10262),
				is(equalTo(String.valueOf((char) 10272)+"to"+(char) 10262)));
	}
	@Test
	public void brailleContractionsToWordsForSpecialCaseHisWorksFine() {
		assertThat(Oversetter.brailleContractionsToWords(String.valueOf((char) 10278)+ (char) 10278),
				is(equalTo("his"+(char) 10278)));
	}
	@Test
	public void brailleContractionsToWordsForSpecialCaseHisWithBigLetterWorksFine() {
		assertThat(Oversetter.brailleContractionsToWords(String.valueOf((char) 10272)+(char) 10278+ (char) 10278),
				is(equalTo(String.valueOf((char) 10272)+"his"+(char) 10278)));
	}
	@Test
	public void brailleContractionsToWordsWhenWordStartWithContractionIsNotAContraction() {
		assertThat(Oversetter.brailleContractionsToWords(String.valueOf((char)10267) + (char)10261 + (char)10270),
				is(equalTo(String.valueOf((char)10267) + (char)10261 + (char)10270)));
	}
	@Test
	public void brailleContractionsToWordsWhenWordEndsWithContractionIsNotAContraction() {
		assertThat(Oversetter.brailleContractionsToWords(String.valueOf((char)10254) + (char)10250 + (char)10270), 
				is(equalTo(String.valueOf((char)10254) + (char)10250 + (char)10270)));
	}
	@Test
	public void brailleContractionsToWordsWhenContractionIsInsideWordIsNotAContraction() {
		assertThat(Oversetter.brailleContractionsToWords(
				String.valueOf((char)10255) + (char)10241 + (char)10269 + (char)10265 + (char)10241)
				, is(equalTo(String.valueOf((char)10255) + (char)10241 + (char)10269 + (char)10265 + (char)10241)));
	}	
	@Test
	public void contractionMatchAndLettersWhenWordStartsWithContractionIsNotAContraction() {
		assertThat(Oversetter.contractionMatchAndLetters("son"),
				is(equalTo(String.valueOf((char)10254) + (char)10261 + (char)10269)));				
	}	
	@Test
	public void contractionMatchAndLettersWhenWordEndsWithContractionIsNotAContraction() {
		assertThat(Oversetter.contractionMatchAndLetters("win"),
				is(equalTo(String.valueOf((char)10298) + (char)10250 + (char)10269)));			
	}
	@Test
	public void contractionMatchAndLettersWhenContractionIsInsideWordIsNotAContraction() {
		assertThat(Oversetter.contractionMatchAndLetters("fast"),
				is(equalTo(String.valueOf((char)10251)+(char)10241+(char)10254+(char)10270)));			
	}
	@Test
	public void brailleContractionsToWordsForContractionsWithOnlyBigLettersDoesNotContract() {
		assertThat(Oversetter.brailleContractionsToWords(
				String.valueOf((char) 10272)+(char)10265+
				String.valueOf((char) 10272)+(char)10261)				
				, is(equalTo(				
				String.valueOf((char) 10272)+(char)10265+
				String.valueOf((char) 10272)+(char)10261	
						)));
	}
	@Test
	public void translateBraillePunctuationClosesOpenedParantheses() {
		assertThat(Oversetter.translateBraillePunctuation(
				String.valueOf((char) 10294 )+String.valueOf((char) 10285 )+
				String.valueOf((char) 10294 )+String.valueOf((char) 10285 )+			
				String.valueOf((char) 10294 )+
				String.valueOf((char) 10285 )+String.valueOf((char) 10294 )				
				),
				is(equalTo("("+String.valueOf((char) 10285 )+")"+String.valueOf((char) 10285 )+"("+String.valueOf((char) 10285 )+")")));
	}
	@Test
	public void translateBrailleNumbersForNumberWithMinimunTwoDigitsWorksFine() {
		assertThat(Oversetter.translateBrailleNumbers(
				String.valueOf((char) 10300)+ (char) 10241 + (char) 10243 + (char) 10249 + (char) 10265 + (char) 10257 +
				(char) 10251 + (char) 10267 + (char) 10259 + (char) 10250 + (char) 10266 )				
				,is(equalTo("1234567890")));
	}
	@Test
	public void translateBrailleNumbersForFloatingNumberWithCommaWorksFine() {
		assertThat(Oversetter.translateBrailleNumbers(
				String.valueOf((char) 10300) + (char) 10265 + (char) 10242 + (char) 10300 + (char) 10266 + (char) 10250),
				is(equalTo("4"+(char) 10242+"09")));
	}
	@Test
	public void translateBrailleNumbersForFloatingNumberWithPunctumWorksFine() {
		assertThat(Oversetter.translateBrailleNumbers(
				String.valueOf((char) 10300) + (char) 10265 + (char) 10290 + (char) 10300 + (char) 10266 + (char) 10250),
				is(equalTo("4"+(char) 10290+"09")));
	}
	@Test
	public void translateBrailleNumbersForFloatingNumberWithPunctuationBeforeWorksFine() {
		assertThat(Oversetter.translateBrailleNumbers(
				String.valueOf((char) 10294) + (char) 10300 + (char) 10265 + (char) 10290 + (char) 10300 + (char) 10266 + (char) 10250),
				is(equalTo(String.valueOf((char) 10294)+"4"+(char) 10290+"09")));
	}
	@Test
	public void translateBrailleNumbersForFloatingNumberWithPunctuationAfterWorksFine() {
		assertThat(Oversetter.translateBrailleNumbers(
				String.valueOf((char) 10300) + (char) 10265 + (char) 10290 + (char) 10300 + (char) 10266 + (char) 10250) + (char) 10294,
				is(equalTo("4"+(char) 10290+"09"+String.valueOf((char) 10294))));
	}
	@Test
	public void translateBrailleNumbersForFloatingNumberWithPunctuationBeforeAndAfterWorksFine() {
		assertThat(Oversetter.translateBrailleNumbers(
				String.valueOf((char) 10294) + (char) 10300 + (char) 10265 + (char) 10290 + (char) 10300 + (char) 10266 + (char) 10250) + (char) 10294,
				is(equalTo(String.valueOf((char) 10294) + "4"+(char) 10290+"09"+String.valueOf((char) 10294))));
	}
	@Test
	public void translateBrailleNumbersForMultipleCharactersFromAtoJDoesNotMakeNumbers() {
		assertThat(Oversetter.translateBrailleNumbers(String.valueOf((char)10241)+String.valueOf((char)10243)+String.valueOf((char)10249)),
				is(equalTo(String.valueOf((char)10241)+String.valueOf((char)10243)+String.valueOf((char)10249))));
	}
	@Test
	public void translateBrailleCharactersForMultipleConsecutiveBrailleLettersWorksFine() {
		assertThat(Oversetter.translateBrailleCharacters(
				String.valueOf((char) 10277) + (char) 10279 + (char) 10298 + (char) 10285 + (char) 10301 + (char) 10293),
				is(equalTo("uvwxyz")));
	}
	@Test
	public void translateBrailleCharactersForMultipleBrailleLettersWithNonLettersBeforeAfterAndBetweenWorksFine() {
		assertThat(Oversetter.translateBrailleCharacters(
				"?!"+String.valueOf((char) 10277) + (char) 10279 + (char) 10298 +".,"+(char) 10285 + (char) 10301 + (char) 10293 + "_;"),
				is(equalTo("?!uvw.,xyz_;")));
	}
	@Test
	public void makeSmallLettersBigForMultipleLettersWithNonLettersBeforeAfterAndBetweenWorksFine() {
		assertThat(Oversetter.makeSmallLettersBig(
				"?!"+(char) 10272+'g'+(char) 10272+'h'+":/"+(char) 10272+'v'+(char) 10272+'c'+(char) 10272+'p'+ "_;"),
				is(equalTo("?!GH:/VCP_;")));
	}
	@Test
	public void brailleToTextWorksFineForAGivenText() {
		assertThat(Oversetter.brailleToText("⠠⠔ ⠁⠙⠙⠊⠞⠊⠕⠝ ⠖ ⠮ ⠠⠝⠕⠗⠺⠑⠛⠊⠁⠝ ⠧⠑⠎⠎⠑⠇⠎⠂ ⠋⠕⠥⠗ ⠋⠕⠗⠑⠊⠛⠝⠂ ⠝⠑⠥⠞⠗⠁⠇ ⠎⠓⠊⠏⠎ ⠺⠑⠗⠑ ⠏⠗⠑⠎⠑⠝⠞⠆ ⠮ ⠼⠊⠑⠁ ⠠⠛⠠⠗⠠⠞ ⠠⠙⠥⠞⠉⠓ ⠎⠞⠑⠁⠍⠑⠗ ⠠⠃⠑⠗⠝⠊⠎⠎⠑⠂ ⠯ ⠮ ⠼ ⠭⠽⠵"),
				is(equalTo("In addition to the Norwegian vessels, four foreign, neutral ships were present; the 951 GRT Dutch steamer Bernisse, and the # xyz ")));	
	}
	@Test
	public void severalBrailleWordsWithMultipleWhitespacesBetweenBeforeAndAfterThemSplitsCorrectly() {
		assertThat(Oversetter.getWordsFromText(" \n\n \n      " + 
				(char) 10300 + (char) 10266 + (char) 10250 + "\n    \n \n" + 
				(char) 10300 + (char) 10266 + (char) 10250 + " \n \n\n \n "+
				(char) 10300 + (char) 10266 + (char) 10250 + "  \n  \n\n\n  \n"),is(equalTo(new String[] {
						""+(char) 10300 + (char) 10266 + (char) 10250,
						""+(char) 10300 + (char) 10266 + (char) 10250,
						""+(char) 10300 + (char) 10266 + (char) 10250})));
	}
	 
}
