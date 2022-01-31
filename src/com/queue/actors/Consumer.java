package com.queue.actors;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.queue.topic.MainTopic;
import com.queue.topic.Message;
import com.queue.topic.Topic;

class Listen implements Runnable {

	String listeningConId;
	MainTopic topic;
	
	public Listen(String id, Topic topic2) {
		this.listeningConId = id;
		this.topic = (MainTopic) topic2;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			while (this.topic.getCurrSize() > 0) {
				Message<?> m = this.topic.removeToTopic();
				if (m != null) {
					synchronized(Listen.class) {
						if (m != null) {
							m.printMessage(this.listeningConId);
							m = null;
						}
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class Consumer {
	String conId;
	List<MainTopic> topics;
	
	public Consumer(String name) {
		this.conId = generateId() + "-" + name;
		this.topics = new ArrayList<>();
	}
	
	public void listenToTopic(String name) {
		Topic topic = MainTopic.getTopic(name);
		if (topic != null) {
			Thread t1 = new Thread(new Listen(this.conId, topic));
			t1.start();
			System.out.println("Consumer " + this.conId + " Started listening to topic " + topic.name + " with thread " + t1.getName());
		} else {
			//System.out.println("topic with name " + name + " does not exists or it has been delete");
		}
	}
	
	private String generateId() {
		DateFormat dform = new SimpleDateFormat("ddMMyy-HHmmss-SSS");
		Date obj = new Date();
		return dform.format(obj).toString();
	}
}
