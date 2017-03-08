package com.goutham.springboot.database;

import javax.persistence.*;

/**
 * Created by kishorejavvaji on 2/16/17.
 * Generally this represents a database DDL
 */
@Entity
public class DTOEntity {

    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}



	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    //Used for JPA internal processing
    protected DTOEntity() {}

    public DTOEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {

        return id + " "+firstName + " " +lastName;
    }



    public String getFirstName() {
        return this.firstName;
    }
}
