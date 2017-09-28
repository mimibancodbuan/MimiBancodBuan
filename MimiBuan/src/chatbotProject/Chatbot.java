package chatbotProject;

public class Chatbot {
	
	private String userName;
	private Topic mimi;
	private boolean chatting;
	
	public void Chatbot() {
		mimi = new ChatbotMimi;
		userName = "unknown user";
		chatting = true;
	}

	public void startTalking() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName = ChatbotMain.getInput();
		
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			String response = ChatbotMain.getInput();
			
			if(mimi.isTriggered(response)) {
				chatting  = false;
				mimi.startChatting;
			}
			else
				ChatbotMain.print("I'm sorry. I don't understand.");
		}
	}

}
