package Clases;

public abstract class Conversor {
	Double datoAConvertir;
    String nombreOrigen; //esto puede cambiar a un objeto de tipo valor
    String nombreDestino; //esto puede cambiar a un objeto de tipo valor
    Double resultado;
    public Conversor(Double datoAConvertir, String nombreOrigen, String nombreDestino) {
        this.datoAConvertir = datoAConvertir;
        this.nombreOrigen = nombreOrigen;
        this.nombreDestino = nombreDestino;
    }
    public Double getDatoAConvertir() {
        return datoAConvertir;
    }
    public void setDatoAConvertir(Double datoAConvertir) {
        this.datoAConvertir = datoAConvertir;
    }
    public String getNombreOrigen() {
        return nombreOrigen;
    }
    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }
    public String getNombreDestino() {
        return nombreDestino;
    }
    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }
    public Double getResultado() {
        return resultado;
    }
    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public abstract boolean convertir(Double valorActual, int modo);

    @Override
    public String toString() {
        return "Conversor{" + "datoAConvertir=" + datoAConvertir + ", nombreOrigen=" + nombreOrigen + ", nombreDestino=" + nombreDestino + ", resultado=" + resultado + '}';
    }

}
