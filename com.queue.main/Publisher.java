public class Publisher {
    String id, name;
    public Publisher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void publishMessage(Topic topic, Message<?> message) throws Exception {
        topic.addMessage(message);
    }
}
