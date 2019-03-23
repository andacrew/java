import java.util.Scanner;

public class Assignment01 
{
	enum Word
	{
		P1("Placeholder", "adjective", "To be updated..."),
		P2("Placeholder", "adjective", "To be updated..."),
		P3("Placeholder", "adverb", "To be updated..."),
		P4("Placeholder", "conjunction", "To be updated..."),
		P5("Placeholder", "interjection", "To be updated..."),
		P6("Placeholder", "noun", "To be updated..."),
		P7("Placeholder", "noun", "To be updated..."),
		P8("Placeholder", "noun", "To be updated..."),
		P9("Placeholder", "prepositon", "To be updated..."),
		P10("Placeholder", "pronoun", "To be updated..."),
		P11("Placeholder", "verb", "To be updated..."),
		P12("CSC210", "adjective", "Comfortable with Objects and Classes."),
		P13("CSC210", "adjective", "Ready for CSC 220."),
		P14("CSC210", "noun", "Intro to JAVA."),
		P15("CSC210", "verb", "To learn JAVA."),
		P16("CSC220", "adjective", "Ready to create complex data structures."),
		P17("CSC220", "noun", "Data Structures."),
		P18("CSC220", "verb", "To create data structures."),
		P19("CSC340", "adjective", "= C++ version of CSC210 + CSC220 + more."),
		P20("CSC340", "noun", "A CS upper division course."),
		P21("CSC340", "noun", "Many hours outside of class."),
		P22("CSC340", "noun", "Programming Methodology."),
		P23("Verb", "noun", "Verb is a word or group of words that expresses");
		
		private final String keyWord;
		private String partOfSpeech;
		private String defn;
		private static String[] pos = { "adjective", "adverb", "conjunction", "interjection", "noun", "preposition", "pronoun", "verb"};
		
		private Word( String keyWord, String partOfSpeech, String defn )
		{
			this.keyWord = keyWord;
			this.partOfSpeech = partOfSpeech;
			this.defn = defn;
		}

		public String getKeyWord()
		{
			return keyWord;
		}

		public String getPartOfSpeech()
		{
			return partOfSpeech;
		}

		public String getDefn()
		{
			return defn;
		}

		static void nf()
		{
			System.out.printf("%9s%s", "", "<Not found>\n");
		}
		
		static void badArg()
		{
			System.out.printf("%9s%s", "", "<2nd argument must be a part of speech or \"distinct\">\n");

		}
		
		static void output(Word word)
		{
			System.out.printf("%9s%s", "", word);
		}
		
		@Override
		public String toString()
		{
			return this.keyWord + " [" + this.partOfSpeech + "] : " + this.defn + "\n";
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		String userInput;
		String end = "!q";
		String dist = "distinct";
		String tempWord = "";
		int counter = 0;
		int check = 0;
		
		System.out.println("run:");
		System.out.println("! Loading data...");
		System.out.println("! Loading completed...\n");
		System.out.println("----DICTIONARY 340 JAVA----\n");
		
		do
		{
			System.out.print("Search: ");
			userInput = input.nextLine();
			String[] splitUserInput = userInput.trim().split("\\s+");
			
			if ( userInput.compareTo(end)!=0 )
			{
				System.out.printf("%10s", "|\n");
				
				for( Word word : Word.values() )
				{
					if ( splitUserInput.length >= 1 && splitUserInput[0].equalsIgnoreCase(word.keyWord) )
					{
						if ( splitUserInput.length >= 2 && (splitUserInput[1].equalsIgnoreCase(word.partOfSpeech) || splitUserInput[1].equalsIgnoreCase(dist)) )
						{
							if ( splitUserInput[1].equalsIgnoreCase(word.partOfSpeech) )
							{
								if( splitUserInput.length == 3 && splitUserInput[2].equalsIgnoreCase(dist))
								{
									if (tempWord != word.defn)
									{
										Word.output(word);
										tempWord = word.defn;
										counter++;
									}
								}else
								{
									Word.output(word);
									counter++;
								}
							}else if ( splitUserInput.length == 2 && tempWord != word.partOfSpeech)
							{
								Word.output(word);
								tempWord = word.partOfSpeech;
								counter++;
							}
						}else if (splitUserInput.length == 1)
						{
							Word.output(word);
							counter++;
						}else if (splitUserInput.length == 2 )
						{
							for ( int i = 0; i <= Word.pos.length-1; )
							{
								if( splitUserInput[1].equalsIgnoreCase( Word.pos[i]) )
								{
									check++;
								}
								i++;
							}
							if (check == 0 )
							{
								Word.badArg();
								counter++;
								check++;
							}
						}
					}	
				}
				if( counter == 0 )
				{
					Word.nf();
				}
				counter = 0;
				check = 0;
				System.out.printf("%10s","|\n");
			}

		}while (userInput.compareTo(end) != 0);	
		input.close();		
		System.out.println("\n----THANK YOU----");
	}
}
