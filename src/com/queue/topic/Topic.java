package com.queue.topic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Topic {
	public String name;
	public final static int size = 1000;
	public final static int messageLength = 120;
	public Queue<Message<?>> queue = null;
	public static HashMap<String, Topic> map = new HashMap<>();
	public Topic(String name) {
		this.name = name;
		this.queue = new LinkedList<>();
	}
	
	public abstract boolean isTopicFull();
	public abstract int getCurrSize();
	public abstract <M> void addToTopic(M message) throws Exception;
	public abstract Message<?> removeToTopic();
}
