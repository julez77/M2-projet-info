/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.AppuiGlissant;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.AppuiSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Barre;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Figure;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Noeud;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.NoeudSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Vecteur2d;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.terrain3;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author IEUser
 */
public class Controleur {
    private MainPane vue;
    private Etat etat;
    
    private Noeud nPosClic ;
    private double[] pos1 = new double[2];
    private double[] pos2 = new double[2];
    
    private List<Figure> selection;

    

   
   
    

   
    public enum Etat {DEBUT, SELECT , SUPPR, RESOUDRE,
    NOEUDSIMPLE , APPUIGLISSANT, APPUISIMPLE, 
    BARRE_N1_LIBRE, BARRE_N1_NOEUD, BARRE_N2_LIBRE, BARRE_N2_NOEUD, BARRE_PARA,
    TERRAIN_N1, TERRAIN_N2, TERRAIN_N3}

    
    public Controleur(MainPane vue){
        this.vue = vue;
        this.selection = new ArrayList<>();
    }
    
    public void changeEtat(Etat nouvelEtat){
        System.out.println("changerEtat()");
        if (nouvelEtat == Etat.SELECT){
            this.getSelection().clear();
            this.vue.redrawAll();
        }
        else if (nouvelEtat == Etat.NOEUDSIMPLE){
            this.getSelection().clear();            
            this.vue.redrawAll();
            //this.vue.getOutilsRight().getbCouleur
        }else if (nouvelEtat == Etat.APPUIGLISSANT){
            this.getSelection().clear();            
            this.vue.redrawAll();
            
        }else if (nouvelEtat == Etat.APPUISIMPLE){
            this.getSelection().clear();            
            this.vue.redrawAll();
            
        }else if (nouvelEtat == Etat.BARRE_N1_LIBRE){
            this.getSelection().clear();            
            this.vue.redrawAll();

        }else if (nouvelEtat == Etat.BARRE_N2_LIBRE){

        }else if (nouvelEtat == Etat.TERRAIN_N1){
            this.getSelection().clear();            
            this.vue.redrawAll();
            
        }else if (nouvelEtat == Etat.TERRAIN_N2){
            
        }else if (nouvelEtat == Etat.TERRAIN_N3){
            
        }else if (nouvelEtat == Etat.BARRE_PARA){
            
        }
        this.setEtat(nouvelEtat);
        
    }
    
