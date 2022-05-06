/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.scene.Group;
import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 * @author IEUser
 */
public abstract class Figure {
    private Treillis treillis ;
    
    
    public Figure (){
        this.treillis = null;
    }

 
   public abstract double maxX();
   
   public abstract double minX();

   public abstract double maxY();

   public abstract double minY();
   public abstract double distanceNoeud(Noeud p);
  // public abstract Groupe dessine(GraphicsContext context);
   
    public abstract Group dessine();
   
    
    public abstract void save(Writer w, Numeroteur<Figure> num) throws IOException;
    
    
   public void sauvegarde(File fout) throws IOException {
        Numeroteur<Figure> num = new Numeroteur<Figure>();
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fout))) {
            this.save(bout, num);
        }
    }
   
   public static Figure lecture(File fin) throws IOException {
        Numeroteur<Figure> num = new Numeroteur<Figure>();
        Figure derniere = null;
        try (BufferedReader bin = new BufferedReader(new FileReader(fin))) {
            String line;
            while ((line = bin.readLine()) != null && line.length() != 0) {
                String[] bouts = line.split(";");
                if (bouts[0].equals("NoeudSimple")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    
                    Noeud np = new NoeudSimple(px,py);
                    num.associe(id, np);
                    derniere = np;
                    
                } else if (bouts[0].equals("AppuiSimple")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    
                    Noeud np = new AppuiSimple(px,py);
                    num.associe(id, np);
                    derniere = np;
                }else if (bouts[0].equals("AppuiGlissant")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    
                    Noeud np = new AppuiGlissant(px,py);
                    num.associe(id, np);
                    derniere = np;
                }
                else if (bouts[0].equals("Segment")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idP1 = Integer.parseInt(bouts[2]);
                    int idP2 = Integer.parseInt(bouts[3]);
                    
                    Noeud n1 = (Noeud) num.getObj(idP1);
                    Noeud n2 = (Noeud) num.getObj(idP2);
                    Barre nb = new Barre(n1, n2);
                    num.associe(id, nb);
                    derniere = nb;
                } else if (bouts[0].equals("Treillis")) {
                    int id = Integer.parseInt(bouts[1]);
                    Treillis nt = new Treillis();
                    num.associe(id, nt);
                    for (int i = 2; i < bouts.length; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        Figure fig = num.getObj(idSous);
                        nt.add(fig);
                    }
                    derniere = nt;
                }
            }

        }
        return derniere;
    }

  

    /**
     * @param treillis the treillis to set
     */
    public void setTreillis(Treillis treillis) {
        this.treillis = treillis;
    }

    /**
     * @return the treillis
     */
    public Treillis getTreillis() {
        return treillis;
    }
   
   
   
   
   
   
   
}
