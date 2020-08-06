package web;

import data.Message;
import data.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.QueueService;

@RestController
public class Listener1 {

    QueueService queueService;

    @Autowired
    public Listener1(QueueService queueService) {
        this.queueService = queueService;
    }

    @PostMapping("/message")
    public void accept(@RequestBody Message message) {
        MessageType type = MessageType.get(message.getType());

        type.verify(message.getData());

        queueService.accept(message);
    }
}
