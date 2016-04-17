package uk.ac.ncl.project.car_hire_application;
import java.util.*;
import java.lang.*;

public class DrivingLicence {
		private final String firstName;
		private final String lastName;
		private final Date dateOfBirth;
		private final Date dateOfIssue;
		private final String licenceNumber;
		private static final Map<String, DrivingLicence> LICENCES = new HashMap<String, DrivingLicence>();
	
		private DrivingLicence(String firstName, String lastName, Calendar dateOfBirth, Calendar dateOfIssue, String licenceNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth.getTime();
		this.dateOfIssue = dateOfIssue.getTime();
		this.licenceNumber = licenceNumber;
		}
		
		public static void createInstance(String firstName, String lastName, Calendar dateOfBirth, Calendar dateOfIssue) {
			String yearOfIssue = String.valueOf(dateOfIssue.get(Calendar.YEAR));
			String i;
			
			do{
				i = String.valueOf((int)(Math.random()*100)+1);
			}while(LICENCES.containsKey(i));
			
			String licenceNumber = String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0))+"-"+yearOfIssue+"-"+i;
			LICENCES.put(i, new DrivingLicence(firstName, lastName, dateOfBirth, dateOfIssue, licenceNumber));
		}
		
		public static void getLicences(){
			for (String key : LICENCES.keySet()) {
				System.out.println(key);
			}
			for (DrivingLicence value : LICENCES.values()) {
				System.out.println(value.getName());
				System.out.println(value.getDateOfBirth());
				System.out.println(value.getDateOfIssue());
				System.out.println(value.getLicenceNumber());
			}
		}
		
		public String getName() { return firstName+" "+lastName; }

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public Date getDateOfIssue() {
			return dateOfIssue;
		}

		public String getLicenceNumber() {
			return licenceNumber;
		}
}
