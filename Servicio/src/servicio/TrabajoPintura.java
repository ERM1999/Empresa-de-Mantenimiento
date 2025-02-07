/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author fani
 */
public class TrabajoPintura extends Servicio {
    double superficie;
    double precioPintura;
    

    public TrabajoPintura(String trabajador, String fechaInicio, String cliente, String referencia, double superficie, double precioPintura) {
        super(trabajador, fechaInicio, cliente, referencia);
        this.superficie = superficie;
        this.precioPintura = precioPintura;
        
    }
    
    

    @Override
    public double costeMaterial() {
        
        return (superficie/7.8)*precioPintura;
        
    }

    @Override
    public double costeManoObra() {
        return (superficie/10)*9.5;
    }

    @Override
    public double costeTotal() {
       return (costeManoObra()+ costeMaterial()+costeAdicional(superficie));
    }
       
     
    public double costeAdicional(double superficie) {
        
        if (superficie < 50){
            
        return (costeManoObra() + costeMaterial()) * 0.15; // 15% de los costes de mano de obra y material
        
        } else
            
        return 0;
    }
    
    
    public String detalleServicio(){
        
       String resultado = "TRABAJO DE PINTURA" + "\n";
        resultado += "Cliente :" + cliente + "\n";
        resultado += "Fecha de inicio :" + fechaInicio + "\n";
        resultado += "--------------------------------" + "\n";
        resultado += "Pintor: " + trabajador + " Coste material: " + costeMaterial()+ "\n";
        resultado += "Coste mano de obra:" + costeManoObra() + "\n"; 
        resultado += "Coste adicional: " +costeAdicional(superficie)+ "\n"; 
        resultado += "TOTAL:...... " +costeTotal()+ "\n"; 
        resultado += "--------------------------------"+ "\n";
        return resultado;
    }
    
}
