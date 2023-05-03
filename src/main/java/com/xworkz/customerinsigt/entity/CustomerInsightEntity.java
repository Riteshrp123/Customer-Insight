package com.xworkz.customerinsigt.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.xworkz.customerinsigt.dto.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="customerinsight")
@NamedQuery(name="findByEmail",query="select entity from CustomerInsightEntity entity where entity.email=:em")
@NamedQuery(name="findByEmailAndPassword", query="select entity from CustomerInsightEntity entity where entity.email=:em and entity.password=:pass")
@NamedQuery(name="updateByWrongPasswordCount",query="update CustomerInsightEntity entity set entity.wrongPasswordCount=:cou where entity.email=:em")
@NamedQuery(name="updateAccountStatusByEmail",query="update CustomerInsightEntity entity set entity.acc_status=:acc where entity.email=:em")
@NamedQuery(name="updateOtpByEmail",query ="update CustomerInsightEntity entity set entity.otp=:otp where entity.email=:eml")
@NamedQuery(name="getOtpByEmail",query = "select entity.otp from CustomerInsightEntity entity where entity.email=:eml")
@NamedQuery(name="updatePasswordByEmail",query = "update CustomerInsightEntity entity set entity.password=:pass where entity.email=:eml")
public class CustomerInsightEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
		
		@Column(name="id")
		private int id;
		
		
		@NotBlank(message="firstname should not be null")
		@Column(name="firstName")
		private String firstName;
		
		@NotBlank(message="lastname should not be null")
		@Column(name="lastName")
		private String lastName;
		
		@Email(message = "Email is not valid")
		@NotEmpty(message = "Email cannot be empty")
		@Column(name="email")
		private String email;
		
		@NotBlank(message="password should not be null")
		@Column(name="password")
		private String password;
		
		@Column(name="dateOfBirth")
		private String dateOfBirth;
		
		@NotBlank(message="gender should not be null")
		@Column(name="gender")
		private String gender;
		
		@Column(name="createdBy")
		private String createdBy;
		
		@Column(name="createdon")
		private LocalTime createdOn;
		
		@Column(name="wrongPasswordCount")
		private int wrongPasswordCount;
		
		@Column(name="acc_status")
		private String acc_status;
		
		@Column(name="otp")
		private int otp;
		
		
}
