package com.dylansoft.tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.dylansoft.chat.MainData;

public class ChatTest {

	@Test
	public void testGetNewMessages() {
		MainData mainData = MainData.getInstance();
		mainData.addMessage("Message1 From Red");
		mainData.addMessage("Message1 From Green");
		mainData.addMessage("Message2 From Red");
		mainData.addMessage("Message2 From Green");

		Vector<String> updatedMessages = mainData.getNewMessages(2);
		assertEquals("Vector is wrong size", 2, updatedMessages.size());
		assertEquals("First message should be from Red","Message2 From Red", updatedMessages.get(0) ); 
		System.out.println(updatedMessages);
	}

}
