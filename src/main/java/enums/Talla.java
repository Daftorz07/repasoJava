package enums;

public enum Talla {

    MINI("S"),
    MEDIANO("M"),
    GRANDE("L"),
    MUY_GRANDE("XL");

    private String tallaAbreviada;

    private Talla(String tallaAbreviada) {
        this.tallaAbreviada = tallaAbreviada;
    }

    public String getTallaAbreviada() {
        return tallaAbreviada;
    }

    public void setTallaAbreviada(String tallaAbreviada) {
        this.tallaAbreviada = tallaAbreviada;
    }
}
