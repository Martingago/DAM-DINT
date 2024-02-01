package main.aplicacioninformes;

public class AplicacionInformes {

    public static void main(String[] args) {
        PedidosAnio informe = new PedidosAnio(); 
            int anio=2019;//Valor que se va a pasar para que lo recoja el parámetro 
            informe.ejecutar(anio); 
    }
}
