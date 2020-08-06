package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class QueueListener {

    private QueueService queueService;

    public QueueListener(QueueService queueService) {
        this.queueService = queueService;

        Thread thread = new Thread(new QueueRunner(queueService));
        thread.start();
    }
}
