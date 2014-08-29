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
		deleteTitles = data.getTitlesToDelete();
		addTitles = data.getTitlesToAdd();
		
		if (!data.checkIfWordsToIgnoreChanged()){
			if (!addTitles.isEmpty()){
				addTitlesToShift();
			}
			if (!deleteTitles.isEmpty() ){
				deleteTitlesDirectlyFromOutput();
			}
		}
		else{
			renewTitles();
			addTitlesToShift();
		}
		data.resetIgnoreChecker();
		
		if (listAfterDeletion != null){
			data.setSortedList(sortedList);
			listAfterDeletion = null;
		}
		else{
			data.setSortedList(returnList);
			returnList = null;
		}
			
	}
	
	private void renewTitles() {
		// TODO Auto-generated method stub
		if (!titles.isEmpty()){
			addTitles.clear();
			for (String line : titles.keySet()) {
				addTitles.add(line);
			}
		}	
	}

	private void addTitlesToShift() {
		// TODO Auto-generated method stub
		listToBeSorted.clear();
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
		listAfterDeletion = new ArrayList<Title>();
		boolean matchFlag;
		
		for (Title title: sortedList){
			matchFlag = false;
			int titleIndex = title.getIndex();
			for (String line : deleteTitles){
				if (titles.get(line).intValue() == titleIndex){
					matchFlag = true;
				}
			}
			if (!matchFlag){
				listAfterDeletion.add(title);
			} 
		}
		sortedList = listAfterDeletion;
		Data.getInstance().deleteTitlesFromInput();
	}
	
	private ArrayList<String> addTitles;
	private ArrayList<String> deleteTitles;
	private HashMap<String, Integer> titles;
	private HashMap<String, Integer> wordsToIgnore; 
	private ArrayList<Title> shiftedList;
	private ArrayList<Title> listToBeSorted = new ArrayList<Title>();
	private ArrayList<Title> sortedList;
	private ArrayList<Title> returnList;
	private ArrayList<Title> listAfterDeletion;
}
