
package scrapinganibal;
import java.awt.Color;
import java.awt.Container;
import javax.swing.*; // importa la libreria para hacer interfaces graficas
import java.awt.event.*; // importa la libreria para controlar eventos
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Iu extends JFrame implements ActionListener{ // mi clase llamada Iu hereda las caracteristicas de JFrame y le implementao la escucha de eventos
    
  // private JLabel labelUNO; // etiqueta normal
   private JLabel titulop; // etiqueta normal
   private JButton cerrar,abrirTodos; // boton normal
   private JTextField rellenar; // cuadro para rellenar de texto
   private JButton opcion1,opcion2,opcion3,opcion4; // mas botones
   private JTextArea textarea; // text area
   private JScrollPane scroll;// el scroll del texArea
   private JMenuBar menubar; // Añade un menubar
   private JMenu menu; // añade un componente al menubar
   private JMenuItem menuitem1, menuitem2; // añade componentes dentro del menu
   private JLabel Seleccion;
   private JTextField rellenarURL;
   private JLabel imagencab;
  
   
   public Iu(){
       
   
   setLayout(null); // para inicializar la iu
   setTitle("FCScraperByAnibal"); // el titulo arriba del programa
   setIconImage(new ImageIcon(getClass().getResource("\\resources\\icon.jpg")).getImage()); // el icono del programa
   
   //ImageIcon imagen = new ImageIcon("\\resources\\cabez.jpg");
   
   imagencab= new JLabel(); //inicializamos la etiqueta con el contenido
   imagencab.setBounds(35,30,100,200); // donde queremos que este la etiqueta dentro de la iu
   add(imagencab); // añadimos la etiqueta 
   
    
   
   
   //creacion del menu
   menubar = new JMenuBar(); //inicializo la Barra del menu
   setJMenuBar(menubar);// la añadimos con el metodo setJmenubar
   
   //añadiendo funcionalidades al menu
   menu = new JMenu("Opciones"); // se inicicializa el menu 
   menubar.add(menu); // se añade a la menubar
   
   //añadir opciones dentro del desplegable de menu
   menuitem1 = new JMenuItem("Color"); // lo inicializamos la opcion de la barra de menu con el nombre que queramos
   menuitem1.addActionListener(this);// le añadimos al actionListener para capturar el evento
   menu.add(menuitem1);// lo añadimos a la opcion del menu
   
   menuitem2 = new JMenuItem("Eden Gay");
   menuitem2.addActionListener(this);
   menu.add(menuitem2);
   
   
   
   
   //creacion de los elementos de la interfaz  
   
//   labelUNO= new JLabel("Anibal forocoches"); //inicializamos la etiqueta con el contenido
//   labelUNO.setBounds(35,200,200,300); // donde queremos que este la etiqueta dentro de la iu
//   add(labelUNO); // añadimos la etiqueta 
   
   titulop= new JLabel("FOROCOCHES Scrapper By Anibalvf ");
   titulop.setBounds(290,10,300,30);
   add(titulop);
   
   Seleccion = new JLabel("");
   Seleccion.setBounds(365,65, 100, 30);
   add(Seleccion);
   
   
   
   textarea=new JTextArea(); // inicializamos el text area
   scroll= new JScrollPane (textarea); // inicializamos el scroll panel añadiendo el textarea en el
   scroll.setBounds(200,100,398,350); // de damos los valores al scroll panel
   add(scroll);
   
   
   cerrar= new JButton("Cerrar"); // inicializamos el boton
   cerrar.setBounds(500, 600, 100, 30); // donde queremos el boton
   add(cerrar);// añadimos el boton
   cerrar.addActionListener(this); // le añadimos la espera del "evento" 
   
  
   //boton para abrir todos los enlaces que haya en pantalla
   abrirTodos= new JButton("Abrir Todos");
   abrirTodos.setBounds(30,600,150,30);
   add(abrirTodos);
   abrirTodos.addActionListener(this);
    
   opcion1= new JButton("Obtener +HD"); 
   opcion1.setBounds(30, 100, 150, 30); 
   add(opcion1);
   opcion1.addActionListener(this); 
   
    
   opcion2= new JButton("Obtener +PRV"); 
   opcion2.setBounds(30, 200, 150, 30); 
   add(opcion2);// añadimos el boton
   opcion2.addActionListener(this); 
   
    
   opcion3= new JButton("Busqueda por palabra"); 
   opcion3.setBounds(30, 500, 250, 30); 
   add(opcion3);
   opcion3.addActionListener(this);
   
   opcion4= new JButton("Descargar img de post"); 
   opcion4.setBounds(30, 550, 250, 30); 
   add(opcion4);
   opcion4.addActionListener(this); 
   
   rellenar = new JTextField(); // es un recuadro para recoger codigo
   rellenar.setBounds(300,500,300,30);
   add(rellenar);
   
   rellenarURL = new JTextField(); //rellenar con url para descargar imagenes del post
   rellenarURL.setBounds(300,550,300,30);
   add(rellenarURL);
   
   
   }
   
   
   

    @Override
    public void actionPerformed(ActionEvent e) { //Aqui capturamos el evento
       Scraper scr = new Scraper();
       
      
       Container fondo = this.getContentPane();
       
        if (e.getSource()== cerrar) { //e.getSource lo que hace es comparar el evento y ver si coincide con el boton
            System.exit(0); // accion de cerrar el programa
        }
        if (e.getSource()== opcion1) {
            String en = "+hd";
            
          //  labelUNO.setText("Opcion +HD Seleccionada"); // accion de escribir en una etiqueta
            
            textarea.setText(scr.SacarHD(en));
            Seleccion.setText("+HD");

            
        }
        if (e.getSource()== opcion2) {
             String en = "+pvr";
          //  labelUNO.setText("Opcion +PVR Seleccionada");
             textarea.setText(scr.SacarHD(en));
             Seleccion.setText("+PVR");

        }
        if (e.getSource()== opcion3) {
            String en = rellenar.getText().toLowerCase();
          //  labelUNO.setText("Opcion Palabra ");
            
            textarea.setText(scr.SacarHD(en)); 
            Seleccion.setText(rellenar.getText());
        }
        
        if (e.getSource()== menuitem1) {
            fondo.setBackground(new Color(0,255,255)); // cambiar el color de fondo
            
            
        }
        if(e.getSource()== menuitem2){
            setSize(1000,1000);   // cambiar la resolucion de la ventana
        }
        if(e.getSource()==abrirTodos){
            if (Seleccion.getText().isEmpty()) {
                
            }else{
            scr.abrirNavegador(Seleccion.getText().toLowerCase());
            }
            }
        if (e.getSource()==opcion4) {
            DownloadImages dw = new DownloadImages();
         //   labelUNO.setText("Opcion Descargar IMG");
            textarea.setText("Imagenes descargadas en carpeta");

            try {
               dw.DWI(rellenarURL.getText());
           } catch (IOException ex) {
               Logger.getLogger(Iu.class.getName()).log(Level.SEVERE, null, ex);
           }
           
            
        }
        
    }
    
}
