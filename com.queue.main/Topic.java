import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topic {
    final int topicSize;
    String topicName;
    public Queue<Message> topicQueue;
    public List<Subscriber> subscriberList;
    public Thread broadcasterThread = null;

    public Topic(String topicName) {
        this.topicSize = 5;
        this.topicName = topicName;
        this.topicQueue = new LinkedList<>();
        this.subscriberList = new LinkedList<>();
    }

    public void addMessage(Message<?> message) throws Exception {
        if (this.topicSize == topicQueue.size()) {
            throw new Exception("topic already full");
        }
        this.topicQueue.offer(message);
    }

    public synchronized void broadCastMessage() {
        if (this.broadcasterThread == null) {
            this.broadcasterThread = new Thread(new BroadcastThread(this));
            this.broadcasterThread.start();
        }
    }
}
