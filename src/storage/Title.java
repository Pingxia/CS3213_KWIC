package storage;

public class Title {
	
	public Title(String str, int i){
		line = str;
		index = i;
	}
	
	private void setLine(String str){
		line = str;
	}
	
	private void setIndex(int i){
		index = i;
	} 
	
	private String getLine(){
		return line;
	}
	
	private int getIndex(){
		return index;
	}
	
	private int index;
	private String line;
}
