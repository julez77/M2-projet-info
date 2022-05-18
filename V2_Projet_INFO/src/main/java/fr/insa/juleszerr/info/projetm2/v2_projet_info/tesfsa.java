/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fr.insa.juleszerr.info.projetm2.v2_projet_info;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author corin
 */
public class tesfsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
      NoeudSimple n1 = new NoeudSimple(4 ,2);
      NoeudSimple n2 = new NoeudSimple(7 ,3);  
  ///     NoeudSimple n3 = new NoeudSimple(5 ,7);
 ///       NoeudSimple n4 = new NoeudSimple(8 ,1);
Barre  b1 = new Barre(n1,n2);
Treillis tr = new Treillis();
///tr.add(n1);
///terrain3 ter =new terrain3(n2,n3,n4);
///tr.add(ter);
//System.out.println(tr.getElements());
//System.out.println("lol");
//System.out.println(tr.getNoeuds2());
//b1=Barre.creeBarre();
tr.add(b1);
System.out.println(tr.getElements());
System.out.println("le treillis");
System.out.println(tr.getBarres());
///System.out.println("noeuds2");
///System.out.println(tr.getNoeuds2().size());
//System.out.println(tr.getBarres());





// TODO code application logic here
    }
    public static void menuInitial() throws Exception {
                int rep = -1;
        while (rep != 0) {
            System.out.println("Initialisation du Groupe de figure");
            System.out.println("----------------------------------");
            System.out.println("1) commencer avec un groupe vide");
            System.out.println("2) commencer avec le groupe de test");
            System.out.println("3) lire dans un fichier");
            System.out.println("0) quitter");
            System.out.println("votre choix : ");
            rep = Lire.i();
            if (rep == 1) {
                Treillis g = new Treillis();
                g.menuTexte();
            } else if (rep == 2) {
                Treillis g = Treillis.treillisTest();
                g.menuTexte();
            } else if (rep == 3) {
                System.out.println("répertoire courant : ");
                System.out.println(System.getProperty("user.dir"));
                System.out.println("entrez le chemin du fichier contenant le groupe de figure : ");
                String path = Lire.S();
                File fin = new File(path);
                try {
                    Figure fLue = Figure.lecture(fin);
                    if (fLue instanceof Treillis) {
                        Treillis gLu = (Treillis) fLue;
                        gLu.menuTexte();
                        System.out.println("elements");
                        System.out.println(gLu.getElements());
                        System.out.println("barres");
                        System.out.println(gLu.getBarres());
                        System.out.println("barres2");
                        System.out.println(gLu.getBarres2());
                        System.out.println("noeuds");
                        System.out.println(gLu.getNoeuds());
                        System.out.println("noeuds2");
                        System.out.println(gLu.getNoeuds2());
                        System.out.println("elemterrian3");
                        System.out.println(gLu.getElemterrain3());
                    } else {
                        System.out.println("la figure dans le fichier " + fin.getAbsolutePath() + " n'est pas un groupe");
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("fichier non trouvé : " + fin.getAbsolutePath());;
                } catch (IOException ex) {
                    System.out.println("problème de lecture : " + ex.getLocalizedMessage());;
                }
            } 
        }

    }
}
