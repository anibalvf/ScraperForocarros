/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrapinganibal;
import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
 
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 *
 * @author anibal
 */
public class DownloadImages {
 
   int cont=0;
 
    //The path of the folder that you want to save the images to
    private  String folderPath = "C:\\Users\\aniba\\Desktop\\testfc";
 
    public void DWI(String url) {
 
        try { 
 
            
            Document doc = Jsoup.connect(url).get();//Conectamos con la pagina y guardamos todo en doc
 
            
            Elements img = doc.getElementsByTag("img"); //filtramos todas las images con la etiquera "img" y las Guardamos en IMG que es un "arraylist" de imagenes las cuales sacamos de doc
 
            for (Element el : img) { //bucle para recorrer todos los elemenetos de IMG arrayList de imagenes
                    if (el.className().equals("imgpost")) {
                        
                String src = el.absUrl("src"); //de cada imagen sacamos el src que nos lleva al source
                
                getImages(src); //metodo para guardar la imagen
                            
                
                }
                
              
                
            }
 
        } catch (IOException ex) {
            System.err.println("ERROR Revisa los parametros");
            Logger.getLogger(DownloadImages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private void getImages(String src) throws IOException {
        String aux="/";
        
//        String folder = null; //inicializamos el string que contiene el directorio de la carpeta donde queramos guardar imagenes
 
       
//        int indexname = src.lastIndexOf("/"); //extrae el nombre de la imagen desde el link o src
// 
//        if (indexname == src.length()) {
//            src = src.substring(1, indexname);
//        }
//        
       
        //indexname = src.lastIndexOf("/");
        
       // String name = src.substring(indexname, src.length()); // asigna un nombre a la imagen para guardarla
        String name1 = aux+=cont;
       // System.out.println(name);
 
        //Open a URL Stream
        URL url = new URL(src);
       
        InputStream in = new BufferedInputStream(url.openStream()) ;
        
         HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
         httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
         
     
 	
        
 
        OutputStream out = new BufferedOutputStream(new FileOutputStream( folderPath+ name1+".jpg"));
 
        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.close();
        in.close();
        cont++;
    }
}    

