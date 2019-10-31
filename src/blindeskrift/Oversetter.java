package blindeskrift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Oversetter {	
	
	private static char numberIndicator = (char) 10300;
	private static char bigLetterIndicator = (char) 10272;
	
	private static Map<String, String> numbersMap = new HashMap<>();
	private static Map<String, String> contractionsMap = new HashMap<>();
	private static Map<String, String> charactersMap = new HashMap<>();
	private static Map<String, String> punctuationMap = new HashMap<>();
	
	static Map<String, String> brailleContractionsMap = new HashMap<>();
	private static Map<String, String> braillePunctuationMap = new HashMap<>();
	private static Map<String, String> brailleNumbersMap = new HashMap<>();
	private static Map<String, String> brailleCharactersMap = new HashMap<>();
	
	static boolean nextParantheses = false;
	
	static {
		numbersMap.put("1", String.valueOf((char) 10241 ));
		numbersMap.put("2", String.valueOf((char) 10243 ));
		numbersMap.put("3", String.valueOf((char) 10249 ));
		numbersMap.put("4", String.valueOf((char) 10265 ));
		numbersMap.put("5", String.valueOf((char) 10257 ));
		numbersMap.put("6", String.valueOf((char) 10251 ));
		numbersMap.put("7", String.valueOf((char) 10267 ));
		numbersMap.put("8", String.valueOf((char) 10259 ));
		numbersMap.put("9", String.valueOf((char) 10250 ));
		numbersMap.put("0", String.valueOf((char) 10266 ));
		
		contractionsMap.put("but",       String.valueOf((char) 10243 ));		
		contractionsMap.put("can",       String.valueOf((char) 10249 ));
		contractionsMap.put("do",        String.valueOf((char) 10265 ));
		contractionsMap.put("every",     String.valueOf((char) 10257 ));
		contractionsMap.put("from",      String.valueOf((char) 10251 ));
		contractionsMap.put("go",        String.valueOf((char) 10267 ));
		contractionsMap.put("have",      String.valueOf((char) 10259 ));
		contractionsMap.put("just",      String.valueOf((char) 10266 ));
		contractionsMap.put("knowledge", String.valueOf((char) 10280 ));
		contractionsMap.put("like",      String.valueOf((char) 10296 ));
		contractionsMap.put("more",      String.valueOf((char) 10253 ));
		contractionsMap.put("not",       String.valueOf((char) 10269 ));
		contractionsMap.put("people",    String.valueOf((char) 10255 ));
		contractionsMap.put("quite",     String.valueOf((char) 10271 ));
		contractionsMap.put("rather",    String.valueOf((char) 10263 ));
		contractionsMap.put("so", 		 String.valueOf((char) 10254 ));
		contractionsMap.put("that", 	 String.valueOf((char) 10270 ));
		contractionsMap.put("us",	     String.valueOf((char) 10277 ));
		contractionsMap.put("very",	     String.valueOf((char) 10279 ));
		contractionsMap.put("it", 	     String.valueOf((char) 10285 ));
		contractionsMap.put("you", 	     String.valueOf((char) 10301 ));
		contractionsMap.put("as", 	     String.valueOf((char) 10293 ));
		contractionsMap.put("and",	     String.valueOf((char) 10287 ));
		contractionsMap.put("for",	     String.valueOf((char) 10303 ));
		contractionsMap.put("of", 	     String.valueOf((char) 10295 ));
		contractionsMap.put("the", 	     String.valueOf((char) 10286 ));
		contractionsMap.put("with",	     String.valueOf((char) 10302 ));
		contractionsMap.put("will", 	 String.valueOf((char) 10298 ));
		contractionsMap.put("his", 	     String.valueOf((char) 10278 ));
		contractionsMap.put("in", 	     String.valueOf((char) 10260 ));
		contractionsMap.put("was", 	     String.valueOf((char) 10292 ));
		contractionsMap.put("to", 	     String.valueOf((char) 10262 ));
		
		charactersMap.put("a", String.valueOf((char) 10241 ));		
		charactersMap.put("b", String.valueOf((char) 10243 ));
		charactersMap.put("c", String.valueOf((char) 10249 ));
		charactersMap.put("d", String.valueOf((char) 10265 ));
		charactersMap.put("e", String.valueOf((char) 10257 ));
		charactersMap.put("f", String.valueOf((char) 10251 ));
		charactersMap.put("g", String.valueOf((char) 10267 ));
		charactersMap.put("h", String.valueOf((char) 10259 ));
		charactersMap.put("i", String.valueOf((char) 10250 ));
		charactersMap.put("j", String.valueOf((char) 10266 ));
		charactersMap.put("k", String.valueOf((char) 10245 ));
		charactersMap.put("l", String.valueOf((char) 10247 ));
		charactersMap.put("m", String.valueOf((char) 10253 ));
		charactersMap.put("n", String.valueOf((char) 10269 ));
		charactersMap.put("o", String.valueOf((char) 10261 ));
		charactersMap.put("p", String.valueOf((char) 10255 ));
		charactersMap.put("q", String.valueOf((char) 10271 ));
		charactersMap.put("r", String.valueOf((char) 10263 ));
		charactersMap.put("s", String.valueOf((char) 10254 ));
		charactersMap.put("t", String.valueOf((char) 10270 ));
		charactersMap.put("u", String.valueOf((char) 10277 ));
		charactersMap.put("v", String.valueOf((char) 10279 ));
		charactersMap.put("w", String.valueOf((char) 10298 ));
		charactersMap.put("x", String.valueOf((char) 10285 ));
		charactersMap.put("y", String.valueOf((char) 10301 ));
		charactersMap.put("z", String.valueOf((char) 10293 ));
		
		punctuationMap.put(",",  String.valueOf((char) 10242 ));			
		punctuationMap.put(";",  String.valueOf((char) 10246 ));	
		punctuationMap.put(":",  String.valueOf((char) 10258 ));	
		punctuationMap.put(".",  String.valueOf((char) 10290 ));	
		punctuationMap.put("!",  String.valueOf((char) 10262 ));	
		punctuationMap.put("(",  String.valueOf((char) 10294 ));	
		punctuationMap.put(")",  String.valueOf((char) 10294 ));	
		punctuationMap.put("?",  String.valueOf((char) 10278 ));	
		punctuationMap.put("/",  String.valueOf((char) 10252 ));	
		punctuationMap.put("#",  String.valueOf((char) 10300 ));	
		punctuationMap.put("\\", String.valueOf((char) 10273 ));	
		punctuationMap.put("’",  String.valueOf((char) 10244 ));	
		punctuationMap.put("-",  String.valueOf((char) 10276 ));	
		punctuationMap.put("-",  String.valueOf((char) 10276 ));	
		punctuationMap.put("_",  String.valueOf((char) 10296 ));		
		
		brailleContractionsMap.put(String.valueOf((char) 10243 ), "but");		
		brailleContractionsMap.put(String.valueOf((char) 10249 ), "can");		
		brailleContractionsMap.put(String.valueOf((char) 10265 ), "do");		
		brailleContractionsMap.put(String.valueOf((char) 10257 ), "every");		
		brailleContractionsMap.put(String.valueOf((char) 10251 ), "from");		
		brailleContractionsMap.put(String.valueOf((char) 10267 ), "go");		
		brailleContractionsMap.put(String.valueOf((char) 10259 ), "have");		
		brailleContractionsMap.put(String.valueOf((char) 10266 ), "just");		
		brailleContractionsMap.put(String.valueOf((char) 10280 ), "knowledge");		
		brailleContractionsMap.put(String.valueOf((char) 10296 ), "like");		
		brailleContractionsMap.put(String.valueOf((char) 10253 ), "more");		
		brailleContractionsMap.put(String.valueOf((char) 10269 ), "not");		
		brailleContractionsMap.put(String.valueOf((char) 10255 ), "people");		
		brailleContractionsMap.put(String.valueOf((char) 10271 ), "quite");		
		brailleContractionsMap.put(String.valueOf((char) 10263 ), "rather");		
		brailleContractionsMap.put(String.valueOf((char) 10254 ), "so");		
		brailleContractionsMap.put(String.valueOf((char) 10270 ), "that");		
		brailleContractionsMap.put(String.valueOf((char) 10277 ), "us");		
		brailleContractionsMap.put(String.valueOf((char) 10279 ), "very");		
		brailleContractionsMap.put(String.valueOf((char) 10285 ), "it");		
		brailleContractionsMap.put(String.valueOf((char) 10301 ), "you");		
		brailleContractionsMap.put(String.valueOf((char) 10293 ), "as");		
		brailleContractionsMap.put(String.valueOf((char) 10287 ), "and");		
		brailleContractionsMap.put(String.valueOf((char) 10303 ), "for");		
		brailleContractionsMap.put(String.valueOf((char) 10295 ), "of");		
		brailleContractionsMap.put(String.valueOf((char) 10286 ), "the");		
		brailleContractionsMap.put(String.valueOf((char) 10302 ), "with");		
		brailleContractionsMap.put(String.valueOf((char) 10298 ), "will");		
		brailleContractionsMap.put(String.valueOf((char) 10278 ), "his");		
		brailleContractionsMap.put(String.valueOf((char) 10260 ), "in");		
		brailleContractionsMap.put(String.valueOf((char) 10292 ), "was");		
		brailleContractionsMap.put(String.valueOf((char) 10262 ), "to");	 	
		
		braillePunctuationMap.put(String.valueOf((char) 10242 ), ",");				
		braillePunctuationMap.put(String.valueOf((char) 10246 ), ";");
		braillePunctuationMap.put(String.valueOf((char) 10258 ), ":");
		braillePunctuationMap.put(String.valueOf((char) 10290 ), ".");
		braillePunctuationMap.put(String.valueOf((char) 10262 ), "!");
		braillePunctuationMap.put(String.valueOf((char) 10294 ), "(");		
		braillePunctuationMap.put(String.valueOf((char) 10278 ), "?");
		braillePunctuationMap.put(String.valueOf((char) 10252 ), "/");
		braillePunctuationMap.put(String.valueOf((char) 10300 ), "#");
		braillePunctuationMap.put(String.valueOf((char) 10273 ), "\\");
		braillePunctuationMap.put(String.valueOf((char) 10244 ), "’");
		braillePunctuationMap.put(String.valueOf((char) 10276 ), "-");		
		braillePunctuationMap.put(String.valueOf((char) 10296 ), "_");
		
		brailleNumbersMap.put(String.valueOf((char)10241), "1");		
		brailleNumbersMap.put(String.valueOf((char)10243), "2");
		brailleNumbersMap.put(String.valueOf((char)10249), "3");
		brailleNumbersMap.put(String.valueOf((char)10265), "4");
		brailleNumbersMap.put(String.valueOf((char)10257), "5");
		brailleNumbersMap.put(String.valueOf((char)10251), "6");
		brailleNumbersMap.put(String.valueOf((char)10267), "7");
		brailleNumbersMap.put(String.valueOf((char)10259), "8");
		brailleNumbersMap.put(String.valueOf((char)10250), "9");
		brailleNumbersMap.put(String.valueOf((char)10266), "0");
		
		brailleCharactersMap.put( String.valueOf((char) 10241), "a");			
		brailleCharactersMap.put( String.valueOf((char) 10243), "b");
		brailleCharactersMap.put( String.valueOf((char) 10249), "c");
		brailleCharactersMap.put( String.valueOf((char) 10265), "d");
		brailleCharactersMap.put( String.valueOf((char) 10257), "e");
		brailleCharactersMap.put( String.valueOf((char) 10251), "f");
		brailleCharactersMap.put( String.valueOf((char) 10267), "g");
		brailleCharactersMap.put( String.valueOf((char) 10259), "h");
		brailleCharactersMap.put( String.valueOf((char) 10250), "i");
		brailleCharactersMap.put( String.valueOf((char) 10266), "j");
		brailleCharactersMap.put( String.valueOf((char) 10245), "k");
		brailleCharactersMap.put( String.valueOf((char) 10247), "l");
		brailleCharactersMap.put( String.valueOf((char) 10253), "m");
		brailleCharactersMap.put( String.valueOf((char) 10269), "n");
		brailleCharactersMap.put( String.valueOf((char) 10261), "o");
		brailleCharactersMap.put( String.valueOf((char) 10255), "p");
		brailleCharactersMap.put( String.valueOf((char) 10271), "q");
		brailleCharactersMap.put( String.valueOf((char) 10263), "r");
		brailleCharactersMap.put( String.valueOf((char) 10254), "s");
		brailleCharactersMap.put( String.valueOf((char) 10270), "t");
		brailleCharactersMap.put( String.valueOf((char) 10277), "u");
		brailleCharactersMap.put( String.valueOf((char) 10279), "v");
		brailleCharactersMap.put( String.valueOf((char) 10298), "w");
		brailleCharactersMap.put( String.valueOf((char) 10285), "x");
		brailleCharactersMap.put( String.valueOf((char) 10301), "y");
		brailleCharactersMap.put( String.valueOf((char) 10293), "z");

	}	
	public static String[] getWordsFromText(String text) {
		String[] splitByWhitespaces = text.split(" |\n");
		ArrayList<String> onlyWords = new ArrayList<>();

		for (int index = 0; index < splitByWhitespaces.length; index++)
			if (!splitByWhitespaces[index].isEmpty())
				onlyWords.add(splitByWhitespaces[index]);
				
		String[] output = onlyWords.toArray(new String[onlyWords.size()]);

		return output;
	}
	public static String processDigits(String word) {
		StringBuilder output = new StringBuilder();
		boolean digitProcessed = false;
		for(int index = 0 ; index < word.length(); index++) {
			if (Character.isDigit(word.charAt(index))) {				
				if (!digitProcessed) {
					output.append(numberIndicator);
					output.append(numbersMap.get(String.valueOf(word.charAt(index))));
					digitProcessed = true;
				}
				else 
					output.append(numbersMap.get(String.valueOf(word.charAt(index))));
			}
			else {				
				output.append(word.charAt(index));
				digitProcessed = false;
			}
		}
		return output.toString();
	}
	public static String makeBigLettersSmall(String word) {
		StringBuilder output = new StringBuilder();
		for(int index = 0 ; index < word.length(); index++) {
			if (Character.isUpperCase(word.charAt(index))) {
				output.append(bigLetterIndicator);
				output.append(Character.toLowerCase(word.charAt(index)));
			}
			else 
				output.append(word.charAt(index));
		}
		return output.toString();
	}
	public static String removePunctuations(String word) {		
		return word.replaceAll("\\p{P}", "");
	}
	public static String contractionMatchAndLetters(String word) {
		StringBuilder output = new StringBuilder();
		boolean contractionFound = false;
		for (String key : contractionsMap.keySet()) {			
			if(word.equals(String.valueOf(bigLetterIndicator) + key)) {				
				output.append(String.valueOf(bigLetterIndicator) + contractionsMap.get(key));
				contractionFound = true;
			}
			else if (word.equals(key)) {
				output.append(contractionsMap.get(key));
				contractionFound = true;
			}
		}
		if (!contractionFound) {
		for (int index = 0; index < word.length(); index++) {
			if(Character.isLetter(word.charAt(index)))
				output.append(charactersMap.get(String.valueOf(word.charAt(index))));
			else
				output.append(word.charAt(index));			
			}
		}
		return output.toString();
	}
	public static String translatePunctuation(String word) {
		StringBuilder output = new StringBuilder();
		
		for(int index = 0; index < word.length() ; index++) {
			if(punctuationMap.containsKey(String.valueOf(word.charAt(index))))
				output.append(punctuationMap.get(String.valueOf(word.charAt(index))));
			else 
				output.append(word.charAt(index));
		}
		return output.toString();
	}
	public static String textToBraille(String text) {
		String[] allTheWordsInTheText = getWordsFromText(text);
		String eachWord = "";
		String trimmedWord = "";
		String shavings = "";
		StringBuilder output = new StringBuilder();
		
		for(int index = 0; index < allTheWordsInTheText.length; index++) {
			
			if(contractionsMap.containsKey(removePunctuations(allTheWordsInTheText[index].toLowerCase()))) {
				eachWord = makeBigLettersSmall(allTheWordsInTheText[index]);
				trimmedWord = removePunctuations(eachWord);
				shavings = eachWord.replace(trimmedWord, " ");
				trimmedWord = contractionMatchAndLetters(trimmedWord);
				shavings = translatePunctuation(shavings);
				eachWord = shavings.replace(" ", trimmedWord);
			}
			else {
				eachWord = processDigits(allTheWordsInTheText[index]);
				eachWord = makeBigLettersSmall(eachWord);
				eachWord = contractionMatchAndLetters(eachWord);
				eachWord = translatePunctuation(eachWord);
			}
				output.append(eachWord);
				if (index == allTheWordsInTheText.length-1) {}
				else
					output.append(" ");			
		}
		return output.toString();
	}
	public static String brailleContractionsToWords(String word) {
			if(brailleContractionsMap.containsKey(word.replaceAll("[⠂⠲⠆⠒⠖⠶⠦⠌⠄⠼⠤⠠'⠡\"]", ""))) {
				word = word.replace(word.replaceAll("[⠂⠲⠆⠒⠖⠶⠦⠌⠄⠼⠤⠠'⠡\"]", ""), brailleContractionsMap.get(word.replaceAll("[⠂⠲⠆⠒⠖⠶⠦⠌⠄⠼⠤⠠'⠡\"]", "")));				
			}
			else {
				
				if(word.charAt(0)==(char) 10262) {
					word = word.replaceFirst(String.valueOf((char) 10262), "to");
				}
				else if (word.charAt(0)==(char)10278) {
					word = word.replaceFirst(String.valueOf((char)10278), "his");
				}
				else if(word.charAt(0) == bigLetterIndicator && word.charAt(1) == (char) 10262) {
					word = word.replaceFirst(String.valueOf((char) 10262), "to");
				}
				else if(word.charAt(0) == bigLetterIndicator && word.charAt(1) == (char) 10278) {
					word = word.replaceFirst(String.valueOf((char) 10278), "his");
				}
			}
			return word;	
	}	
	public static String translateBraillePunctuation(String word) {
		StringBuilder output = new StringBuilder();			
		for (int index = 0; index < word.length(); index++) {			
			if(braillePunctuationMap.containsKey(String.valueOf(word.charAt(index))) && (word.charAt(index) != (char)10300)) { 
				if(word.charAt(index) == (char) 10294) {
					if(!nextParantheses) {
						output.append("(");
						nextParantheses = true;
					}
					else {
						output.append(")");
						nextParantheses = false;
					}
				}
				else { 
					output.append(braillePunctuationMap.get(String.valueOf(word.charAt(index))));
				}
			}
			else 
				output.append(word.charAt(index));
		}
		if (word.equals(String.valueOf((char)10300)))
			return braillePunctuationMap.get(String.valueOf((char)10300));			
		return output.toString();
	}	
	public static String translateBrailleNumbers(String word) {
		StringBuilder output = new StringBuilder();		
				
		if(word.indexOf(numberIndicator) == -1) return word;
		else {				
			for(int index = 0; index < word.length(); index++) {
				if(word.charAt(index) == numberIndicator) {
					if(index == word.length()-1) {
						output.append(String.valueOf(word.charAt(index)));
						return output.toString();
					}					
					if(brailleNumbersMap.containsKey(String.valueOf(word.charAt(index+1)))) {
						output.append(brailleNumbersMap.get(String.valueOf(word.charAt(index+1))));
						index +=2;
						if(index == word.length()) return output.toString();
					}
					while(index < word.length() && brailleNumbersMap.containsKey(String.valueOf(word.charAt(index)))) {
						output.append(brailleNumbersMap.get(String.valueOf(word.charAt(index))));	
						index++;
						if(index == word.length()-1) {
							if(brailleNumbersMap.containsKey(String.valueOf(word.charAt(index))))
								output.append(brailleNumbersMap.get(String.valueOf(word.charAt(index))));
							else
								output.append(String.valueOf(word.charAt(index)));
							return output.toString();
						}
						else if (index == word.length()) 
							return output.toString();
					}	
				}
				output.append(String.valueOf(word.charAt(index)));				
			}	
		}		
		return output.toString();		
	}	
	public static String translateBrailleCharacters(String word) {
		StringBuilder output = new StringBuilder();
		for (int index = 0; index < word.length(); index++) {
			if(brailleCharactersMap.containsKey(String.valueOf(word.charAt(index))))	{
				output.append(brailleCharactersMap.get(String.valueOf(word.charAt(index))));
			}
			else if(word.charAt(index) == numberIndicator) {
				output.append(braillePunctuationMap.get(String.valueOf(numberIndicator)));
			}
			else
				output.append(word.charAt(index));
		}
		return output.toString();
	}
	public static String makeSmallLettersBig(String word) {
		StringBuilder output = new StringBuilder();
		for (int index = 0; index < word.length(); index++) {
			if(word.charAt(index) == bigLetterIndicator) {
				output.append(Character.toUpperCase(word.charAt(index+1)));
				index ++;
			}
			else 
				output.append(word.charAt(index));
		}
		return output.toString();
	}
	public static String brailleToText(String text) {
		String[] allTheWordsInTheText = getWordsFromText(text);
		String eachWord = "";
		
		StringBuilder output = new StringBuilder();
				
		for(int index = 0; index < allTheWordsInTheText.length; index++) {
			
			eachWord = brailleContractionsToWords(allTheWordsInTheText[index]);
			eachWord = translateBraillePunctuation(eachWord);
			eachWord = translateBrailleNumbers(eachWord);			
			eachWord = translateBrailleCharacters(eachWord);
			eachWord = makeSmallLettersBig(eachWord);
			
			output.append(eachWord);
			output.append(" ");			
		}
		return output.toString();
	}	
}
	
