package service;

import data.Message;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class QueueService {

    private ConcurrentLinkedQueue<Message> queue = new ConcurrentLinkedQueue<Message>();
    private QueueListener listener;

    public QueueService() {
        listener = new QueueListener(this);
    }

    public void accept(Message message) {
        queue.add(message);
    }

    public Message getMessage() {
        return queue.poll();
    }
}
