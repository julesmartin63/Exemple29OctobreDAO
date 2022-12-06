package controlleur;

import connection.Myconnection;
import dao.AuteurDAO;
import dao.CommonDAO;
import entity.Auteur;


import java.sql.Connection;
import java.util.ArrayList;


public class Appli {
    public static void main(String[] args) {
        //On connecte
        Connection connection = Myconnection.getInstance();
        CommonDAO<Auteur> auteurCommonDAO = new AuteurDAO(connection);

        // On crée un nouvel auteur
        System.out.println("\n");
        System.out.println("Creation d'un nouvel auteur");
        Auteur auteur1 = new Auteur("Jonathan", "Belanger");
        auteurCommonDAO.create(auteur1);
        System.out.println(auteur1.toString());
        System.out.println("\n");

        //delete par id
        System.out.println("Supprimer un auteur par son Id (3)");
        Auteur auteur2 = new Auteur();
        auteur2.setId(3);
        auteurCommonDAO.delete(auteur2);
        System.out.println(auteur2.toString());
        System.out.println("\n");

        //update par id
        System.out.println("Modifier un auteur par son Id (5)");
        Auteur auteur3 = new Auteur(5,"Jonathan","Belanger-Campeau");
        auteurCommonDAO.update(auteur3);
        System.out.println(auteur3.toString());
        System.out.println("\n");

        //trouver un auteur par id
        System.out.println("Retourner un auteur par son id (1)");
        int id = 1;
        Auteur auteur4 = auteurCommonDAO.findById(id);
        System.out.println(auteur4.toString());
        System.out.println("\n");


        //trouver un auteur par nom
        System.out.println("Retourner un auteur par son nom (Adel)");
        String nom = "Adel";
        Auteur auteur5 = auteurCommonDAO.findByName(nom);
        System.out.println(auteur5.toString());
        System.out.println("\n");



        //retourner tous les auteurs
        System.out.println("Retourner tous les auteurs");
        ArrayList auteurs = auteurCommonDAO.findAll();
        for(Object tmp: auteurs){
            System.out.println(tmp.toString());
        }



    }
}
