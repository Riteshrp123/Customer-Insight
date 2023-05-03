package com.xworkz.customerinsigt.service;

import java.time.LocalTime;
import java.util.Properties;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.customerinsigt.dao.CustomerInsightDao;
import com.xworkz.customerinsigt.dto.AccountStatus;
import com.xworkz.customerinsigt.dto.CustomerInsightDto;
import com.xworkz.customerinsigt.entity.CustomerInsightEntity;
import com.xworkz.customerinsigt.util.Encryption;

@Service
public class CustomerInsightServiceImpl implements CustomerInsightService {

	@Autowired
	private CustomerInsightDao dao;

	@Override
	public boolean save(CustomerInsightDto dto, Model model) {
		if (dto != null) {
			if (dto.getPassword().equals(dto.getConfirmPassword())) {

				ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
				Validator validator = validatorFactory.getValidator();
				Set<ConstraintViolation<CustomerInsightDto>> validater = validator.validate(dto);

				if (validater != null) {
                   
					CustomerInsightEntity foundEntity = findByEmail(dto.getEmail());
					System.out.println("findByEmail");
					System.out.println(foundEntity);
					System.out.println(foundEntity != null);

					if (foundEntity == null) {
						System.out.println("email is not there");
						model.addAttribute("email", "email is not exist");
						System.out.println("Account is created");
						model.addAttribute("email", "you can create your account");
						CustomerInsightEntity entity = new CustomerInsightEntity();
						BeanUtils.copyProperties(dto, entity);
						entity.setCreatedBy(dto.getFirstName());
//						entity.setCreatedOn(LocalTime.now());
//						entity.setAcc_status(AccountStatus.UNBLOCKED.getValue());)
//						System.out.println(dto);
						entity.setCreatedOn(LocalTime.now());
						entity.setAcc_status(AccountStatus.UNBLOCKED.getValue());
						entity.setPassword(Encryption.encrypt(entity.getPassword()));
						sendMail(entity.getEmail(), entity);
//						sendOtpByEmail(0, entity.getEmail());
						System.out.println(dto);
						System.out.println("entity is running");
						System.out.println(entity);
						boolean result = dao.save(entity);

					} else {
						System.out.println("email is there");
						model.addAttribute("email", "email already exits");
						System.out.println("Account is not create");
						model.addAttribute("Account", "you have to check email first");

					}

				} else {
					model.addAttribute("email", "email is not valid");
				}

			}
		}
		return false;
	}

	@Override
	public CustomerInsightEntity findByEmail(String email) {
		System.out.println("email is varifier");
		System.out.println(email);
		if (email != null) {
			CustomerInsightEntity entity = dao.findByEmail(email);
			System.out.println("entity is there");
			System.out.println(entity);
			return entity;
		}
		return null;

	}

	@Override
	public CustomerInsightEntity findByEmailAndPassword(String email, String password, Model model) {
		System.out.println("email is valid " + email);
		System.out.println("password is valid" + password);
		if (email != null && password != null) {
			CustomerInsightEntity entity = dao.findByEmail(email);
			System.out.println("email and password is there");
//			if(entity.getPassword().equals(dto.getPassword()) && entity.getEmail().equals(dto.getEmail())){
			System.out.println(entity);
			if (entity != null) {
//				if(entity.getPassword().equals(dto.getPassword()) && entity.getEmail().equals(dto.getEmail())){

				int count = entity.getWrongPasswordCount();
//				count++;
				System.out.println(count);

				entity.setWrongPasswordCount(count);
				System.out.println(password);
				if (entity.getPassword().equals(Encryption.encrypt(password))) {
//					findByEmailAndPassword(email,Encryption.encrypt(entity.getPassword()), model);
					System.out.println(password);
					System.out.println("login Successfully");
					model.addAttribute("logInSuccess", "Successfully logedIn");
					if (count > 0) {
						updateByWrongPasswordCount(email, 0);
						updateAccountStatusByEmail(AccountStatus.UNBLOCKED.getValue(), email);
					}
					return entity;

				} else {
					count = 0;
					CustomerInsightEntity findByEmail = dao.findByEmail(email);
					if (findByEmail != null) {
						count = findByEmail.getWrongPasswordCount();

					}
//							System.out.println("login failed");
//							model.addAttribute("loginfailed", "Email id and password mismatch");

					if (count < 2) {
						count++;
						model.addAttribute("password", "check the account ++" + count);
						boolean res = updateByWrongPasswordCount(entity.getEmail(), count);
						System.out.println("invalid credentials " + (3 - count) + "left");
						return null;

					}
					if (count == 2) {

						count++;
						System.out.println(AccountStatus.BLOCKED);
//						entity.setAcc_status(AccountStatus.BLOCKED.getValue());
						System.out.println("login failed");
						model.addAttribute("loginfailed", "Your account is blocked");
						boolean res = updateByWrongPasswordCount(entity.getEmail(), count);
						updateAccountStatusByEmail(AccountStatus.BLOCKED.getValue(), email);

						return null;

					}

//				else {
////							if (count >= 2) {
//								System.out.println("login failed");
//								model.addAttribute("loginfailed", "Email id and password mismatch");
//								return entity;
				}
			}
		}

		return null;

	}

