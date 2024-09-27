package JDBC.practicaGM.zonaFit.dominio;

import java.util.Objects;

public class Cliente {

    private int id;
    private String userName;
    private String lastName;
    private int membership;

    public Cliente() {}

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String userName, String lastName, int membership) {
        this.userName = userName;
        this.lastName = lastName;
        this.membership = membership;
    }

    public Cliente(int id, String userName, String lastName, int membership) {
        this(userName, lastName, membership);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMembership() {
        return membership;
    }

    public void setMembership(int membership) {
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", membership=" + membership +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && membership == cliente.membership && Objects.equals(userName, cliente.userName) && Objects.equals(lastName, cliente.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, lastName, membership);
    }
}
