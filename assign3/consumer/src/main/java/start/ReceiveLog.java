package start;

import com.rabbitmq.client.*;
import service.MailService;
import service.TxtService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReceiveLog {
    private static final String TASK_QUEUE_NAME = "task_queue";

    private static List<String> mailingList;

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);String queueName = channel.queueDeclare().getQueue();

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
    }

    private static void doWork(String task) {
        MailService mailService = new MailService("ngyimolanagy@gmail.com","Imola1997");
        TxtService txtService = new TxtService();
        mailingList = new ArrayList<String>();
        mailingList.add("ngyimolanagy@gmail.com");
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                for (String subscriber: mailingList) {
                    mailService.sendMail(subscriber,"Notification from DVD store",task);
                    try {
                        txtService.write(task);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}