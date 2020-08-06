package service;

import data.Message;
import org.springframework.web.client.RestTemplate;

public class QueueRunner implements Runnable {

    private QueueService queueService;

    public QueueRunner(QueueService queueService) {
        this.queueService = queueService;
    }

    @Override
    public void run() {
        while(true) {
            Message message = queueService.getMessage();
            if (message == null) {
                try {
                    Thread.sleep(1000);
                    System.out.println("No Messages");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                sendMessage(message);
            }
        }
    }

    private void sendMessage(Message message) {
        try {
            System.out.println("Sending message type: " + message.getType() + ", data: " + message.getData());

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.postForLocation("http://localhost:8081//message", message);
        } catch (RuntimeException er) {
            er.printStackTrace();
        }
    }
}
