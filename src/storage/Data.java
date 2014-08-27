package storage;

import java.util.ArrayList;
import java.util.HashMap;

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
	public void addWordsToIgnore(ArrayList<String> wordsToIgnoreToAdd) {

		for (String s : wordsToIgnoreToAdd){
			wordsToIgnore.put(s, 1);		// put every new stopwords into hashMap
		}									
		flushSortedList();					// flush the output to process again
	}

	@Override
	public void addTitles(ArrayList<String> list) {
		
		titlesToAdd = list; 
		for (String s : titlesToAdd){
			titleMap.put(s, nextIndex);
			nextIndex++;
		}
	}

	@Override
	public void deleteWordsToIgnore(ArrayList<String> wordsToIgnoreToDelete) {
		
		for (String s : wordsToIgnoreToDelete){
			wordsToIgnore.remove(s);		// delete target stopwords from hashMap	
		}									
		flushSortedList();					// flush the output to process again
	}
	
	@Override
	public void deleteTitles(ArrayList<String> list) {

		titlesToDelete = list;
		for (String s : titlesToDelete){
			titleMap.remove(s);
		}
	}
	
	@Override
	public HashMap<String, Integer> getWordsToIgnore() {

		return wordsToIgnore;
	}
	
	@Override
	public ArrayList<String> getTitlesToAdd() {

		return titlesToAdd;
	}
	@Override
	public ArrayList<String> getTitlesToDelete() {

		return titlesToDelete;
	}
	
	@Override
	public int getIndex(String s) {

		return titleMap.get(s);
	}
	
	@Override							
	public ArrayList<String> getSortedList() {

		return sortedList;
	}
	
	@Override
	public void setSortedList(ArrayList<String> list) {

		sortedList = list;
	}
	
	private void flushSortedList() {

//		MainUI.writeOutputToFile(sortedList);
		sortedList.clear();
		nextIndex = 0;
	}
	
	private HashMap<String, Integer> wordsToIgnore = new HashMap<String, Integer>();
	private HashMap<String, Integer> titleMap = new HashMap<String, Integer>();
	private ArrayList<String> sortedList = new ArrayList<String>();
	private int nextIndex = 0;
	private ArrayList<String> titlesToAdd = new ArrayList<String>();
	private ArrayList<String> titlesToDelete = new ArrayList<String>();
	
}
