package logic;

import java.util.ArrayList;

import storage.Data;

public class Manager implements IManager {

	@Override
	public void processLine(String cmd, String s) {
		// TODO Auto-generated method stub
		
		Data data = new Data();
		
		switch (cmd){
			case "add":
				CircularShifter.process(data.getStopWords(),  s);
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

	@Override
	public ArrayList<String> execute() {
		// TODO Auto-generated method stub
		return null;
	}

}
