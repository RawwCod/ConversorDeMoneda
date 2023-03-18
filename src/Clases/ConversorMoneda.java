package Clases;

public class ConversorMoneda extends Conversor{
    
    public ConversorMoneda(Double datoAConvertir, String nombreOrigen, String nombreDestino) {
        super(datoAConvertir, nombreOrigen, nombreDestino);
    }
    @Override
    public boolean convertir(Double valorActual, int modo) {//modo 1 de soles a moneda, modo 2 de moneda a soles
        try {
            if(modo==1){
                this.resultado=this.datoAConvertir*valorActual;
                redondeo();
                return true;
            }
            else{
                this.resultado=this.datoAConvertir/valorActual;
                redondeo();
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error en la conversion");
            return false;
        }

    }
    private void redondeo(){
        this.resultado=Math.round(this.resultado*100.0)/100.0;
    }
    
}
