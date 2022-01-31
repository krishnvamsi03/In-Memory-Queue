package com.queue.topic;

import java.util.HashMap;

public class MainTopic extends Topic implements Runnable {
	
	public MainTopic(String name) {
		super(name);
		map.putIfAbsent(name, this);
	}

	@Override
	public boolean isTopicFull() {
		// TODO Auto-generated method stub
		return size == this.queue.size();
	}

	@Override
	public int getCurrSize() {
		// TODO Auto-generated method stub
		return this.queue.size();
	}

	@Override
	public <M> void addToTopic(M message) throws Exception {
		// TODO Auto-generated method stub
		if (this.queue.size() < size) {
			Message<M> msg = new Message<>(message);
			this.queue.add(msg);
		} else {
			throw new Exception("cannot add new messages to topic, topic already full");
		}
		
	}

	@Override
	public Message<?> removeToTopic() {
		// TODO Auto-generated method stub
		synchronized(this.queue) {
			if (this.queue.size() > 0) {
				return this.queue.remove();
			}
			return null;
		}
	}
	
	public static Topic getTopic(String name) {
		return map.getOrDefault(name, null);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		while (true) {
//			while (this.getCurrSize() > 0) {
//				Message<?> m = this.removeToTopic();
//				m.printMessage();
//				m = null;
//			}
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	
}
