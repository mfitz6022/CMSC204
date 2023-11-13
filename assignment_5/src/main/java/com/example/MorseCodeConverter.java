package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	private static MorseCodeTree morseTree = new MorseCodeTree();
	
	public MorseCodeConverter() {}
	
	public static String printTree() {
		String treeString = "";
		ArrayList<String> treeList = morseTree.toArrayList();

		for(int i = 0; i < treeList.size(); i++) {
			if(i == treeList.size() - 1)
				treeString += treeList.get(i);
			else
				treeString += treeList.get(i) + " ";
		}

		return treeString;
	}
	
	public static String convertToEnglish(String code) {
		String convertedString = "";
		String[] words = code.split("/");

		for (int i = 0; i < words.length; i++) {
			String[] letters = words[i].split(" ");

			for (int j = 0; j < letters.length; j++) {
				convertedString += morseTree.fetch(letters[j]);
			}

			if (i != words.length - 1)
				convertedString += " ";
		}

		return convertedString;
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		String convertedString = "";
		Scanner inFile = new Scanner(codeFile);

		while(inFile.hasNext()) {
			String line = inFile.nextLine();
			String[] words = line.split("/");

			for (int i = 0; i < words.length; i++) {
				String[] letters = words[i].split(" ");

				for (int j = 0; j < letters.length; j++) {
					convertedString += morseTree.fetch(letters[j]);
				}

				if (i != words.length - 1)
					convertedString += " ";
			}
		}

		return convertedString;
	}
}
