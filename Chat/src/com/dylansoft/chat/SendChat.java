package com.dylansoft.chat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dylansoft.messages.Message;
import com.dylansoft.messages.UpdatedMessages;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class SendChat
 */
@WebServlet("/SendChat")
public class SendChat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendChat() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		PrintWriter out = response.getWriter();
		out.print("OK");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		System.out.println("JSON object: " + json);
		// 2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		// 3. Convert received JSON to Article
		Message message = mapper.readValue(json, Message.class);
		// 4. Set response type to JSON
		response.setContentType("application/json");
		System.out.println(message);
		// 5. Add article to List<Article>

		// articles.add(article);

		// 6. Send List<Article> as JSON to client

		// mapper.writeValue(response.getOutputStream(), articles);

		Date currentTime = new Date();
		MainData mainData = MainData.getInstance();
		String timeStamp = String.format(" - %tr", currentTime);
		String messageText = message.text + timeStamp;
		mainData.addMessage(messageText);

		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		UpdatedMessages updatedMessages = new UpdatedMessages();
		updatedMessages.messages = mainData.getNewMessages(message.messageCount);
		updatedMessages.totalMessageCount = mainData.getTotalMessageCount();

		mapper.writeValue(response.getOutputStream(), updatedMessages);
		mapper.writeValue(System.out, updatedMessages);

	}
}
