package group.yf.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * @author Yang Fei
 *
 */
public class MailUtil {

	public static void sendMail(String toUser, String code) throws Exception {
		// 1.创建连接对象，连接到邮箱服务器
		Properties props = new Properties();
		// 初始化props
		props.put("mail.host", "smtp.evanyang.top");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("master@evanyang.top‍", "wahaha@123");
			}
		});
		// 2.创建邮件对象
		Message message = new MimeMessage(session);
		// 2.1设置发件人
		message.setFrom(new InternetAddress("master@evanyang.top"));
		// 2.2设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(toUser));
		// 2.3设置主题
		message.setSubject("官方正式");
		// 2.4设置邮件的正文
		message.setContent("<h1>激活邮件</h1><h3><a href='www.baidu.com'>www.baidu.com?code=" + code + "</h3>",
				"text/html;charset=UTF-8");
		// 3.发送邮件
		Transport.send(message);

	}
}
