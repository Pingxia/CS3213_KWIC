package storage;

import java.util.ArrayList;
import java.util.HashMap;

import ui.MainUI;

public class Data implements IData {

	 private static Data instance = null;
	   public Data() {
	      // Exists only to defeat instantiation.
	   }
	   public static Data getInstance() {
	      if(instance == null) {
	         instance = new Data();
	      }
	      return instance;
	   }
	   
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

	@Override							
	public ArrayList<String> getSortedList() {
		// TODO Auto-generated method stub
		return sortedList;
	}
	
	public ArrayList<String> getStopWords() {
		// TODO Auto-generated method stub
		return stopWords;
	}
	
	public void flushSortedList() {
		// TODO Auto-generated method stub
		MainUI.writeOutputToFile(sortedList);
		sortedList.clear();
		nextIndex = 0;
	}
	
	private ArrayList<String> stopWords = new ArrayList<String>();
	private HashMap<String, Integer> titleMap = new HashMap<String, Integer>();
	private ArrayList<String> sortedList = new ArrayList<String>();
	private int nextIndex = 0;
	

}
