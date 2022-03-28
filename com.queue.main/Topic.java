import java.util.LinkedList;
import java.util.Queue;

public class Topic {
    final int topicSize;
    String topicName;
    private Queue<Message> topicQueue;

    public Topic(String topicName) {
        this.topicSize = 5;
        this.topicName = topicName;
        this.topicQueue = new LinkedList<>();
    }

    public <T> void addMessage(Message<T> message) throws Exception {
        if (this.topicSize == topicQueue.size()) {
            throw new Exception("topic already full");
        }
        this.topicQueue.offer(message);
    }
}
