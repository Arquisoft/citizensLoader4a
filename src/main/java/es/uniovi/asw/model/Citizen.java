package es.uniovi.asw.model;


import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * Clase del modelo Citizen
 */
@Entity
@Table(name="USUARIOS")
public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // JPA
	private String nombre;
	private String apellidos;
	private String email;
	private Date fecha_nacimiento;
	private String direccion_postal;
	private String nacionalidad;
	private String numero_identificativo; // Clave natural
	private String contrasena;
	@Transient
	private String contrasena_NC;


	public Citizen() {	}
	public Citizen(String nombre, String apellidos, String email, Date fecha_nacimiento, String direccion_postal, String nacionalidad,
				   String numero_identificativo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion_postal = direccion_postal;
		this.nacionalidad = nacionalidad;
		this.numero_identificativo = numero_identificativo;
	}

	public Citizen(String nombre, String apellidos, String email, Date fecha_nacimiento, String direccion_postal,
				   String nacionalidad, String numero_identificativo, String contrasena) {
		this(nombre,apellidos,email,fecha_nacimiento,direccion_postal,nacionalidad,numero_identificativo);
		this.contrasena= DigestUtils.sha512Hex(contrasena);
		this.contrasena_NC=contrasena;
	}


	public void setNombre(String name) {
		this.nombre = name;
	}

	public void setApellidos(String surname) {
		this.apellidos = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechaNacimiento(Date birthdate) {
		this.fecha_nacimiento = birthdate;
	}

	public void setDireccionPostal(String address) {
		this.direccion_postal = address;
	}

	public void setNacionalidad(String nationality) {
		this.nacionalidad = nationality;
	}

	public void setNumeroIdentificativo(String nif) {
		this.numero_identificativo = nif;
	}




	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaNacimiento() {
		return fecha_nacimiento;
	}

	public String getDireccionPostal() {
		return direccion_postal;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getNumeroIdentificativo() {
		return numero_identificativo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getContrasenaNC() {
		return contrasena_NC;
	}

	public void setContrasena(String password) {
		this.contrasena= DigestUtils.sha512Hex(password);
		this.contrasena_NC=password;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Citizen citizen = (Citizen) o;

		return numero_identificativo.equals(citizen.numero_identificativo);
	}

	@Override
	public int hashCode() {
		return numero_identificativo.hashCode();
	}

	@Override
	public String toString() {
		return "Citizen{" + "id=" + id + ", name='" + nombre + '\'' + ", surname='" + apellidos + '\'' + ", email='" + email
				+ '\'' + ", birthdate=" + fecha_nacimiento + ", address='" + direccion_postal + '\'' + ", nationality='" + nacionalidad
				+ '\'' + ", nif='" + numero_identificativo + '\'' + ", password='" + contrasena + '\'' + '}';
	}
}
