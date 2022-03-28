public class Main {
    public static void main(String[] args) throws Exception {
        DQueue queue = new DQueue("Memory Queue");
        Topic topic1 = new Topic("Sports topic");
        Topic topic2 = new Topic("Cinema topic");
        queue.addTopic(topic1);
        queue.addTopic(topic2);
        Message<String> message = new Message<>("Hello World");
        Message<Integer> message2 = new Message<>(23);
        topic1.addMessage(message);
        topic2.addMessage(message2);
        message.readMessage();
        message2.readMessage();
    }
}