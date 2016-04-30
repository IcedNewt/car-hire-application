package uk.ac.ncl.project.car_hire_application;

import java.util.*;

public final class DrivingLicence {
		private final String FIRSTNAME;
		private final String LASTNAME;
		private final Date DATE_OF_BIRTH;
		private final Date DATE_OF_ISSUE;
		private final String LICENCE_NUMBER;
		private final boolean IS_FULL_LICENCE;
		private static final Map<String, DrivingLicence> LICENCES = new HashMap<String, DrivingLicence>();
	
		private DrivingLicence(String firstName, String lastName, Calendar dateOfBirth, Calendar dateOfIssue, String licenceNumber, boolean isFullLicence) {
		this.FIRSTNAME = firstName;
		this.LASTNAME = lastName;
		this.DATE_OF_BIRTH = dateOfBirth.getTime();
		this.DATE_OF_ISSUE = dateOfIssue.getTime();
		this.LICENCE_NUMBER = licenceNumber;
		this.IS_FULL_LICENCE = isFullLicence;
		}
		
		// Static factory method for creating a DrivingLicence object.
		protected final static DrivingLicence createInstance(String firstName, String lastName, Calendar dateOfBirth, Calendar dateOfIssue, boolean isFullLicence) {
			String yearOfIssue = String.valueOf(dateOfIssue.get(Calendar.YEAR));
			String i;
			
			do{
				i = String.valueOf((int)(Math.random()*9)+1)+String.valueOf((int)(Math.random()*9)+1);
			}while(LICENCES.containsKey(i));
			
			String licenceNumber = String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(0))+"-"+yearOfIssue+"-"+i;
			DrivingLicence newLicence = new DrivingLicence(firstName, lastName, dateOfBirth, dateOfIssue, licenceNumber,isFullLicence);
			LICENCES.put(i, newLicence);
			
			return newLicence;
		}
		
		// Overrides the toString() for DrivingLicence objects.
		public String toString(){
			return "Name: "+FIRSTNAME+" "+LASTNAME+" - Licence Number: "+LICENCE_NUMBER;
			
		}
		
		public String getLICENCE_NUMBER() {
			return LICENCE_NUMBER;
		}

		public String getName() { return FIRSTNAME+" "+LASTNAME; }

		public Date getDateOfBirth() {
			return DATE_OF_BIRTH;
		}

		public static Map<String, DrivingLicence> getLICENCES(){
			return LICENCES;
		}
		
		public Date getDateOfIssue() {
			return DATE_OF_ISSUE;
		}

		public String getLicenceNumber() {
			return LICENCE_NUMBER;
		}
		
		public boolean getIsFullLicence(){
			return IS_FULL_LICENCE;
		}
		
}
