/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrapinganibal;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WebScrap {
    public String link; // el link de la pagina
    public Document doc; // donde guardo toda la pagina
    
   
    
    public WebScrap(String url){
        this.link = url;
        try{
            this.doc = Jsoup.connect(this.link).get();
        }catch(IOException e){
          e.printStackTrace();
        }
    }
    
    
    
    
//    public Document defalutWeb (){
//        Document doc;
//        
//        
//        return docs;
//    }
    
            
            
            
            
//            try{
//          //rellenar el documento con el http
//          Document doc = Jsoup.connect("https://www.forocoches.com/").get();
//      
//      //obtener el titulo de la pagina
//      String titulo = doc.title();
//      System.out.println("Titulo: "+ titulo  );
//          
//       //obtener los links de la pagina
//      Elements links= doc.select("a[href]");
//
//      
//      for(Element link:links){
//          
//          if (link.text().toLowerCase().contains(hd)) {
//             
//              System.out.println("Titulo "+link.text());//nos saca el texto del link
//              
//              System.out.println("Link: "+ link.attr("href")); // nos saca todos los links
//              System.out.println("");
//          }
//          
//          
//     
//      }
//      
//      
//      
//      
//      }
//      catch(IOException e){
//          e.printStackTrace();
//    
    
}
