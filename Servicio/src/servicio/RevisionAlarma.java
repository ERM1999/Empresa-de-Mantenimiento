/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author fani
 */
public class RevisionAlarma extends Servicio {
    int numAlarmas;
    String fechaRevision;
    

    public RevisionAlarma(String fechaRevision,String cliente, int numAlarmas){
        super(cliente);
        this.numAlarmas = numAlarmas;
        this.fechaRevision = fechaRevision;
        
    }
    
    public RevisionAlarma(String trabajador, String fechaInicio, String cliente, String referencia, int numAlarma) {
        super("Revisor Especialista Contraincendios", fechaInicio, cliente, referencia);
        this.numAlarmas = numAlarma;
        this.fechaRevision = fechaRevision;
       
    }
    
     
    public void setNumAlarma(){
        this.numAlarmas = numAlarmas;
    }
    
    public int getNumerAlarma(){
     return numAlarmas;   
    }
    
 
    
    @Override
    public double costeMaterial() {
        return 0;
    }

    @Override
    public double costeManoObra() {
        return (numAlarmas/3)*40;
    }

    @Override
    public double costeTotal() {
        return costeManoObra();
    }
    
    
    public String detalleServicio(){
        
        String resultado = "REVISIÓN PERIÓDICA ALARMAS CONTRAINCENDIOS"+ "\n";
        resultado += "Cliente :" + cliente + "\n";
        resultado += "Fecha revisión :" + fechaRevision + "\n";
        resultado += "--------------------------------" + "\n";
        resultado += "TOTAL:...... " +costeTotal() + "\n"; 
        resultado += "--------------------------------" + "\n";
        return resultado;
    }
}
