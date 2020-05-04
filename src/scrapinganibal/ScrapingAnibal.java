
package scrapinganibal;

import java.io.IOException;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.swing.*;


public class ScrapingAnibal {

    
    public static void main(String[] args) throws IOException {
        Iu etiqueta = new Iu();
//        String hd="+hd";
//      try{
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
//      }
      
      etiqueta.setBounds(0,0,800,850);
      etiqueta.setVisible(true);
      etiqueta.setLocationRelativeTo(null);
        
      
      
        
    }
    
}
