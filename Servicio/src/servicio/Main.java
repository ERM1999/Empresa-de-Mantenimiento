/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.util.ArrayList;
import java.util.Scanner;
///////////////////////////////ESTO ES UNA PRUEBA PARA GITHUB/////////////////////////////////////
///////////////////////////////SOLO DESDE LA RAMA ESTEFANIA/////////////////////////////////////
/**
 *
 * @author fani
 */
public class Main {
    
    static ArrayList <Servicio> lista = new ArrayList<>();
    static ArrayList<TrabajoPintura> trabajosPintura = new ArrayList<>(); //explicar xq usamos dos listas adicionales
    static ArrayList<RevisionAlarma> revisionesAlarma = new ArrayList<>();
    
    public static void main (String [] args){
        
        Scanner sc = new Scanner (System.in);
        int opcion = 0;
        
       
        System.out.println("Selecciona una de las opciones");
      
        do{
            System.out.println("1. Añadir trabajo");
            System.out.println("2. Listar trabajo");
            System.out.println("3. Borrar trabajo ");
            opcion = sc.nextInt();
            
            
            switch(opcion){
                case 1: 
                    anadirTrabajo(sc);
                    break;
                case 2:
                    listarTrabajo(sc);
                    break;
                case 3:
                    borrar(sc);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            
            
        }while(opcion>0 && opcion<4);
    }

     public static void anadirTrabajo(Scanner sc) {
        System.out.println("1. Trabajo pintura");
        System.out.println("2. Revisión alarma");
        int opcion = sc.nextInt();
        
        switch(opcion) {
            case 1: 
                anadirP(sc); // Añadir trabajo pintura
                break;
            case 2: 
                anadirA(sc); // Añadir revisión alarma
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
 
       public static void listarTrabajo(Scanner sc) {
        System.out.println("1. Listar trabajos de pintura");
        System.out.println("2. Listar revisiones de alarma");
        int opcion = sc.nextInt();

        switch(opcion) {
            case 1:
                listaP();
                break;
            case 2:
                listaA();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
 
       public static void anadirP(Scanner sc){
      
      System.out.println("Indica los siguientes datos: ");
      
      System.out.println("Nombre del trabajador: ");
      String trabajador = sc.next();
      System.out.println("Fecha de inicio: ");
      String fechaInicio = sc.next();
      System.out.println("Nombre del cliente: ");
      String cliente = sc.next();
      System.out.println("Referencia: ");
      String referencia = sc.next();
      System.out.println("Superficie: ");
      double superficie = sc.nextDouble();
      
      sc.nextLine();
      
      System.out.println("Precio de la pintura");
      double precioPintura = sc.nextDouble();
      
      TrabajoPintura uno = new TrabajoPintura(trabajador,fechaInicio,cliente,referencia,superficie,precioPintura);
      lista.add(uno);
      trabajosPintura.add(uno);
       
      System.out.println("Trabajo de pintura añadido correctamente.");
  }          
  
      public static void anadirA(Scanner sc){
    
      System.out.println("Indica los siguientes datos: ");
      
      System.out.println("Nombre del cliente: ");
      String cliente = sc.next();
      
      System.out.println("Fecha de revision: ");
      String revision = sc.nextLine();
      
       sc.nextLine();
     
      System.out.println("Numero de alarma: ");
      int numAlarma = sc.nextInt();
      
      
      RevisionAlarma dos = new RevisionAlarma(revision,cliente,numAlarma);
      lista.add(dos);
      revisionesAlarma.add(dos);
      System.out.println("Revisión de alarma añadida correctamente.");
      
  }  
  
     public static void listaP(){
      for (int i = 0; i < trabajosPintura.size(); i++){
          System.out.println(trabajosPintura.get(i).detalleServicio());
      }
      
  }
  
     public static void listaA(){
      for (int i = 0; i < revisionesAlarma.size(); i++ ){
           //lista instanceof RevisionAlarma, estaria bien comentar que se puede hacer tambien con instanceof y como
           System.out.println(revisionesAlarma.get(i).detalleServicio());
      }   
  }
  
  
  
     public static void borrar(Scanner sc){
     System.out.println("Indica la referencia del trabajo que quieres eliminar");
     String referencia = sc.next();
     // Recorremos la lista desde el final para evitar problemas con el desplazamiento de índices
        for (int i = 0; i < lista.size(); i++) {
           if (lista.get(i).getReferencia().equals(referencia)) {
               lista.remove(i);
                System.out.println("Trabajo eliminado correctamente.");
                    }  else{
               System.out.println("No existe");
           }           
            
        
        for (int j = 0; j < trabajosPintura.size(); j++) {
                if (trabajosPintura.get(j).getReferencia().equals(referencia)) {
                    trabajosPintura.remove(j);
                    break;
                }
            }
            
            // Eliminar de la lista específica de revisiones de alarma
            for (int j = 0; j < revisionesAlarma.size(); j++) {
                if (revisionesAlarma.get(j).getReferencia().equals(referencia)) {
                    revisionesAlarma.remove(j);
                    break;
                }
    }
        } 
     }
}