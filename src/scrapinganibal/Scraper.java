
package scrapinganibal;

import java.awt.Desktop;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URI;


public class Scraper {
    
    
    public String SacarHD(String en){
        
        String res= "";

     
        String hd="+hd";
      try{
          //rellenar el documento con el http
          Document doc = Jsoup.connect("https://www.forocoches.com/").get();
      
   
          
       //obtener los links de la pagina
      Elements links= doc.select("a[href]");

      
      for(Element link:links){
          
          if (link.text().toLowerCase().contains(en)) {
             
              res += "Titulo "+link.text() +"\n";
              res+="https://www.forocoches.com/"+ link.attr("href");
              res+="\n"+"\n";
          }
       }
      }
      catch(IOException e){
          e.printStackTrace();
          
      }
         
        return res;
    }
    
     
     public void abrirNavegador(String xd){
      
          try{
          //rellenar el documento con el http
          Document doc = Jsoup.connect("https://www.forocoches.com/").get();
      
   
          
       //obtener los links de la pagina
      Elements links= doc.select("a[href]");

      
      for(Element link:links){
          
          if (link.text().toLowerCase().contains(xd)) {
             try{
                 String aux="";
                 aux+="https://www.forocoches.com/"+ link.attr("href");
                 
                 Desktop.getDesktop().browse(new URI(aux));
             } catch(Exception ex){
                 
             }
              
          }
       }
      }
      catch(IOException e){
          e.printStackTrace();
      }
     }
}
