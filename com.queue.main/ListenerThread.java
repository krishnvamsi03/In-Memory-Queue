public class ListenerThread implements Runnable {

    Subscriber sub;

    public ListenerThread(Subscriber sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        while (true) {
            while (this.sub.messageQueue.size() > 0) {
                Message<?> message = this.sub.messageQueue.poll();
                if (message != null) {
                    message.readMessage();
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