    public void clicDansDessin(MouseEvent t) {

        if (this.getEtat() == Etat.SELECT) {
            NoeudSimple nclic = new NoeudSimple(t.getX(),t.getY());
            Figure proche = this.vue.getTreillis().plusProche(nclic, Double.MAX_VALUE);
            if (proche != null) {
                if (t.isShiftDown()) {
                    this.selection.add(proche);
                } else if (t.isControlDown()) {
                    if (this.selection.contains(proche)) {
                        this.selection.remove(proche);
                    } else {
                        this.selection.add(proche);
                    }
                } else {
                    this.selection.clear();
                    this.selection.add(proche);
                }
                this.activeBoutonsSuivantSelection();
                System.out.println("selection"+this.selection.toString());
                this.vue.redrawAll();
            }
        }else if(this.getEtat() == Etat.NOEUDSIMPLE) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis = this.vue.getTreillis();
            NoeudSimple pessi =new NoeudSimple(px , py); 
            treillis.add(pessi);
            System.out.println("nb de noeud dans le treillis"+ treillis.getNoeuds().size());
            System.out.println("nb de noeud pris en compte"+ treillis.getNoeuds2().size());
            this.vue.redrawAll();
        }else if (this.getEtat() == Etat.APPUISIMPLE) {
            Noeud nclic = new NoeudSimple(t.getX(), t.getY());
            Barre b = this.vue.getTreillis().barrePlusProche(nclic, 20);
            double px = t.getX();
            double py = t.getY();            
            Treillis treillis = this.vue.getTreillis();
            treillis.poserAppuiSimple(b, b.longueurBarre()/2);
            this.vue.redrawAll();            
        }else if (this.getEtat() == Etat.APPUIGLISSANT) {
            System.out.println(this.vue.getTreillis().getBarres());
            Noeud nclic = new NoeudSimple(t.getX(), t.getY());
            Barre b = this.vue.getTreillis().barrePlusProche(nclic, Double.MAX_VALUE);
            double px = t.getX();
            double py = t.getY();            
            Treillis treillis = this.vue.getTreillis();
            treillis.poserAppuiGlissant(b, b.longueurBarre()/2);   //TO DO: récupérer l'endroit exacte ou poser l'appui         
            this.vue.redrawAll();
        }else if (this.getEtat() == Etat.BARRE_N1_LIBRE) {
            this.pos1[0]=t.getX();
            this.pos1[1]=t.getY();
            this.changeEtat(Etat.BARRE_N2_LIBRE);                   
        }else if (this.getEtat() == Etat.BARRE_N2_LIBRE) {           
            double px = t.getX();
            double py = t.getY();
            Treillis treillis =this.vue.getTreillis(); 
            if(t.isControlDown()){
                Barre b = new Barre(new NoeudSimple(px, py), new NoeudSimple(pos1[0], py));                      
                treillis.add(b); 
            }else if(t.isControlDown()&& t.isShiftDown()){
                System.out.println("dupliquer barre");
                Noeud nclic = new NoeudSimple(t.getX(), t.getY());
                Barre b = this.vue.getTreillis().barrePlusProche(nclic, 50);
                double taille = b.longueurBarre();
                Barre nb = new Barre(b.getNoeud1(), new NoeudSimple(b.noeudPlusProche(nclic).getPx()+taille,
                        b.getNoeud1().getPy()));
                treillis.add(nb);
            }else{
                Barre b = new Barre(new NoeudSimple(px, py), new NoeudSimple(pos1[0], pos1[1]));                      
                treillis.add(b);
            }            
            this.vue.redrawAll();
            this.changeEtat(Etat.BARRE_N1_LIBRE);
        }else if (this.getEtat() == Etat.BARRE_N1_NOEUD) {
            NoeudSimple nclic = new NoeudSimple(t.getX(),t.getY());
            Noeud proche = this.vue.getTreillis().NoeudPlusProche(nclic, Double.MAX_VALUE);
            if(proche != null){
                this.nPosClic =proche;
                //this.pos1[1]=proche.getPy();
                this.changeEtat(Etat.BARRE_N2_NOEUD);
        }
            else{
                this.changeEtat(Etat.NOEUDSIMPLE);
            }
             
            
                     
        }else if (this.getEtat() == Etat.BARRE_N2_NOEUD) {    
            NoeudSimple nclic = new NoeudSimple(t.getX(),t.getY());
            Noeud proche = this.vue.getTreillis().NoeudPlusProche(nclic, Double.MAX_VALUE);
            Treillis treillis =this.vue.getTreillis();   
            if(t.isControlDown()){
                double px = t.getX();
                double py = t.getY();
                Barre b = new Barre(new NoeudSimple(px, py), this.getnPosClic());
                this.vue.getTreillis().add(b);
                treillis.add(b);
                this.pos1 = new double[2];
            }else{
                Barre b = new Barre(proche, this.getnPosClic());
                this.vue.getTreillis().add(b);
                treillis.add(b);
                this.pos1 = new double[2];  
            }             
            this.vue.redrawAll();
            this.changeEtat(Etat.BARRE_N1_NOEUD);        
        }else if (this.getEtat() == Etat.TERRAIN_N1) {
            this.pos1[0]=t.getX();
            this.pos1[1]=t.getY();
            this.changeEtat(Etat.TERRAIN_N2); 
        }else if (this.getEtat() == Etat.TERRAIN_N2) {
            this.pos2[0]=t.getX();
            this.pos2[1]=t.getY();
            this.changeEtat(Etat.TERRAIN_N3); 
        }else if (this.getEtat() == Etat.TERRAIN_N3) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis =this.vue.getTreillis(); 
            if(t.isControlDown()){
                terrain3 ter = new terrain3(new NoeudSimple(pos1[0],pos1[1]),
                new NoeudSimple(pos2[0], pos1[1]),
                new NoeudSimple(pos2[0], py) );
            treillis.addterrain3(ter);                          
            }else{
                terrain3 ter = new terrain3(new NoeudSimple(pos1[0],pos1[1]),
                new NoeudSimple(pos2[0], pos2[1]),
                new NoeudSimple(px, py) );
                treillis.addterrain3(ter);
            }
            this.vue.redrawAll();
            this.changeEtat(Etat.TERRAIN_N1);
        }else if (this.getEtat() == Etat.BARRE_PARA){
            Treillis treillis =this.vue.getTreillis(); 
            NoeudSimple nclic = new NoeudSimple(t.getX(),t.getY());
            Noeud proche = this.vue.getTreillis().NoeudPlusProche(nclic, 20);            
            Barre b =this.vue.getTreillis().barrePlusProche(nclic, Double.MAX_VALUE);
            double dist = b.distanceNoeud(nclic);
            Barre bPara = b.barrepara(b,nclic);
            treillis.add(bPara);
            this.vue.redrawAll();
        }else if(this.getEtat()==Etat.SUPPR){
            Treillis treillis =this.vue.getTreillis(); 
            NoeudSimple nclic = new NoeudSimple(t.getX(),t.getY());
            Figure proche = this.vue.getTreillis().plusProche(nclic, Double.MAX_VALUE);
            treillis.remove(proche);
            System.out.println("Figure supprimée");
            this.vue.redrawAll();
        }else if(this.etat == Etat.RESOUDRE){
            Treillis treillis =this.vue.getTreillis(); 
            NoeudSimple nclic = new NoeudSimple(t.getX(),t.getY());
            Noeud proche = this.vue.getTreillis().NoeudPlusProche(nclic, 20);
            Vecteur2d force1 = new Vecteur2d(0, -500) ;
            Vecteur2d force2 = new Vecteur2d(0, -1000) ;        
            //proche.setForce(force1);
            treillis.Resolution();      
       
        }
    }

   

    void boutonAppuiSimple(ActionEvent t) {
        this.changeEtat(Etat.APPUISIMPLE);
    }

    void boutonNoeudSimple(ActionEvent t) {
        this.changeEtat(Etat.NOEUDSIMPLE);
    }

    void boutonAppuiGlissant(ActionEvent t) {
        this.changeEtat(Etat.APPUIGLISSANT);
    }

    void boutonTerrain(ActionEvent t) {
        this.changeEtat(Etat.TERRAIN_N1);
    }
    
    void boutonSelect(ActionEvent t) {
        this.changeEtat(Etat.SELECT);
    }
        
    void boutonBarreLibre(ActionEvent t) {
        this.changeEtat(Etat.BARRE_N1_LIBRE);
    }
    
    void boutonBarrePara(ActionEvent t) {
        this.changeEtat(Etat.BARRE_PARA);
    }
    
    void boutonSuppr(ActionEvent t) {
        this.changeEtat(Etat.SUPPR);
        if (this.etat == Etat.SELECT && this.selection.size() > 0) {
            // normalement le bouton est disabled dans le cas contraire
            this.vue.getTreillis().removeAll(this.selection);
            this.selection.clear();
            this.activeBoutonsSuivantSelection();
            this.vue.redrawAll();
        }
    }
    
    void boutonResoudre(ActionEvent t) {
        this.changeEtat(Etat.RESOUDRE);
    }
    
    
     void menuNouveau(ActionEvent t) {
        Stage nouveau = new Stage();
        nouveau.setTitle("Nouveau");
        Scene sc = new Scene(new MainPane(nouveau), 800, 600);
        nouveau.setScene(sc);
        nouveau.show(); 
     }
    private void realSave(File f) {
        try {
            this.vue.getTreillis().sauvegarde(f);
            this.vue.setCurFile(f);
            this.vue.getInStage().setTitle(f.getName());
        } catch (IOException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Problème durant la sauvegarde");
            alert.setContentText(ex.getLocalizedMessage());

            alert.showAndWait();
        } finally {
            this.changeEtat(Etat.SELECT);
        }
    }
     
     
    void menuSave(ActionEvent t) {
        if (this.vue.getCurFile() == null) {
            this.menuSaveAs(t);
        } else {
            this.realSave(this.vue.getCurFile());
        }    }

    void menuSaveAs(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(this.vue.getInStage());
        if (f != null) {
            this.realSave(f);
        }    }

    void menuOpen(ActionEvent t) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.vue.getInStage());
        if (f != null) {
            try {
                Figure lue = Figure.lecture(f);
                Treillis glu = (Treillis) lue;
                Stage nouveau = new Stage();
                nouveau.setTitle(f.getName());
                Scene sc = new Scene(new MainPane(nouveau, f, glu), 800, 600);
                nouveau.setScene(sc);
                nouveau.show();
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Problème durant la sauvegarde");
                alert.setContentText(ex.getLocalizedMessage());

                alert.showAndWait();
            } finally {
                this.changeEtat(Etat.SELECT);
            }
        }    }

    void menuRacourci(ActionEvent t) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Racourci clavier");
        alert.setHeaderText(null);
        alert.setContentText("Création de barres:\n"
                + "     Par defaut: création de barre libre \n"
                + "     Ctrl: creation de barre à partir de noeuds\n"
                + "     Ctrl+Shift: creation de barre a partir \n"
                + "     d'un noeud et d'un clic libre\n"
                + "     Shift: création de barre horizontale/verticale\n"
                + "Creation de noeuds:\n"
                + "     Par defaut: noeud simple\n"
                + "     Ctrl: appuis simple \n"
                + "     Ctrl+Shift: appuis glissant");
        alert.setResizable(true);
        //alert.setWidth(1000);
        alert.showAndWait();
    }
    
    void menuApropos(ActionEvent t) {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("A propos");
        alert.setHeaderText(null);
        alert.setContentText("A compléter");

        //alert.showAndWait();
        alert.setWidth(500);
        alert.showAndWait();
    }

    void menuAfficherBarOutils(ActionEvent t) {
        throw new UnsupportedOperationException("Ici Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void boutonBarreDepuisNoeud(ActionEvent t) {
        this.changeEtat(Etat.BARRE_N1_NOEUD);
    }
     private void activeBoutonsSuivantSelection() {
        
        this.vue.getOutilsRight().getbSuppr().setDisable(true);
        if (this.getEtat() == Etat.SELECT) {
            if (this.getSelection().size() > 0) {
                this.vue.getOutilsRight().getbSuppr().setDisable(false);
                if (this.getSelection().size() > 1) {
                    //this.vue.getOutilsRight().getbGrouper().setDisable(false);
                }
            }
        }
    }

    /**
     * @return the selection
     */
    public List<Figure> getSelection() {
        return selection;
    }

    /**
     * @return the etat
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * @return the nPosClic
     */
    public Noeud getnPosClic() {
        return nPosClic;
    }

    /**
     * @param nPosClic the nPosClic to set
     */
    public void setnPosClic(Noeud nPosClic) {
        this.nPosClic = nPosClic;
    }
}
