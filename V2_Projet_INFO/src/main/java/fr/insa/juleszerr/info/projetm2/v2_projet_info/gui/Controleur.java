/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info.gui;

import fr.insa.juleszerr.info.projetm2.v2_projet_info.AppuiGlissant;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.AppuiSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Barre;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Figure;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Materiau;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Noeud;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.NoeudSimple;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Treillis;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.Vecteur2d;
import fr.insa.juleszerr.info.projetm2.v2_projet_info.terrain3;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;
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
    
    private Noeud clic;
    private Barre barreProche;
    
    private double pyTerrainHori;
    private boolean premierTerrain = true;
    private boolean isostatique = false;
    private boolean resolu = false;
    public int effortMax = 500;
    public String choixDuMateriaux;
    
    private List<Figure> selection;
    
    private Vecteur2d force;

    
    

   
    

    

    
     
        
    public enum Etat {DEBUT, SELECT , SUPPR, RESOUDRE, NAN, AFFICHE_TRAX_COMP,
    NOEUDSIMPLE , APPUIGLISSANT, APPUISIMPLE, 
    BARRE_N1_LIBRE, BARRE_N1_NOEUD, BARRE_N2_LIBRE, BARRE_N2_NOEUD, 
    TERRAIN_N1, TERRAIN_N2, TERRAIN_N3, TERRAIN_HORI_N1,TERRAIN_HORI_N2,TERRAIN_HORI_N3,
    APPLIQUER_FORCE}

    
    public Controleur(MainPane vue){
        this.vue = vue;
        this.selection = new ArrayList<>();
        this.force = new Vecteur2d(0, -500);
    }
    
    public void changeEtat(Etat nouvelEtat){
        
        Treillis treillis = this.vue.getTreillis();
        this.isostatique = treillis.Isostatique();
        
        if (treillis.noeuds3().size()==0 ||  isostatique == false){
            this.vue.getOutilsRight().getbResol().setDisable(true);
        } else {
            this.vue.getOutilsRight().getbResol().setDisable(false);
        }
        if (nouvelEtat == Etat.SELECT){
            this.resolu = false;
            this.getSelection().clear();
            this.vue.redrawAll();
        }
        else if (nouvelEtat == Etat.NOEUDSIMPLE){
            this.resolu = false;
            this.getSelection().clear();            
            this.vue.redrawAll();
            //this.vue.getOutilsRight().getbCouleur
        }else if (nouvelEtat == Etat.APPUIGLISSANT){
            this.resolu = false;
            this.getSelection().clear();            
            this.vue.redrawAll();
            
        }else if (nouvelEtat == Etat.APPUISIMPLE){
            this.resolu = false;
            this.getSelection().clear();            
            this.vue.redrawAll();
            
        }else if (nouvelEtat == Etat.BARRE_N1_LIBRE){
            this.resolu = false;
            this.getSelection().clear();            
            this.vue.redrawAll();

        }else if (nouvelEtat == Etat.BARRE_N2_LIBRE){

        }else if (nouvelEtat == Etat.TERRAIN_N1){
            this.resolu = false;
            this.getSelection().clear();            
            this.vue.redrawAll();
            
        }else if (nouvelEtat == Etat.TERRAIN_N2){
            
        }else if (nouvelEtat == Etat.TERRAIN_N3){
            
        }else if (nouvelEtat == Etat.APPLIQUER_FORCE){
            this.resolu = false;
            this.getSelection().clear();            
            this.vue.redrawAll();
        }else if(nouvelEtat == Etat.RESOUDRE){
            this.resolu = false;
            this.getSelection().clear();            
            this.vue.redrawAll();
    }
        this.setEtat(nouvelEtat);
        
    }
    
    public void clicDansDessin(MouseEvent t)  {
        
        
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
                System.out.println("selection"+this.selection.toString());
                this.vue.redrawAll();
            }
        }else if(this.getEtat() == Etat.NOEUDSIMPLE) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis = this.vue.getTreillis();
            if(t.isControlDown()){
                if(t.isShiftDown()){
                    Noeud nclic = new NoeudSimple(t.getX(), t.getY());
                    Barre b = this.vue.getTreillis().barrePlusProche(nclic, 20);
                    treillis.poserNoeudSimple(b,b.longueurBarre()/2);
                }else{
                Noeud nclic = new NoeudSimple(t.getX(), t.getY());
                Barre b = this.vue.getTreillis().barrePlusProche(nclic, 20);
                treillis.ProjeterNoeud(nclic, b);                
                }                  
            }else{NoeudSimple n =new NoeudSimple(px , py); 
            treillis.add(n);
            }           
            this.vue.redrawAll();
        }else if (this.getEtat() == Etat.APPUISIMPLE) {
            Noeud nclic = new AppuiSimple(t.getX(), t.getY());
            Barre b = this.vue.getTreillis().barrePlusProche(nclic, 20);
            double px = t.getX();
            double py = t.getY();            
            Treillis treillis = this.vue.getTreillis();
            if(t.isControlDown()){                
                treillis.ProjeterNoeud(nclic, b);
            }else{
            treillis.poserAppuiSimple(b, b.longueurBarre()/2);
            }
            this.vue.redrawAll();            
        }else if (this.getEtat() == Etat.APPUIGLISSANT) {
            System.out.println(this.vue.getTreillis().getBarres());
            Noeud nclic = new AppuiGlissant(t.getX(), t.getY());
            Barre b = this.vue.getTreillis().barrePlusProche(nclic, Double.MAX_VALUE);
            double px = t.getX();
            double py = t.getY();            
            Treillis treillis = this.vue.getTreillis();
            if(t.isControlDown()){                
                treillis.ProjeterNoeud(nclic, b);
            }else{
            treillis.poserAppuiGlissant(b, b.longueurBarre()/2);   //TO DO: récupérer l'endroit exacte ou poser l'appui
            }
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
                Barre b = new Barre(new NoeudSimple(px, pos1[1]), new NoeudSimple(pos1[0], pos1[1]));                      
                treillis.add(b); 
            }else if( t.isShiftDown()){
                Barre b = new Barre(new NoeudSimple(pos1[0], py), new NoeudSimple(pos1[0], pos1[1]));                      
                treillis.add(b);
            }else{
                Barre b = new Barre(new NoeudSimple(px, py), new NoeudSimple(pos1[0],pos1[1] ));                      
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
        }else{
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
                 new NoeudSimple(px, py));
                               
                treillis.addterrain3(ter);
            }
            this.vue.redrawAll();
            this.changeEtat(Etat.TERRAIN_N1);
       
        }else if (this.getEtat() == Etat.TERRAIN_HORI_N1) {
            if(this.premierTerrain == true){
                System.out.println("Terrain hor");
                this.pos1[0]=t.getX();
                this.pos1[1]=t.getY(); 
                premierTerrain = false;
            }else{
                this.pos1[0]=t.getX();
            }
            
            this.changeEtat(Etat.TERRAIN_HORI_N2); 
        }else if (this.getEtat() == Etat.TERRAIN_HORI_N2) {
            this.pos2[0]=t.getX();
            this.pos2[1]=t.getY();
            this.changeEtat(Etat.TERRAIN_HORI_N3); 
        }else if (this.getEtat() == Etat.TERRAIN_HORI_N3) {
            double px = t.getX();
            double py = t.getY();
            Treillis treillis =this.vue.getTreillis(); 
            terrain3 ter = new terrain3(new NoeudSimple(pos1[0],pos1[1]),
                 new NoeudSimple(pos2[0], pos1[1]),
                 new NoeudSimple(px, py));                               
            treillis.addterrain3(ter);            
            this.vue.redrawAll();
            this.changeEtat(Etat.TERRAIN_HORI_N1);
       
        }else if (this.getEtat() == Etat.APPLIQUER_FORCE){
            Treillis treillis =this.vue.getTreillis(); 
            NoeudSimple nclic = new NoeudSimple(t.getX(),t.getY());
            Noeud proche = this.vue.getTreillis().NoeudPlusProche(nclic, 20);
            proche.setForce(force);
            this.vue.redrawAll();
        }else if(this.getEtat()==Etat.SUPPR){
            Treillis treillis =this.vue.getTreillis(); 
            NoeudSimple nclic = new NoeudSimple(t.getX(),t.getY());
            Figure proche = this.vue.getTreillis().plusProche(nclic, 50);
            if(proche==null) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Aucune figure sur le dessin \n "+"ou cliquez plus près d'une figure ");
                alert.showAndWait(); 
                this.changeEtat(Etat.SUPPR);
        }else {
            treillis.remove(proche);
            System.out.println("Figure supprimée");
            this.vue.redrawAll();
            this.changeEtat(Etat.SUPPR);
        }
            
       
    }
        this.clic = new NoeudSimple(t.getX(),t.getY());
        this.barreProche = this.vue.getTreillis().barrePlusProche(clic, Double.MAX_VALUE);
        if(this.barreProche !=null){
            this.vue.getGrille().actualiseGrille();
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

    void boutonTerrainLibre(ActionEvent t) {
        this.changeEtat(Etat.TERRAIN_N1);
    }
    
    void boutonTerrainHori(ActionEvent t) {
        this.changeEtat(Etat.TERRAIN_HORI_N1);
    }
    
    void boutonSelect(ActionEvent t) {
        this.changeEtat(Etat.SELECT);
    }
        
    void boutonBarreLibre(ActionEvent t) {
        this.changeEtat(Etat.BARRE_N1_LIBRE);
    }
    
    void boutonForce(ActionEvent t) {
        this.changeEtat(Etat.APPLIQUER_FORCE);
    }
    
    void boutonSuppr(ActionEvent t) {
        if (this.etat == Etat.SELECT && this.selection.size() > 0) {
            // normalement le bouton est disabled dans le cas contraire
            this.vue.getTreillis().removeAll(this.selection);
            this.selection.clear();
            
            this.vue.redrawAll();
            this.changeEtat(Etat.SUPPR);
        }else{
            this.changeEtat(Etat.SUPPR);
        }
    }
    
    void boutonResoudre(ActionEvent t) {
        this.changeEtat(Etat.RESOUDRE);
        try {
            
            Treillis treillis =this.vue.getTreillis(); 
            treillis.Resolution();
        } catch (Error ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Le treillis n'est pas soluble");
            alert.setContentText(ex.getLocalizedMessage());

            alert.showAndWait();
        } finally {
            this.resolu = true;
            this.vue.redrawAll();
            this.changeEtat(Etat.NAN);

            
        }       
        
    }

    void boutonTestIsostaticite() {
        Treillis treillis = this.vue.getTreillis();
        Dialog alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Teste isostaticité");
        alert.setHeaderText(null);
        int barresIso = treillis.RoadToIsostatique();
        
        this.isostatique = treillis.Isostatique();
        System.out.println(isostatique);
        alert.setContentText("barres iso"+barresIso);
        if(barresIso<0){
                alert.setContentText("Le treillis n'est pas isostatique, "
                          + "veuilliez retirer "+ -barresIso +" barres."); 
                this.changeEtat(Etat.SUPPR);
        }else if (barresIso > 0) {
            alert.setContentText("Le treillis n'est pas isostatique, "
                            + "veuilliez rajouter "+ barresIso +" barres.");
            this.changeEtat(Etat.BARRE_N1_NOEUD);
        }else{                    
            alert.setContentText("Le treillis est bien isostatique!"); 
            this.changeEtat(Etat.NAN);
        }
        
        //alert.showAndWait();
        alert.setWidth(500);
        alert.showAndWait();
        
    }
    
    
    void boutonAide() {
       Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Fonctionnement");
        alert.setHeaderText(null);
        alert.setContentText("1. création ou lecture d’un treillis \n" +
"2. modifications et teste isostatique \n" +
"3. réglages et applications des forces au treillis \n" +
"3. mise en équation et résolution du treillis  \n" +
"4. admirer le résultat !");

        alert.setResizable(true);
        
        alert.showAndWait(); 
    }
    
    
    void boutonDefTreillis(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Fonctionnement");
        alert.setHeaderText(null);
        alert.setContentText("Se référer au manuel");

        //alert.showAndWait();
        alert.setWidth(500);
        alert.showAndWait();
    }
    
    void boutonAfficheTraxComp() {
        this.changeEtat(Etat.AFFICHE_TRAX_COMP);   
        this.vue.redrawAll();
    }
    
    void menuNouveau(ActionEvent t) {
        Stage nouveau = new Stage();
        nouveau.setTitle("Nouveau");
        Scene sc = new Scene(new MainPane(nouveau), 1500,850);
        vue.setStyle("-fx-background-color: #fdfbf3; ");
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
                Scene sc = new Scene(new MainPane(nouveau, f, glu), 1500,850);
                vue.setStyle("-fx-background-color: #fdfbf3; ");
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
        alert.setContentText("Création de noeud:\n"
                + "     Noeud simple: Ctrl -> pose d'un noeud simple sur  une barre \n"
                + "     Appui Simle: Ctrl -> pose d'un appui simple sur  une barre\n"
                + "     Appui Glissant;Ctrl -> pose d'un appuyi glissant sur  une barre\n"
                + "Création de barres libre:\n"
                + "     Ctrl: barre horizontale\n"
                + "     Shift: barre verticale\n"
                + "Création de barre a partir de noeudss:\n"
                +"      Ctrl: creation de barre a partir d'un noeud et d'un clic libre \n"
                +"      Shift: création de barre horizontale/verticale\n"
                
        );
        alert.setResizable(true);
        
        
        alert.showAndWait();
    }
    
    void menuApropos(ActionEvent t) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText(null);
        alert.setContentText("Ceci n'est pas une section à propos.");

        //alert.showAndWait();
        alert.setWidth(500);
        alert.showAndWait();
    }

   

    void boutonBarreDepuisNoeud(ActionEvent t) {
        this.changeEtat(Etat.BARRE_N1_NOEUD);
    }
     /*private void activeBoutonsSuivantSelection() {
        
        this.vue.getOutilsRight().getbSuppr().setDisable(true);
        if (this.getEtat() == Etat.SELECT) {
            if (this.getSelection().size() > 0) {
                this.vue.getOutilsRight().getbSuppr().setDisable(false);
                if (this.getSelection().size() > 1) {
                    //this.vue.getOutilsRight().getbGrouper().setDisable(false);
                }
            }
        }
    }*/

    
    void boutonParametreForce() {
        Optional<Vecteur2d> forceDialog = DialogParametreForce.demandeForce();
        if(forceDialog.isPresent()){
            this.force = forceDialog.get();
        }
    }

    void boutonParametreMateriau() {
        Optional<Materiau> materiauDialog = DialogParametreMateriaux.demandeMateriau();
        if(materiauDialog.isPresent()){
            this.vue.getTreillis().setMateriau(materiauDialog.get());
        }
        System.out.println("materiau "+Treillis.materiau);
        this.vue.redrawAll();
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

    /**
     * @return the barreProche
     */
    public Barre getBarreProche() {
        return barreProche;
    }

    /**
     * @return the resolu
     */
    public boolean isResolu() {
        return resolu;
    }
}
