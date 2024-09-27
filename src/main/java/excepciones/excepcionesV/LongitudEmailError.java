package excepciones.excepcionesV;

public class LongitudEmailError extends Exception {

    /*
    * Cuando se crean excepciones, estas, primero deben extender de Exception o de IOException para exigir captura del error
    * Cuando se construye la clase, como mínimo debe tener un constructor por defecto y uno que reciba un mensaje
    */
    public LongitudEmailError() {
    }

    public LongitudEmailError(String message) {
        super(message);
    }

}
