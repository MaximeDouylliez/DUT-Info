import javax.swing.*;
import java.awt.*;
import java.util.*
;
public class Graph extends JFrame {

public Graph(ArrayList<Integer> j){



    setTitle("Histogramme des notes");
    setSize(1550,750);
    setVisible(true);
    Container c= getContentPane();
    
    JAbdel pan=new JAbdel(j);
    
    c.add(pan);}}


