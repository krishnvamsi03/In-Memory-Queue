package com.queue.topic;

public class Message <M> {
	M messageContent;
	public Message(M message) {
		this.messageContent = message;
	}
	
	public void printMessage(String conId) {
		System.out.println(conId + " received " + this.messageContent);
	}
	
	public int getMessageLength() {
		return this.messageContent.toString().length();
	}
}
