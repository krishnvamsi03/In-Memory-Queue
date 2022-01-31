package com.queue.actors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.queue.topic.MainTopic;
import com.queue.topic.Topic;

public class Publisher {
	String pubId;
	
	public Publisher(String name) {
		this.pubId = generateId() + "-" + name;
	}
	
	public <T> void publishMessage(T message, String topicName) {
		Topic topic = MainTopic.getTopic(topicName);
		if (topic != null) {
			try {
				topic.addToTopic(message);
				System.out.println("Message published successfully to the topic by " + this.pubId);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("topic with name " + topicName + " does not exists or it has been delete");
		}
	}
	
	private String generateId() {
		DateFormat dform = new SimpleDateFormat("ddMMyy-HHmmss-SSS");
		Date obj = new Date();
		return dform.format(obj).toString();
	}
}
