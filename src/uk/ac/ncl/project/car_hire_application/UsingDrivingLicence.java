package uk.ac.ncl.project.car_hire_application;

import java.util.*;

public class UsingDrivingLicence {

	public static void main(String[] args) {
		
		Calendar dateOfBirth = new GregorianCalendar(1996,9,7);
		Calendar dateOfIssue = new GregorianCalendar(2013,0,31);
		
		DrivingLicence.createInstance("Jonah", "Robinson", dateOfBirth, dateOfIssue);
		DrivingLicence.createInstance("James", "Bond", dateOfBirth, dateOfIssue);
		
		DrivingLicence.getLicences();
	}

}
