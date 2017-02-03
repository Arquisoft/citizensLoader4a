package es.uniovi.asw.model;

import java.util.Date;


public class Citizen {

    private Long id; //JPA
    private String name;
    private String surname;
    private String email;
    private Date birthdate;
    private String address;
    private String nationality;
    private String nif; //Clave natural
    private String password;

    public Citizen(){}

    public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Citizen(Long id, String name, String surname, String email, Date birthdate, String address, String nationality, String nif) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.address = address;
        this.nationality = nationality;
        this.nif = nif;
    }

    public Citizen(Long id, String name, String surname, String email, Date birthdate, String address, String nationality, String nif, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
        this.address = address;
        this.nationality = nationality;
        this.nif = nif;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getNationality() {
        return nationality;
    }

    public String getNif() {
        return nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Citizen citizen = (Citizen) o;

        return nif.equals(citizen.nif);
    }

    @Override
    public int hashCode() {
        return nif.hashCode();
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nif='" + nif + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
