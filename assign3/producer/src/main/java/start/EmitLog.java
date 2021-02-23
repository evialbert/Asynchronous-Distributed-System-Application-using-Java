package start;

import com.rabbitmq.client.*;

public class EmitLog {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public String emitMessage(String message) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

        channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
        String reply = " [x] Sent '" + message + "'";
        System.out.println(reply);

        channel.close();
        connection.close();

        return reply;
    }
}