package com.demo.lc;



/**
 * This service simply modify the original message and return the new message
 */

public class PropertyService {
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private String lastName;

    public void printProperty() {
        System.out.println("Property is: " + lastName);
    }
}
