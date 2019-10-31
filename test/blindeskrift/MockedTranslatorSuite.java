package blindeskrift;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	
		AlfaContractionsParameterizedTests.class, 
		AlfaContractionsWithBigLetterParameterizedTests.class,
		AlfaPunctuationsParameterizedTests.class, 
		AlfaSmallLettersParameterizedTests.class,
		BrailleBigLetterIndicatorParameterizedTests.class, 
		BrailleCharactersAreNotDigitsParameterizedTests.class,
		BrailleCharactersParameterizedTests.class, 
		BrailleContractionsThatStartWithBigLetterParameterizedTests.class,
		BrailleContractionsToWordsParameterizedTests.class, 
		BrailleDigitsToAlfaNumericParameterizedTests.class,
		BraillePunctuationsToAlfaNumericParameterizedTests.class, 
		OversetterTest.class, 
		MockedBufferedReaderAndWriterTests.class })

public class MockedTranslatorSuite { }
