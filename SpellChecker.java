
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static int levenshtein(String word1, String word2) 
	{
		String lowercase1 = word1.toLowerCase();
		String lowercase2 = word2.toLowerCase();

		if (lowercase2.length() == 0) {
			return lowercase1.length(); // If word2 is empty, return length of word1
		} else if (lowercase1.length() == 0) {
			return lowercase2.length(); // If word1 is empty, return length of word2
		}

		//Compare the first characters
   		 if (getHead(lowercase1) == getHead(lowercase2)) {
        // If first characters are the same, continue with the rest of the strings
		return levenshtein(lowercase1.substring(1), lowercase2.substring(1));}

		else {
        // If first characters are different, consider three operations (insertion, deletion, substitution)
		int substitutionNum = levenshtein(lowercase1.substring(1), lowercase2.substring(1));
        int insertionNum = levenshtein(lowercase1, lowercase2.substring(1));
        int deletionNum = levenshtein(lowercase1.substring(1), lowercase2);

		 // Return 1 + minimum cost among the three operations
		return 1+Math.min(substitutionNum, Math.min(deletionNum, insertionNum));
	}
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i=0; i<dictionary.length; i++)
		{
			{
			dictionary[i]=in.readLine(); 
			}
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		String closestWord = word;
    
		for (int i = 0; i < dictionary.length; i++) 
		{

			String dictionaryWord = dictionary[i];
            int distance = levenshtein(word, dictionaryWord);

            if (distance < threshold) 
			{
                closestWord = dictionaryWord;
            }
        
		}
		return closestWord;
		
    }
	
	

	public static char getHead(String word) 
	{
		if (word.isEmpty()) {
		throw new IllegalArgumentException("Empty string has no head");
		}
		return word.charAt(0);
	}
}

