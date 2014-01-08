package com.dylansoft.messages;
import java.util.Date;

public class Message {
	public String text;
	public Date timestamp;
	public int messageCount;
	@Override
	public String toString() {
		return "Message [text=" + text + ", timestamp=" + timestamp
				+ ", messageCount=" + messageCount + "]";
	}
}
