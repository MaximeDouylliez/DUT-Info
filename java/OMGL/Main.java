import java.awt.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JFrame;

import org.postgresql.ds.PGSimpleDataSource;

public class Main
{
	private static String pseudo = "nainso", pass = "concombres", bdd = "bouffe";
	private static java.sql.Statement stmt;
	private static JFrame actualFen;
	private static HashMap<String, String> recettesInfos = new HashMap<String, String>();
	private static HashMap<String, String> recettesEtapes = new HashMap<String, String>();
	private static ArrayList<String> recettesIngre = new ArrayList<String>();
	
	public static void goAccueil()
	{
		actualFen.dispose();
		actualFen = new Accueil();
	}
	
	public static void goRecettes()
	{
		actualFen.dispose();
		actualFen = new Recettes();
	}
	
	public static void goCourses()
	{
		actualFen.dispose();
		actualFen = new Courses();
	}
	
	public static void goAjoutInformation()
	{
		actualFen.dispose();
		actualFen = new AjoutInfo();
	}
	
	public static void goAjoutIngredient()
	{
		actualFen.dispose();
		actualFen = new AjoutIngre();
	}
	
	public static void goAjoutIngredientRecette()
	{
		actualFen.dispose();
		actualFen = new AjoutIngreRec();
	}
	
	public static void goAjoutEtape()
	{
		actualFen.dispose();
		actualFen = new AjoutEtape();
	}
	
	public static void goAjoutTag()
	{
		actualFen.dispose();
		actualFen = new AjoutTag();
	}
	
	public static void goModifRecette()
	{
		actualFen.dispose();
		actualFen = new SelectIngre();
	}
	
	public static void goMenus()
	{
		actualFen.dispose();
		actualFen = new Menus();
	}
	
	public static void goModifMenus(int i)
	{
		actualFen.dispose();
		actualFen = new ModifMenu(i);
	}
	
	public static void goIngredients()
	{
		actualFen.dispose();
		actualFen = new Ingredients();
	}
	
	public static void goModifIngre()
	{
		actualFen.dispose();
		actualFen = new ModifIngre();
	}
	
