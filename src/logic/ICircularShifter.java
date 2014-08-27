package logic;

import java.util.ArrayList;
import java.util.HashMap;

import storage.Title;

public interface ICircularShifter {
	public ArrayList<Title> computeCircularShifts(HashMap<String, Integer> wordsToIgnore, String s, int indexOfThisLine);
}
