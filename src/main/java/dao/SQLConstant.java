package dao;

/**
 * Classe qui contient toutes les constantes
 */
public class SQLConstant {

    // requête pour insérer un auteur
    static final String INSERT_AUTEUR = "INSERT INTO author (last_name, first_name) VALUES(?,?)";

    // requête pour supprimer un auteur par id
    static final String DELETE_AUTEUR =  "DELETE FROM author WHERE id = ?";

    // requête pour updater un auteur par id
    static final String UPDATE_AUTEUR =  "UPDATE author set first_name = ?, last_name = ? WHERE id = ?";


    // requête pour trouver un auteur par id
    static final String SELECT_AUTEUR_BY_ID =  "Select * FROM author WHERE id = ?";


    // requête pour trouver un auteur par son nom
    static final String SELECT_AUTEUR_BY_NAME =  "Select * FROM author WHERE last_name = ?";

    //requête pour afficher tous les auteurs
    static final String SELECT_ALL =  "Select * FROM author";

}
