package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Actor {
	private int id;
	private String firstName;
	private String lastname;
    private List<Film> films;

	
	public Actor(int id, String firstName, String lastname) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
	}
		
	public Actor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("First Name: ");
		builder.append(firstName);
//		builder.append(", Last Name: ");
		builder.append(" ");
		builder.append(lastname);
		builder.append(". ");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	

}
