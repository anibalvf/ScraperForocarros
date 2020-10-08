/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrapinganibal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import static scrapinganibal.Iu.folderPathV;
/**
 *
 * @author anibal
 */
public class DownloadImages {
 
    //The path of the folder that you want to save the images to
    public static String folderPath = folderPathV;
   
   
 
    public void DWI(String url) throws IOException {
        boolean enc= encMasPag(url);
        Document document = Jsoup
                .connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(10 * 1000)
                .get();
        
        if (enc) {
         Elements pagPost = document.select("td");
         for(Element td:pagPost){
         if (td.className().equals("vbmenu_control") && td.text().contains("Pág")) {
                  String almacen = td.text();
 
                  System.out.println(almacen);
                  String almacen2= almacen.substring(9);
                  System.out.println(almacen2);
                  
                  int pasarCadena = Integer.parseInt(almacen2);
                 
                 do{
                     Document document1 = Jsoup
                .connect(url+"&page="+pasarCadena)
                .userAgent("Mozilla/5.0")
                .timeout(10 * 1000)
                .get();
                     System.out.println(url+"&page="+pasarCadena);
        
        //select all img tags
        Elements imageElements = document1.select("img");
        
        //iterate over each image
            for(Element imageElement : imageElements){
                if (imageElement.className().equals("imgpost")) {
                String strImageURL = imageElement.attr("abs:src");
                //download image one by one
                downloadImage(strImageURL);
                }
            }
                 pasarCadena--;
                
             } while ( pasarCadena>0);
             
         }
         
        }
            
        }else{
              System.out.println(url);
        
        //select all img tags
        Elements imageElements = document.select("img");
        
        //iterate over each image
        for(Element imageElement : imageElements){
            if (imageElement.className().equals("imgpost")) {
                String strImageURL = imageElement.attr("abs:src");
                downloadImage(strImageURL);
            }
        }
       }
 
    }
    
    
    
    
    
        //metodo para descargar cada imagen
     private static void downloadImage(String strImageURL){
        
        //get file name from image path
        String strImageName =strImageURL.substring( strImageURL.lastIndexOf("/") + 1 );
        
        System.out.println("Saving: " + strImageName + ", from: " + strImageURL);
        
        try {
            
            //open the stream from URL
             URL urlImage = new URL(strImageURL);
             URLConnection urlc = urlImage.openConnection();
             urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; "
             + "Windows NT 5.1; en-US; rv:1.8.0.11) ");
              InputStream in = urlc.getInputStream();

            
            byte[] buffer = new byte[4096];
            int n = -1;
            
            OutputStream os =new FileOutputStream( folderPath + "/" + strImageName );
            
            //write bytes to the output stream
            while ( (n = in.read(buffer)) != -1 ){
                os.write(buffer, 0, n);
            }
            
            //close the stream
            os.close();
            
            System.out.println("Image saved");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
     
     
     
        // metodo para comprobar si el hilo tienes mas de una sola pagina 
     private boolean encMasPag(String url) throws IOException{
         boolean enc= false;
        
         Document documento3 = Jsoup
                .connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(10 * 1000)
                .get();
         
         Elements pagPosta3 = documento3.select("td");
         
         for(Element tds:pagPosta3){
        
         if (tds.className().equals("vbmenu_control") && tds.text().contains("Pág")) {
             enc= true;
             
         }}
         return enc;
     }
     
     
    }
