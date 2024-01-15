package service
import com.nexmo.client.NexmoClient
import com.nexmo.client.sms.messages.TextMessage

class SMSService {

  def sendSms(to: String, message: String): Unit = {

    val nexmoClient = new NexmoClient.Builder()
      .apiKey("02613a13")
      .apiSecret("q1IQosviAGuZaSPy")
      .build()

    val response = nexmoClient.getSmsClient
      .submitMessage(new TextMessage("Vonage APIs", to, message))

    println(s"SMS sent with message via Scala")
  }
}
