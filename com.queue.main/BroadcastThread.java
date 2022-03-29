public class BroadcastThread implements Runnable {

    Topic topic;

    public BroadcastThread(Topic topic) {
        this.topic = topic;
    }

    @Override
    public void run() {
        while (true) {
            while (this.topic.topicQueue.size() > 0) {
                Message<?> message = this.topic.topicQueue.poll();
                for (Subscriber sub : this.topic.subscriberList) {
                    sub.acceptMessage(message);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
