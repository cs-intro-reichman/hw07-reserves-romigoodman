

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag.toLowerCase(), dictionary); // all be the same
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

	public static boolean existInDictionary(String word, String []dictionary) {
		for (int i=0; i<dictionary.length; i++) //(String WordInDictionary : dictionary) 
		{
			String wordInDictionary = dictionary[i];
			if ( wordInDictionary.equals(dictionary))
			{
				return true;
			}
        }
        
        return false;
		
		// String myInput = word;
		// boolean isPresent = false;

		// //
		// {
		// if (myInput==dictionary[i])
		// 	{
		// 		isPresent=true;
		// 	}
		// else 
		// 	{
		// 	isPresent=false;
		// 	}
		// }
		// return isPresent;
	}
	public static void breakHashTag(String hashtag, String[] dictionary) 
	{
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) 
		{
            return;
        }

		for (int i = 1; i <= hashtag.length(); i++) //starts at 1 because we want to consider prefixes of the hashtag string starting from a single character and gradually increasing in length
		{
			String prefix = hashtag.substring(0, i);
			if (existInDictionary(prefix, dictionary)) 
			{
			System.out.println(prefix);
			String remaining = hashtag.substring(i);
			
			if (!remaining.isEmpty()) 
			{
				breakHashTag(remaining, dictionary);
			}
			
        	}
		}	 	
    }

	