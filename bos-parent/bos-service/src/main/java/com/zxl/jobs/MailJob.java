package com.zxl.jobs;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.zxl.bos.dao.IWorkbillDao;
import com.zxl.bos.domain.Workbill;

/**
 * 发送邮件的作业
 * @author ZXL
 *
 */
public class MailJob {
	@Resource
	private IWorkbillDao workbillDao;

	private String username;//发件人的邮箱账号
	private String password;//密码
	private String smtpServer;//服务器

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void execute() {
		System.out.println("要发邮件了。。。");
		try {
			//查询工单类型为新单的所有工单
			List<Workbill> list = workbillDao.findAll();
			if(null != list && list.size() > 0){
				final Properties mailProps = new Properties();
				mailProps.put("mail.smtp.host", this.getSmtpServer());
				mailProps.put("mail.smtp.auth", "true");
				mailProps.put("mail.username", this.getUsername());
				mailProps.put("mail.password", this.getPassword());

				// 构建授权信息，用于进行SMTP进行身份验证
				Authenticator authenticator = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						// 用户名、密码
						String userName = mailProps.getProperty("mail.username");
						String password = mailProps.getProperty("mail.password");
						return new PasswordAuthentication(userName, password);
					}
				};
				// 使用环境属性和授权信息，创建邮件会话
				Session mailSession = Session.getInstance(mailProps, authenticator);
				for(Workbill workbill : list){
					// 创建邮件消息
					MimeMessage message = new MimeMessage(mailSession);
					// 设置发件人
					InternetAddress from = new InternetAddress(mailProps.getProperty("mail.username"));
					message.setFrom(from);
					// 设置收件人
					InternetAddress to = new InternetAddress("bb@zxl.com");
					message.setRecipient(RecipientType.TO, to);
					// 设置邮件标题
					message.setSubject("系统邮件：新单通知");
					// 设置邮件的内容体
					message.setContent(workbill.toString(), "text/html;charset=UTF-8");
					// 发送邮件
					Transport.send(message);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}
}
