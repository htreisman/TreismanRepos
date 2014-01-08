package com.dylansoft.chat;
import java.util.List;
import java.util.Vector;


public class MainData {
	private static final MainData INSTANCE = new MainData();
	 
    private MainData() {}
 
    public static MainData getInstance() {
        return INSTANCE;
    }
    public Vector<String> chatVector = new Vector<String>();
    
    public Vector<String> getNewMessages(int mostRecent) {
    	int totalMessages = chatVector.size();
    	List<String> sublist = chatVector.subList(mostRecent, totalMessages);
    	return new Vector<String>(sublist);
    	
    }
    public void addMessage(String message) {
    	chatVector.add(message);
    }
    public int getTotalMessageCount() {
    	return chatVector.size();
    }
}
