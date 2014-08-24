package storage;

import java.util.ArrayList;
import java.util.HashMap;

public class Data implements IData {

	@Override
	public void addWordsToIgnore(String s) {
		// TODO Auto-generated method stub
		stopWords.add(s);
	}

	@Override
	public void addTitles(String s) {
		// TODO Auto-generated method stub
		titleMap.put(s, nextIndex);
		nextIndex++;
	}

	@Override
	public int getIndex(String s) {
		// TODO Auto-generated method stub
		return titleMap.get(s);
	}

	@Override									// What is this for???
	public ArrayList<String> getSortedList() {
		// TODO Auto-generated method stub
//		return Sorter.sort();
		return null;
	}
	
	private ArrayList<String> stopWords = new ArrayList<String>();
	private HashMap<String, Integer> titleMap = new HashMap<String, Integer>(); 
	private int nextIndex = 0;

}
