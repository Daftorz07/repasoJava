package collectionsII.usoEquals;

import java.util.Objects;

public class Libro {

    private String titulo;
    private String autor;
    private int ISBN;

    public Libro(String autor, String titulo, int ISBN) {
        this.autor = autor;
        this.ISBN = ISBN;
        this.titulo = titulo;
    }

    public String getDatos(){
        return "El titulo del libre es: " + titulo + ". Escrito por el autor: " + autor + ". y el ISBN: " + ISBN;
    }

    //@Override
    public boolean equals2(Object obj) {
        if (obj instanceof Libro){
            Libro other = (Libro) obj;
            if (this.ISBN == other.ISBN){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    //Metodos generados por el IDE, al momento de generarlo, seleccionamos el campo que verifica la diferencia de los objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return ISBN == libro.ISBN;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ISBN);
    }
}
