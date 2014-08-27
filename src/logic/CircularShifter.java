package logic;

import java.util.ArrayList;
import java.util.HashMap;


import storage.Title;

public class CircularShifter implements ICircularShifter {

	public ArrayList<Title> computeCircularShifts( 
			HashMap<String, Integer> wordsToIgnore, String s, int indexOfThisLine) {
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
				char lowerCase= (char) (shiftedLine.charAt(0) + 32);
				shiftedLine = lowerCase + shiftedLine.substring(1);
				shiftedList.add(title);
			}
			int wordLength = words[i].length();
			shiftedLine = shiftedLine.substring(wordLength + 1) + words[i] + " "; 
			 
		}
		
		return shiftedList;
		
	}

	

	  
}
