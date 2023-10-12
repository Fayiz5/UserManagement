package com.example.UserManagement.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    // Instance variables
    private String resourcename;
    private String fieldName;
    private long fieldvalue;

    // Constructor
    public ResourceNotFoundException(String resourcename, String fieldName, long fieldvalue) {
        // Call the superclass constructor (RuntimeException) with a formatted error message
        super(String.format("Resource '%s' with '%s' = %s not found.", resourcename, fieldName, fieldvalue));

        // Assign the arguments to the instance variables
        this.resourcename = resourcename;
        this.fieldName = fieldName;
        this.fieldvalue = fieldvalue;
    }

}
