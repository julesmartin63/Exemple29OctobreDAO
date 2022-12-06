package dao;

import entity.Auteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuteurDAO  extends CommonDAO<Auteur> {


    public AuteurDAO(Connection connection) {
        super(connection);
    }

    /**
     * Permet d'insérer et supprimer un objet dans la bd
     *
     * @param auteur
     * @return
     */
    @Override
    public boolean create(Auteur auteur) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.INSERT_AUTEUR);
            preparedStatement.setString(1, auteur.getNom());
            preparedStatement.setString(2, auteur.getPreNom());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * @param auteur
     * @return
     */

    @Override
    public boolean delete(Auteur auteur) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.DELETE_AUTEUR);
            preparedStatement.setInt(1, auteur.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Méthode de mise à jour
     *
     * @param auteur
     * @return boolean
     */
    @Override
    public boolean update(Auteur auteur) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.UPDATE_AUTEUR);
            preparedStatement.setString(1, auteur.getPreNom());
            preparedStatement.setString(2, auteur.getNom());
            preparedStatement.setInt(3, auteur.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Récupérer l'objet à partir d'un champs de type entier
     *
     * @param id
     * @return T
     */
    @Override
    public Auteur findById(int id) {
        ResultSet resultSet = null;
        Auteur auteur = new Auteur();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_AUTEUR_BY_ID);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int index = id;
                auteur.setId(id);
                auteur.setNom(resultSet.getString("last_name"));
                auteur.setPreNom(resultSet.getString("first_name"));
            }
            return auteur;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    /**
     * Récupérer l'objet à partir d'une chaîne de caractères
     *
     * @param name
     * @return T
     */
    @Override
    public Auteur findByName(String name) {
        ResultSet resultSet = null;
        Auteur auteur = new Auteur();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_AUTEUR_BY_NAME);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                auteur.setId(resultSet.getInt("id"));
                auteur.setNom(resultSet.getString("last_name"));
                auteur.setPreNom(resultSet.getString("first_name"));
            }
            return auteur;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Récupérer tous les objets en base de données
     *
     * @return ArrayList<T>
     */
    @Override
    public ArrayList<Auteur> findAll() {

        ResultSet resultSet = null;

        ArrayList listeAuteurs = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLConstant.SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Auteur auteur = new Auteur();
                auteur.setId(resultSet.getInt("id"));
                auteur.setNom(resultSet.getString("last_name"));
                auteur.setPreNom(resultSet.getString("first_name"));
                listeAuteurs.add(auteur);
            }

            return listeAuteurs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
