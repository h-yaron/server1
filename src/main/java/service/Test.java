package service;

import data.FractionMessageType;
import data.IntMessageType;
import data.Message;
import data.StringMessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.Listener1;

@Component
public class Test {

    Listener1 listener1;

    @Autowired
    public Test(Listener1 listener1,
                IntMessageType intMessageType,
                StringMessageType stringMessageType,
                FractionMessageType fractionMessageType) {
        this.listener1 = listener1;

        Message message1 = new Message();
        message1.setType(IntMessageType.TYPE_NAME);
        message1.setData("2");

        Message message2 = new Message();
        message2.setType(StringMessageType.TYPE_NAME);
        message2.setData("\"2\"");

        Message message3 = new Message();
        message3.setType(FractionMessageType.TYPE_NAME);
        message3.setData("\"4/2\"");

        Thread thread1 = new Thread(() -> {
            for (int i = 0 ; i < 1000; i++) {
                listener1.accept(message1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0 ; i < 1000; i++) {
                listener1.accept(message2);
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0 ; i < 1000; i++) {
                listener1.accept(message3);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