	public static void main(String[] args)
	{
		// Choix de la BDD
		PGSimpleDataSource ds = new PGSimpleDataSource();
		
		ds.setServerName("localhost");
		ds.setDatabaseName(bdd);
		
		try {
			// connection à la BDD
			Connection connect = ds.getConnection(pseudo, pass);
			stmt = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			actualFen = new Accueil();
			// Création de la BDD
			drop();
			tables();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Supression puis Ajout des tables
	public static void drop()
	{
		// Supression
		try
		{
			stmt.executeUpdate("DROP TYPE typePlat CASCADE");
			stmt.executeUpdate("DROP TABLE Ingredients CASCADE");
			stmt.executeUpdate("DROP TABLE Course CASCADE");
			stmt.executeUpdate("DROP TABLE QuantiCourse CASCADE");
			stmt.executeUpdate("DROP TABLE Recette CASCADE");
			stmt.executeUpdate("DROP TABLE Etape CASCADE");
			stmt.executeUpdate("DROP TABLE IngRec CASCADE");
			stmt.executeUpdate("DROP TABLE Menu CASCADE");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void tables() throws SQLException
	{
		// Ajout
		// Enum
		stmt.executeUpdate("CREATE TYPE typePlat AS ENUM ('entree', 'plat', 'dessert')");
		
		// Classe principale
		stmt.executeUpdate("CREATE TABLE Ingredients(idIngredient serial PRIMARY KEY, nom text, " +
				"quantite real)");
		
		// Courses
		stmt.executeUpdate("CREATE TABLE Course(idCourse serial PRIMARY KEY, dateAchat date)");
		stmt.executeUpdate("CREATE TABLE QuantiCourse(idIngredient int REFERENCES Ingredients, idCourse" +
				" int REFERENCES Course, quantite real, PRIMARY KEY (idIngredient, idCourse))");
		
		// Recette
		stmt.executeUpdate("CREATE TABLE Recette(idRecette serial PRIMARY KEY, nom text, type typePlat, " +
				"tmpPrep int, apport int)");
		stmt.executeUpdate("CREATE TABLE Etape(idRecette int REFERENCES Recette, numEtape int, " +
				"description text, PRIMARY KEY (idRecette, numetape))");
		stmt.executeUpdate("CREATE TABLE IngRec(idRecette int, idIngredient int, quantite real, " +
				"PRIMARY KEY (idIngredient, idRecette))");
		
		// Menu
		stmt.executeUpdate("CREATE TABLE Menu(date int PRIMARY KEY, nbPersonne int, idEntree int, " +
				"idPlat int, idDessert int)");
		
		// Insert
		//Ingredients
		insert("Ingredients(nom, quantite)", "'Frittes', 100");
		insert("Ingredients(nom, quantite)", "'Ketchup', 1.8");
		insert("Ingredients(nom, quantite)", "'Mayo', 1.9");
		insert("Ingredients(nom, quantite)", "'Pain', 100");
		insert("Ingredients(nom, quantite)", "'Glace', 100");
		insert("Ingredients(nom, quantite)", "'Chocolat liquide', 4.3");
		insert("Ingredients(nom, quantite)", "'Salade', 35");
		insert("Ingredients(nom, quantite)", "'Assaisonement', 2.5");
		
		// Recettes
			// Salade
		insert("Recette(nom, type, tmpPrep, apport)", "'Salade', 'entree', 1, 3");
		insert("Etape(idRecette, numEtape, description)", "1, 1, 'Ajouter l assaisonement'");
		insert("Etape(idRecette, numEtape, description)", "1, 2, 'Mélanger'");
		insert("IngRec(idRecette, idIngredient, quantite)", "1, 7, 15");
		insert("IngRec(idRecette, idIngredient, quantite)", "1, 8, 0.05");
	}
	
	public static void insert(ArrayList<String> table, ArrayList<String> valeurs)
	{
		for(int i = 0; i < table.size(); i++)
				insert(table.get(i), valeurs.get(i));
	}
	
	public static void insert(String table, String valeurs)
	{
		String req = "INSERT INTO " + table + " VALUES (" + valeurs + ")";
		System.out.println(req);
		try
		{
			stmt.executeUpdate(req);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void update(String table, String set, String where)
	{
		String req = "UPDATE " + table + " SET " + set + " WHERE " + where;
		System.out.println(req);
		try
		{
			stmt.executeUpdate(req);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> selectList(String table, String key, String where)
	{
		ArrayList<String> list = new ArrayList<String>();
		
		try
		{
			String req = "SELECT " + key + " FROM " + table + " WHERE " + where;
			System.out.println(req);
		ResultSet rs = stmt.executeQuery(req);
		
		while(rs.next())
			list.add(rs.getString(key));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static HashMap<String, String> selectMap(String table, String key, String val, String where)
	{
		HashMap<String, String> list = new HashMap<String, String>();
		
		try
		{
		ResultSet rs = stmt.executeQuery("SELECT " + key + ", " + val + " FROM " + table + " WHERE " + where);
		
		while(rs.next())
			list.put(rs.getString(key), rs.getString(val));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void verifCourse()
	{
		HashMap<String, String> list = selectMap("Ingredients", "idIngredient", "quantite", "quantite<0");
			
		for(int i = 0; i < list.size(); i++)
		{
			if(i == 0)
				insert("Course(dateachat)", "(CURRENT_DATE)");
			String idcourse = selectList("Course", "idCourse", "TRUE ORDER BY idCourse DESC").get(0);
			
			insert("QuantiCourse", "'" + list.keySet().toArray()[i] + "', '" + idcourse + "', '" +
				list.get(list.keySet().toArray()[i]).replaceFirst("-", "") + "'");
			update("Ingredients", "quantite=0", "idIngredient='" + list.keySet().toArray()[i] + "'");
		}
	}
	
	public static void addRecetteInfos(String key, String val)
	{
		recettesInfos.put(key, val);
	}
	
	public static void clearRecetteInfos()
	{
		recettesInfos.clear();
	}
	
	public static HashMap<String, String> getRecetteInfos()
	{
		return recettesInfos;
	}
	
	public static void addRecetteEtapes(String val)
	{
		recettesEtapes.put("" + (recettesEtapes.size() + 1), val);
	}
	
	public static void clearRecetteEtapes()
	{
		recettesEtapes.clear();
	}
	
	public static HashMap<String, String> getRecetteEtapes()
	{
		return recettesEtapes;
	}
	
	public static void addRecetteIngre(String nom, String val)
	{
		System.out.println("" + (recettesEtapes.size() + 1) + " / " + val);
		if(!recettesIngre.contains(nom))
			recettesIngre.add(nom);
		addRecetteInfos(nom, val);
	}
	
	public static void clearRecetteIngre()
	{
		recettesIngre.clear();
	}
	
	public static ArrayList<String> getRecetteIngre()
	{
		return recettesIngre;
	}
	
	public static void validateRecette()
	{
    	if(recettesInfos.size() <= 0 || recettesEtapes.size() == 0 || recettesIngre.size() == 0)
    	{
    		recettesEtapes.clear();
    		recettesInfos.clear();
    		recettesIngre.clear();
    		return;
    	}
    	
    	insert("Recette(nom, type, tmpPrep, apport)", "'" + recettesInfos.get("nom") + "', '" +
    		recettesInfos.get("tag") + "', " + recettesInfos.get("temps") + ", " +
    		recettesInfos.get("apport"));
    	String idRecette = selectList("Recette", "idRecette", "nom='" + recettesInfos.get("nom") + "' " +
    			"ORDER BY idRecette DESC").get(0);

		for(int i = 1; i <= recettesEtapes.size(); i++)
		{
	    	insert("Etape(idRecette, numEtape, description)", idRecette + ", " +
	    		i + ", '" + recettesEtapes.get("" + i) + "'");
		}
		
    	for(int i = 0; i < recettesIngre.size(); i++)
    	{
    		String idIngredient = selectList("Ingredients", "idIngredient", "nom='" + recettesIngre.get(i) +
    		"'").get(0);
    		insert("IngRec(idRecette, idIngredient, quantite)", idRecette + ", " + idIngredient +
    			", " + recettesInfos.get(recettesIngre.get(i)));
    	}
    	

		recettesEtapes.clear();
		recettesInfos.clear();
		recettesIngre.clear();
   	}
	
	public static void ajoutMenu(int date, String entree, String plat, String dessert, String nbPers)
	{
//		Menu(date int PRIMARY KEY, nbPersonne int, idEntree int, idPlat int, idDessert int)");
		String idEntre = Main.selectList("Recette", "idRecette", "type='entree' AND nom='" +
			entree + "'").get(0);
		String idPlat = Main.selectList("Recette", "idRecette", "type='plat' AND nom='" +
			plat + "'").get(0);
		String idDess = Main.selectList("Recette", "idRecette", "type='dessert' AND nom='" +
			dessert + "'").get(0);
		
		insert("Menu", date + ", " + nbPers + ", '" + idEntre + "', '" + idPlat + "', '" +
			idDess + "'");
	}
}
