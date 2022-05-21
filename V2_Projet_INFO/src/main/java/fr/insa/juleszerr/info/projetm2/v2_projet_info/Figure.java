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
    private Terrain terrain ;

    public Figure (){
        this.treillis = null;
        this.terrain = null ;
    }

 
   public abstract double maxX();
   
   public abstract double minX();

   public abstract double maxY();

   public abstract double minY();
   public abstract double distanceNoeud(Noeud p);
   
   public abstract Group dessineSelection();
   
    public abstract Group dessine();
   
    
    public abstract void save(Writer w, Numeroteur<Figure> num) throws IOException;
    
    
   public void sauvegarde(File fout) throws IOException {
        Numeroteur<Figure> num = new Numeroteur<Figure>();
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fout))) {
            this.save(bout, num);
        }
    }
    public static void testLecture() throws Exception {
        try {
            Figure lue = Figure.lecture(new File("sauv.txt"));
            System.out.println("fig lue : " + lue);
        } catch (IOException ex) {
            throw new Error(ex);
        }
    }
   public static Figure lecture(File fin) throws IOException, Exception {
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
                    
                    NoeudSimple np = new NoeudSimple(px,py);
                    num.associe(id, np);
                    derniere = np;
                    System.out.println("noeudsimple");
                } else if (bouts[0].equals("AppuiSimple")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    
                    AppuiSimple np = new AppuiSimple(px,py);
                    num.associe(id, np);
                    derniere = np;
                    System.out.println("appuisimple");
                }else if (bouts[0].equals("AppuiGlissant")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    int posesur = Integer.parseInt(bouts[4]);
                    
                    AppuiGlissant np = new AppuiGlissant(px,py);
                    num.associe(id, np);
                    np.setPoseSur((Barre) num.getObj(posesur));
                    derniere = np;
                    System.out.println("appuiglissantl");
                }
                else if (bouts[0].equals("Barre")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idP1 = Integer.parseInt(bouts[2]);
                    int idP2 = Integer.parseInt(bouts[3]);
                    
                    Noeud n1 = (Noeud) num.getObj(idP1);
                    System.out.println("lolp1");
                    Noeud n2 = (Noeud) num.getObj(idP2);
                     System.out.println("lolp2");
                    Barre nb = new Barre(n1, n2);
                    num.associe(id, nb);
                    derniere = nb;
                    System.out.println("Barre");
                
                                }else  if(bouts[0].equals("terrain3")){
                    int id = Integer.parseInt(bouts[1]);
                   terrain3 nt = new terrain3();
                   num.associe(id, nt);
                 System.out.println("treerin3");
                 for (int i = 2; i < bouts.length; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        Figure fig = num.getObj(idSous);
                         System.out.println("lolyter");
                       if( fig instanceof Barre == true){
                           nt.addbarre((Barre) fig);
                       }
                         if( fig instanceof Noeud == true){
                           nt.addNoeud((NoeudSimple) fig);
                       }
                         
                        System.out.println("addedterrin3");
                    }
                    derniere = nt;
                
                
                } else if (bouts[0].equals("Treillis")) {
                    int id = Integer.parseInt(bouts[1]);
                    Treillis nt = new Treillis();
                    num.associe(id, nt);
                    System.out.println("treillis");
                    for (int i = 2; i < bouts.length; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        Figure fig = num.getObj(idSous);
                         System.out.println("lol");
                        nt.add(fig);
                        System.out.println("added");
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

    /**
     * @return the terrain
     */
    public Terrain getTerrain() {
        return terrain;
    }

    /**
     * @param terrain the terrain to set
     */
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }


   
}
