package test.hrms2.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import test.hrms2.entities.abstracts.User;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employers" })

public class Employer extends User {

	@NotBlank(message = "Şirket ismi boş bırakılamaz. \n")
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank(message = "Web adresi boş bırakılamaz. \n")
	@Column(name = "web_address")
	private String webAddress;
	
	@NotBlank(message = "Telefon bilgisi boş bırakılamaz. \n")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<ConfirmByEmployee> confirmByEmployees;
		
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
}
