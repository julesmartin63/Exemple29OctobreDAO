package dao;


import java.sql.Connection;
import java.util.ArrayList;

/**
 * cette classe abstraite utilise yn TYPE générique pour mettre ce que je désire comme type
 * @param <T>
 */
public abstract class CommonDAO<T> {
    protected Connection connection;

    public CommonDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Permet d'insérer et supprimer un objet dans la bd
     * @param object
     * @return
     */
    public abstract boolean create (T object);


    /**
     * Méthode pour effacer
     * @param object
     * @return boolean
     */
    public abstract boolean delete(T object);

    /**
     * Méthode de mise à jour
     * @param object
     * @return boolean
     */
    public abstract boolean update(T object);

    /**
     * Récupérer l'objet à partir d'un champs de type entier
     * @param id
     * @return T
     */
    public abstract T findById(int id);

    /**
     * Récupérer l'objet à partir d'une chaîne de caractères
     * @param name
     * @return T
     */
    public abstract T findByName(String name);

    /**
     * Récupérer tous les objets en base de données
     * @return ArrayList<T>
     */
    public abstract ArrayList<T> findAll();







}
