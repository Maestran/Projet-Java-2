/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulletinenpdf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import notesElevesProfesseurs.*;


/*
Cette classe est une classe de test pour la V3
*/
public class BulletinTest {

    public static void main(String[] args) { 
       
 
        try {
            CSV_Loader.chargerFichierEleves("Data\\élèves.csv");    // On charge les données
         
            CSV_Loader.chargerEvaluations("Data\\Résultats élèves.csv"); 
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Veuiller saisir un id d'élève");
            
            int val = scan.nextInt();
            if(Promotion.rechercherElevePartout(val) != null)
            {
                Eleve a = Promotion.rechercherElevePartout(val);
                Bulletin bul = new Bulletin(a);
                bul.creerBulletin();
                System.out.println("Le bulletin a été généré dans le fichier resultat");
                
            }
            else
            {
                System.out.println("Erreur, l'élève n'existe pas ... END");
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
             
    }
}