package test.hrms2.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_advertisements")

public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "İş tanımı alanı boş bırakılamaz.")
	@NotNull
	@Column(name = "job_description", nullable = false)
	private String jobDescription;
	
	@Column(name = "min_salary")
	@Positive
	private int minSalary;
	
	@Column(name = "max_salary")
	@Positive
	private int maxSalary;
	
	@Column(name = "open_position", nullable = false)
	@NotNull
	@Positive
	private int openPosition;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "application_deadline")
	private Date deadline;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;
	
	@ManyToOne //(targetEntity = Employer.class)
	//@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne(targetEntity = JobPosition.class)
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	private City city;
}
