package pe.hypergis.peoplews;

/**
 * Created by Marlon on 3/11/2017.
 */

public class Person {
    private String nombre;
    private String dni;
    private int edad;
    private String bio;
    private String imagenurl;

    public Person(String imagenurl, String nombre, String dni, int edad, String bio) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.bio = bio;
        this.imagenurl = imagenurl;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
