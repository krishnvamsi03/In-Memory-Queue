public class Message<T> {
    T message;

    public Message(T message) {
        this.message = message;
    }

    public void readMessage() {
        System.out.println(this.message.toString());
    }
}
