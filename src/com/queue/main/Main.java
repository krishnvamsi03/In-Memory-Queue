package com.queue.main;

import com.queue.actors.Consumer;
import com.queue.actors.Publisher;
import com.queue.topic.MainTopic;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainTopic topic1 = new MainTopic("topic1");
		MainTopic topic2 = new MainTopic("topic2");
		
		Publisher pub1 = new Publisher("pub1");
		Publisher pub2 = new Publisher("pub2");
		
		Consumer con1 = new Consumer("con1");
		Consumer con2 = new Consumer("con2");
		Consumer con3 = new Consumer("con3");
		Consumer con4 = new Consumer("con4");
		Consumer con5 = new Consumer("con5");
		
		con1.listenToTopic(topic1.name);
		con2.listenToTopic(topic1.name);
		con3.listenToTopic(topic1.name);
		con4.listenToTopic(topic1.name);
		con5.listenToTopic(topic1.name);
		
		con1.listenToTopic(topic2.name);
		con3.listenToTopic(topic2.name);
		con5.listenToTopic(topic2.name);
		
		
		pub1.publishMessage("Message 1", topic1.name);
		pub1.publishMessage("Message 2", topic1.name);
		pub2.publishMessage("Message 3", topic1.name);
		pub1.publishMessage("Message 4", topic2.name);
		pub2.publishMessage("Message 5", topic2.name);
		for (int i = 0; i < 100; i++) {
			pub1.publishMessage("Message " + String.valueOf(i + 1 + 5), topic1.name);
			pub1.publishMessage("Message " + String.valueOf(i + 1 + 6), topic1.name);
			pub2.publishMessage("Message " + String.valueOf(i + 1 + 7), topic1.name);
			pub1.publishMessage("Message " + String.valueOf(i + 1 + 8), topic2.name);
			pub2.publishMessage("Message " + String.valueOf(i + 1 + 9), topic2.name);
		}
	}

}
