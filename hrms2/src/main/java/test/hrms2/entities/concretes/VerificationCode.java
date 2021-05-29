package test.hrms2.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import test.hrms2.entities.abstracts.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="verification_codes")
@EqualsAndHashCode(callSuper=false)
public class VerificationCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "is_verified")
	private boolean isVerified;
	
	//@OneToMany(mappedBy = "users")
	//@Column(name="user_id")
	//private User user;
}
