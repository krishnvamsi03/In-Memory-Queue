import java.util.LinkedList;
import java.util.Queue;

public class Subscriber {
    String id, name;
    public Queue<Message> messageQueue;
    public Thread subscriberThread = null;

    public Subscriber(String id, String name) {
        this.id = id;
        this.name = name;
        this.messageQueue = new LinkedList<>();
    }

    public void subscribeTopic(Topic topic) {
        topic.subscriberList.add(this);
    }

    public void acceptMessage(Message<?> message) {
        this.messageQueue.offer(message);
    }

    public synchronized void listenTopics() {
        if (this.subscriberThread == null) {
            this.subscriberThread = new Thread(new ListenerThread(this));
            this.subscriberThread.start();
        }
    }
}
