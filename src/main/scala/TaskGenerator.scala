package ardlema.rabbitmqtaskgenerator

import com.rabbitmq.client.{MessageProperties, ConnectionFactory}

object TaskGenerator {

  def main(args: Array[String]) {
    val queueName = "taskQueue"
    val factory = new ConnectionFactory()
    factory.setHost("localhost")
    val connection = factory.newConnection()
    val channel = connection.createChannel()

    channel.queueDeclare(queueName, true, false, false, null)

    val message = getMessage(args)

    channel.basicPublish( "", queueName,
    MessageProperties.PERSISTENT_TEXT_PLAIN,
      message.getBytes())
    println(" [x] Sent '" + message + "'")

    channel.close();
    connection.close()
  }

  def getMessage(args: Array[String]) = {
    if (args.length < 1)
      "Hello World!"
    else args(0)
  }


}
