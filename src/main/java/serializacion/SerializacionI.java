package serializacion;

import java.io.*;

public class SerializacionI {

    public static void main(String[] args) {

        Administrador jefe = new Administrador("David Torres", 4800000, 2022, 4, 1);
        jefe.setIncentivo(500000);

        Empleado[] empleados = new Empleado[3];

        empleados[0] = jefe;
        empleados[1] = new Empleado("Blanqui Bayuelo", 2700000, 2023, 2, 15);
        empleados[2] = new Empleado("Deisy Zabala", 1500000, 2021, 1, 1);

        //Serializar y Deserializar objeto de tipo empleado
        try {
            String rutaArchivo = "src/archivos/serializar/empleados.txt";

            FileOutputStream fileOut = new FileOutputStream(rutaArchivo);
            ObjectOutputStream datosSerializados = new ObjectOutputStream(fileOut);
            datosSerializados.writeObject(empleados);
            datosSerializados.close();
            System.out.println("Array de empleados serializados \n");

            FileInputStream fileIn = new FileInputStream(rutaArchivo);
            ObjectInputStream datoRecuperados = new ObjectInputStream(fileIn);

            Empleado[] empleadosDeserializados = (Empleado[]) datoRecuperados.readObject();
            System.out.println("Datos de empleados Recuperados \n");
            datoRecuperados.close();

            for (Empleado empleado : empleadosDeserializados) {
                System.out.println(empleado.toString());
            }

        } catch (IOException | ClassNotFoundException e) { //
            System.out.println("Se genero un error de tipo: " + e.getClass().getName());
            System.out.println("Motivo: " + e.getMessage());
            System.out.println("-------------------------------- \n");
            throw new RuntimeException(e);
        }
    }
}