package fr.istic.date.topic;

import java.util.Date;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class EnvoyerDate {

  private static final String EXCHANGE_NAME = "date_topic";

  private static String getDate() {
	    return (new Date()).toString();
  }
  
  @SuppressWarnings("deprecation")
  private static String getDateGMT() {
	  return (new Date()).toGMTString();
  }
  
  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setUri("amqp://mri:64GbL3k7uc33QCtc@localhost:8082/mri");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, "topic");

    String date = getDate();
    String dateGMT = getDateGMT();
    channel.basicPublish(EXCHANGE_NAME, "date.local", null, date.getBytes("UTF-8"));
    channel.basicPublish(EXCHANGE_NAME, "date.gmt", null, dateGMT.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + date + "'");

    channel.close();
    connection.close();
  }

}

