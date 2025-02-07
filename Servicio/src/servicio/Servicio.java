/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servicio;

/**
 *
 * @author fani
 */
public abstract class Servicio {

    String trabajador;
    String fechaInicio;
    String cliente;
    String referencia;
   
    
    public Servicio(String trabajador, String fechaInicio, String cliente, String referencia){
        this.trabajador = trabajador;
        this.fechaInicio = fechaInicio;
        this.cliente = cliente;
        this.referencia = referencia;
        
    }
    
    public Servicio (String cliente){
      this.cliente = cliente;
    }
    
    public String getReferencia(){
        return referencia;
    }
    public abstract double costeMaterial();
    
    public  abstract double costeManoObra();
    
    public abstract double costeTotal();
    
    
    
    
}
