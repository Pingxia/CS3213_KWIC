package logic;

import storage.Data;

public class Manager implements IManager {

	@Override
	public void processLine(String cmd, String s) {
		// TODO Auto-generated method stub
		
		Data data = new Data();
		int indexOfThisLine = data.getIndex(s);
		
		switch (cmd){
			case "add":
				CircularShifter.process(data.getWordsToIgnore(),  s, indexOfThisLine);
				break;
			case "delete":
				int indexToBeDeleted = data.getIndex(s); 
				Sorter.deleteByIndex(indexToBeDeleted);
				break;
			case "flush":
				data.flushSortedList();
				break;
			default:
				break;
		}
	}


}
