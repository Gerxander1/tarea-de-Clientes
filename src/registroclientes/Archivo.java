
package registroclientes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;



public class Archivo {
 Scanner teclado = new Scanner(System.in);
    
    boolean evaluar;
    String ruta;
    String cod;
    String nombre;
    String apellido;

    public Scanner getTeclado() {
        return teclado;
    }

    public void setTeclado(Scanner teclado) {
        this.teclado = teclado;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRuta() {
       this.ruta = "archivo.txt";
       //"C:\\Users\\Gerson\\Desktop\\RegistroClientes\\archivo.txt"
        return ruta;
    }
     public String getRuta2() {
       this.ruta = "archivo2.txt";
        return ruta;
    }
    
    public boolean getEvaluar() {
        return evaluar;
    }

    public void setEvaluar(boolean evaluar) {
        this.evaluar = evaluar;
    }
   
   public boolean Comprobacion(){
       try{
            setEvaluar(false);
            File archivo = new File(getRuta());
            BufferedWriter bw;
                
            File archivo2 = new File(getRuta2());
            BufferedWriter bw2;
            
            if(archivo.exists()){                 
                   setEvaluar(true);
                 
            }
            else{
                   bw = new BufferedWriter(new FileWriter(archivo));
                     bw.close();   
                   JOptionPane.showMessageDialog(null, "Archivo no Existente se Creara uno");
                }
            if(archivo2.exists()){                 
                   setEvaluar(true);
                 
            }
            else{
                   bw2 = new BufferedWriter(new FileWriter(archivo2));
                     bw2.close();   
                }
                
       }catch(IOException e){}
        return getEvaluar();
   }
   
   public void Registro(){

       Comprobacion();
       String cadena="";
            if(getEvaluar()==true){        
                try{ 
                    try{

                         FileReader f = new FileReader(getRuta());
                         BufferedReader br = new BufferedReader(f);

                         while((cadena = br.readLine())!=null){
                           StringTokenizer st=new StringTokenizer(cadena,"/");
                             System.out.println(st.nextToken()+st.nextToken()+st.nextToken());
                             /*st.nextToken();
                             st.nextToken();*/
                         }

                         br.close();
                     }catch(NoSuchElementException e){}
                }catch(IOException e){}
                }
            }
       
              
       
   public void Escribir(){
        Comprobacion();
            if(getEvaluar() == true){
                try{
                FileWriter fw=new FileWriter(getRuta(),true);
                 BufferedWriter bw=new BufferedWriter(fw);
                    fw.write(getCod()+"/");
                    fw.write(getNombre()+"/");
                    fw.write(getApellido()+"\r\n");
                 fw.flush();
                 fw.close();

                }catch(IOException e){}
            }
        }
    
    public void Buscar(){
        Comprobacion();
        String cadena;
        boolean entra = false;
        
            if(getEvaluar()==true){
                try{
                    try{
                         FileReader f = new FileReader(getRuta());
                        BufferedReader br = new BufferedReader(f); 
                         while((cadena = br.readLine())!=null){
                           StringTokenizer st=new StringTokenizer(cadena,"/");
                           if(getCod().equals(st.nextToken())){                          
                           setNombre(st.nextToken());
                           setApellido(st.nextToken());
                           entra = true;
                           break;
                           }
                        
                         }
                         if(entra == false){
                           JOptionPane.showMessageDialog(null, "El registro que busca no existe o esta mal escrito PorFavor intentelo denuevo");  
                         }
                         br.close();

                    }catch(NoSuchElementException e){}
                    
                }catch(IOException e){}
            }
        
    }
    
    public void Modificar(){
        Comprobacion();
        String codigo;
        String cadena;
        String cadena2;
        int i=0;
        boolean entra = false;
        
        if(getEvaluar()==true){
                try{
                    try{ 
                        FileWriter fw=new FileWriter(getRuta2());
                        BufferedWriter bw=new BufferedWriter(fw);       
                        FileReader f = new FileReader(getRuta());
                        BufferedReader br = new BufferedReader(f); 
                       
                        
                        while((cadena = br.readLine())!=null){
                         StringTokenizer st=new StringTokenizer(cadena,"/");
                         codigo = st.nextToken();
                            if(codigo.equals(getCod())){
                                fw.write(getCod()+"/");
                                fw.write(getNombre()+"/");
                                fw.write(getApellido()+"\r\n");
                                entra = true;
                            }
                            else{
                                fw.write(codigo+"/");
                                fw.write(st.nextToken()+"/");
                                fw.write(st.nextToken()+"\r\n");
                            }
                        }
                        if(entra==false){
                             JOptionPane.showMessageDialog(null, "El registro que busca no existe o esta mal escrito PorFavor intentelo denuevo");  
                        }
                        br.close();
                        fw.flush();
                        fw.close();
                       
                        FileWriter fw2=new FileWriter(getRuta());
                        BufferedWriter bw2=new BufferedWriter(fw2);
                        FileReader f2 = new FileReader(getRuta2());
                        BufferedReader br2 = new BufferedReader(f2);
                     
                        while((cadena2 = br2.readLine())!=null){
                        StringTokenizer st=new StringTokenizer(cadena2,"/");
                                fw2.write(st.nextToken()+"/");
                                fw2.write(st.nextToken()+"/");
                                fw2.write(st.nextToken()+"\r\n");
                        }
                            
                            
                            br2.close();
                            fw2.flush();
                            fw2.close();
                            File fwd = new File(getRuta2());
                            fwd.delete();
                            
                    }catch(NoSuchElementException e){}
                    
                }catch(IOException e){}
            }
    
    }
    
    public void Borrar(){
        Comprobacion();
        String codigo;
        String cadena;
        String cadena2;
        int i=0;
        boolean entra = false;
        
        if(getEvaluar()==true){
                try{
                    try{ 
                        FileWriter fw=new FileWriter(getRuta2());
                        BufferedWriter bw=new BufferedWriter(fw);       
                        FileReader f = new FileReader(getRuta());
                        BufferedReader br = new BufferedReader(f); 
                       
                        
                        while((cadena = br.readLine())!=null){
                         StringTokenizer st=new StringTokenizer(cadena,"/");
                         codigo = st.nextToken();
                            if(codigo.equals(getCod())){
                                fw.write("");
                                fw.write("");
                                fw.write("");
                                entra = true;
                            }
                            else{
                                fw.write(codigo+"/");
                                fw.write(st.nextToken()+"/");
                                fw.write(st.nextToken()+"\r\n");
                            }
                        }
                        if(entra==false){
                             JOptionPane.showMessageDialog(null, "El registro que busca no existe o esta mal escrito PorFavor intentelo denuevo");  
                        }
                        br.close();
                        fw.flush();
                        fw.close();
                       
                        FileWriter fw2=new FileWriter(getRuta());
                        BufferedWriter bw2=new BufferedWriter(fw2);
                        FileReader f2 = new FileReader(getRuta2());
                        BufferedReader br2 = new BufferedReader(f2);
                     
                        while((cadena2 = br2.readLine())!=null){
                        StringTokenizer st=new StringTokenizer(cadena2,"/");
                                fw2.write(st.nextToken()+"/");
                                fw2.write(st.nextToken()+"/");
                                fw2.write(st.nextToken()+"\r\n");
                        }
                            
                            
                            br2.close();
                            fw2.flush();
                            fw2.close();
                            File fwd = new File(getRuta2());
                            fwd.delete();
                            
                    }catch(NoSuchElementException e){}
                    
                }catch(IOException e){}
            }
    }
    
}


   
   

