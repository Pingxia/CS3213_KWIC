package logic;

import java.util.ArrayList;
import java.util.HashMap;


import storage.Title;

public class CircularShifter implements ICircularShifter {

	public static void process( HashMap<String, Integer> wordsToIgnore, String s, int indexOfThisLine) {
		// TODO Auto-generated method stub
		ArrayList<Title> shiftedList = new ArrayList<Title>(); 
		
		String line = s.trim().toLowerCase();
		String shiftedLine = line + " ";
		
		String[] words = line.split(" ");
		for (int i = 0; i < words.length; i ++){
			if (!wordsToIgnore.containsKey(words[i])){
				char upperCase= (char) (shiftedLine.charAt(0) - 32);
				shiftedLine = upperCase + shiftedLine.substring(1);
				Title title = new Title(shiftedLine, indexOfThisLine);
				// return to lower case!!!
				shiftedList.add(title);
			}
			int wordLength = words[i].length();
			shiftedLine = shiftedLine.substring(wordLength + 1) + words[i] + " "; 
			 
		}
		
		Sorter.sortAfterAdding(shiftedList);
		
	}

	  
}
