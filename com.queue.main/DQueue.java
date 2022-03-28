import java.util.LinkedList;
import java.util.List;

public class DQueue {
    String name;
    final int maxTopics;
    List<Topic> topics;

    public DQueue(String name) {
        this.maxTopics = 5;
        this.name = name;
        this.topics = new LinkedList<>();
    }

    public void addTopic(Topic topic) throws Exception {
        if (this.topics.size() == this.maxTopics) {
            throw new Exception("Queue full");
        }
        this.topics.add(topic);
    }

    public void removeTopic(Topic topic) throws Exception {
        try {
            this.topics.remove(topic);
        } catch (Exception e) {
            throw new Exception("given topic not present");
        }
    }
}