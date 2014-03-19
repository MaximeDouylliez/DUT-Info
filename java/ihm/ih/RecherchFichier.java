import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.io.IOException;
public class RecherchFichier extends JFrame
{
private JLabel titre;
private JLabel localisation;
private JLabel tarif;
private JLabel acces;
private JLabel horaire;
private JLabel service;
private JLabel oblig;

    public RecherchFichier(JButton j)
    {
        
        titre=new jLabel("Recherche de site");
        localisation =new jLabel("Localisation");
        tarif =new jLabel("Tarif");
        acces =new jLabel("Acces");
        horaire =new jLabel("Horaire");
        service =new jLabel("Service");
        oblig =new jLabel("* Champ obligatoire");
    }

}
