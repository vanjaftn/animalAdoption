package service

import javax.inject.Inject
import play.api.libs.mailer.{Email, MailerClient}

class EmailService @Inject()(mailerClient: MailerClient) {

  def sendEmail(to: String, subject: String, bodyText: String): Unit = {
    val email = Email(
      subject = subject,
      from = "animaladoption.sabac@gmail.com",
      to = Seq(to),
      bodyText = Some(bodyText)
    )

    mailerClient.send(email)
  }
}