	@Override
	public boolean updateByWrongPasswordCount(String email, int wrongPasswordCount) {
		if (email != null && wrongPasswordCount >= 0) {

//			System.out.println("password is entered");
//			CustomerInsightEntity entity = new CustomerInsightEntity();
//			if (entity != null) {

//	      if(entity.getPassword()!=dto.getPassword()) {
//	    	boolean status = updateByWrongPasswordCount(dto, email, wrongPasswordCount);
//	    	 int count = 0; 
//	    	  count ++;
			return dao.updateByWrongPasswordCount(email, wrongPasswordCount);
		}
		return false;
	}

//	@Override
//	public CustomerInsightEntity updateAccountStatusByEmail(String acc_status, String email) {
//		if(email!=null && acc_status!=null) {
//			System.out.println("account status");
//			return dao.updateAccountStatusByEmail(acc_status, email);
//		}
//		return null;
//	}

	@Override
	public boolean updateAccountStatusByEmail(String acc_status, String email) {
		if (email != null && acc_status != null) {
			boolean result = dao.updateAccountStatusByEmail(acc_status, email);
			System.out.println(result);
			return result;
		}
		return false;
	}

	@Override
	public boolean sendMail(String email, CustomerInsightEntity entity) {
		String username = "riteshpradhan999@outlook.com";
		String password = "Riteshrp@12345";

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.outlook.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a new email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Succesfully send");

			message.setText("Hi," + entity.getFirstName() + ",Your account is create Succesfully.");

			// Send the email
			Transport.send(message);
			System.out.println("Email sent successfully to =========" + email);
		} catch (MessagingException e) {
			System.out.println("Error sending email: " + e.getMessage());
		}

		return true;
	}

	@Override
	public int generateOtp() {
		System.out.println("Generating OTP using random() : ");
		System.out.print("You OTP is : ");

		int otp = (int) (Math.random() * 900000) + 100000;
		return otp;
	}

	@Override
	public boolean updateOtpByEmail(int otp, String email) {
      if(email!=null) {
    	  boolean status = dao.updateOtpByEmail(otp, email);
    	  System.out.println(status);
    	  return status;
      }
		return false;
	}

	@Override
	public String forgotPassword(String email) {
		if (email != null) {
			CustomerInsightEntity entity = dao.findByEmail(email);
			if(entity!=null) {
				System.out.println("email is there");
				System.out.println(email);
			    int otp = generateOtp();
                updateOtpByEmail(otp, email);
                System.out.println(otp);
//                sendOtpByEmail(otp, email);
                System.out.println("send otp successfully");
                String val=entity.getEmail();
                
				return val;
			}
	}
		return null;
	}
	@Override
	public boolean sendOtpByEmail(int otp, String email) {
		if(email!=null) {
		String username = "riteshpradhan999@outlook.com";
		String password = "Riteshrp@12345";

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.outlook.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a new email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Succesfully send");

			message.setText("Hi.. your otp is "+ otp);
//            forgotPassword(email);
			// Send the email
			Transport.send(message);
			System.out.println("Otp sent successfully to =========" + email);
		} catch (MessagingException e) {
			System.out.println("Error sending email: " + e.getMessage());
		}

		return true;
	}
		return false;
	}

	@Override
	public boolean validateOtpByEmail(int otp, String email) {
		System.out.println("running........");
		if(email!=null) {
		getOtpByEmail(email);
		System.out.println(otp);
		System.out.println(email);
		 
			System.out.println("Validate otp Successfully");
			return true;
		}	
		return false;
	}

	@Override
	public int getOtpByEmail(String email) {
		System.out.println("get the otp");
		if(email!=null) {
		int res = dao.getOtpByEmail(email);
			System.out.println("Get the otp");
			System.out.println(email);
			return res ;
		}
		return 0;	
	}

	@Override
	public boolean resetPassword(String email, String password, String confirmPassword) {
		System.out.println(email);
		System.out.println(password);
		System.out.println(confirmPassword);
	  if(email!=null && password!=null && confirmPassword!=null) {
		  if(password.equals(confirmPassword)) {
		System.out.println(password);
		System.out.println(confirmPassword);
	String	val = Encryption.encrypt(password);
	System.out.println(val);
		 updatePasswordByEmail(email, val);
		 System.out.println(password);
		 updateByWrongPasswordCount(email, 0);
			updateAccountStatusByEmail(AccountStatus.UNBLOCKED.getValue(), email);
		 System.out.println("reset successfull");
		 return true;
	  }
	}
	return false;
	}
	@Override
	public boolean updatePasswordByEmail(String email, String password) {
		if(email!=null) {
			boolean stu = dao.updatePasswordByEmail(email, password);
			System.out.println(stu);
			return true;
		}
		return false;
	}
}