package test.hrms2.core.validations;



import test.hrms2.entities.concretes.Employer;

public class EmployerValidator {

	public static boolean EmployerDomainCheck(Employer employer) {
		
		String[] dizi = employer.getEmail().split("@");
		String email=dizi[1];
				
		String[] dizi2 = employer.getWebAddress().split("www.");
		String domain =dizi2[1];

		if(email.equals(domain)) {
			System.out.println(email + domain);
			return true;
			
		}
		else {
		System.out.println(email + domain+"false" );
		return false;}
	}
	
	
}
