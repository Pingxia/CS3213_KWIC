package logic;

import java.util.ArrayList;
import java.util.HashMap;
import storage.Data;
import storage.Title;

public class Manager implements IManager {
	
	@Override
	public void run() {
		
		Data data = Data.getInstance();
		titles = data.getTitles();	
		wordsToIgnore = data.getWordsToIgnore();
		sortedList = data.getSortedList();
		
		if (!data.checkIfWordsToIgnoreChanged()){
			deleteTitles = data.getTitlesToDelete();
			if (!deleteTitles.isEmpty() ){
				deleteTitlesDirectlyFromOutput();
			}
			addTitles = data.getTitlesToAdd();
			if (!addTitles.isEmpty()){
				addTitlesToShift();
			}
		}
		else{
			renewTitles();
			addTitlesToShift();
		}
		
		if (returnList!= null){
			data.setSortedList(returnList);
		}
		else{
			data.setSortedList(sortedList);
		}
			
	}
	
	private void renewTitles() {
		// TODO Auto-generated method stub
		for (String line : titles.keySet()) {
		    addTitles.add(line);
		}
	}

	private void addTitlesToShift() {
		// TODO Auto-generated method stub
		for (String s: addTitles){
			int indexOfThisLine = titles.get(s); 
			CircularShifter cs = new CircularShifter();
			shiftedList = cs.computeCircularShifts(wordsToIgnore,  s, indexOfThisLine);
			listToBeSorted.addAll(shiftedList);
		}
		Sorter sorter = new Sorter();
		returnList = sorter.sort(listToBeSorted, sortedList);
	}

	private void deleteTitlesDirectlyFromOutput() {
		for (String line : deleteTitles){
			int deleteIndex = titles.get(line);
			
			for (Title title: sortedList){
				if (title.getIndex() == deleteIndex){
					sortedList.remove(title);
				}
			}
		}
	}
	
	private ArrayList<String> addTitles;
	private ArrayList<String> deleteTitles;
	private HashMap<String, Integer> titles;
	private HashMap<String, Integer> wordsToIgnore; 
	private ArrayList<Title> shiftedList;
	private ArrayList<Title> listToBeSorted = new ArrayList<Title>();
	private ArrayList<Title> sortedList;
	private ArrayList<Title> returnList;
	
}
