public class Main {
    public static void main(String[] args) throws Exception {
        DQueue queue = new DQueue("Memory Queue");
        Topic topic1 = new Topic("Sports topic");
        Topic topic2 = new Topic("Cinema topic");
        queue.addTopic(topic1);
        queue.addTopic(topic2);
        topic1.broadCastMessage();
        topic2.broadCastMessage();

        Message<String> message = new Message<>("Message in topic 1");
        Message<String> message2 = new Message<>("Message in topic 2");

        Publisher pub = new Publisher("123", "pub 1");
        Subscriber sub = new Subscriber("123", "sub 1");

        sub.subscribeTopic(topic1);
        sub.subscribeTopic(topic2);

        pub.publishMessage(topic1, message);
        pub.publishMessage(topic2, message2);
        sub.listenTopics();

        for (int i = 0; i < 3; i++) {
            Message<String> newMessage = new Message<>(String.valueOf(i + 1) + " Message in topic 1");
            Message<String> newMessage1 = new Message<>(String.valueOf(i + 1) + " Message in topic 2");
            pub.publishMessage(topic1, newMessage);
            pub.publishMessage(topic2, newMessage1);
        }
    }
}