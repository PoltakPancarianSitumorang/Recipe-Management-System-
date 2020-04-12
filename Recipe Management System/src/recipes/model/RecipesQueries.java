
package recipes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class RecipesQueries implements IQueries{
    
    private String PASSWORD;
    private String URL;
    private String USERNAME;
    private Connection connection;
    private PreparedStatement countRecipesWithMainIngredient;
    private PreparedStatement insertNewRecipe;
    private PreparedStatement selectRecipesForCategory;
    private PreparedStatement selectRecipesForCategoryAndCookingTime;
    private PreparedStatement selectRecipesForCategoryAndPreparationTime;
    
    public RecipesQueries()
    {
        PASSWORD = "recipe";
        URL = "jdbc:derby://localhost:1527/recipes";
        USERNAME = "recipe";
        try
        {
            connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
            System.out.println("=====Successfully Connection==="+connection);
        }
        catch(Exception ex)
        {}
    }

    @Override
    public int addRecipe(String n, String c, String mi, int pt, int ct) {
        try{
            insertNewRecipe = connection.prepareStatement("INSERT INTO RECIPES(RECIPENAME,CATEGORY,MAININGREDIENT,PREPARATIONTIME,COOKINGTIME) values(?,?,?,?,?) ");
            insertNewRecipe.setString(1,n);
            insertNewRecipe.setString(2, c);
            insertNewRecipe.setString(3, mi);
            insertNewRecipe.setInt(4, pt);
            insertNewRecipe.setInt(5, ct);
            
            int value = insertNewRecipe.executeUpdate();  
            return value;
        }
        catch(Exception ex)
        {}
        return -1;
    }

    @Override
    public void close() 
    {
        try
        {
            connection.close();
        }
        catch(Exception ex)
        {}
    }

    @Override
    public List<Recipe> getNumberOfRecipesUsingMainIngredient(String mi) {
        List<Recipe> list = new ArrayList<>();
        try
        {
            countRecipesWithMainIngredient = connection.prepareStatement("select * from RECIPES where MAININGREDIENT = ? ");
            countRecipesWithMainIngredient.setString(1, mi);
            ResultSet rs = countRecipesWithMainIngredient.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt(1);
                String recipeName = rs.getString(2);
                String category = rs.getString(3);
                String mainIngredient = rs.getString(4);
                int preparationTime = rs.getInt(5);
                int cookingTime = rs.getInt(6);
                
                Recipe recipe = new Recipe(id,recipeName,category,mainIngredient,preparationTime,cookingTime);
                list.add(recipe);
                
                
            }
            rs.close();
            return list;
        }
        catch(Exception ex)
        {
            return null;
        } 
        
        
        
    }

    @Override
    public List<Recipe> getRecipesForCategory(String c) {
        List<Recipe> list = new ArrayList<>();
        try
        {
            selectRecipesForCategory = connection.prepareStatement("select * from RECIPES where CATEGORY = ?");
            selectRecipesForCategory.setString(1, c);
            ResultSet rs = selectRecipesForCategory.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt(1);
                String recipeName = rs.getString(2);
                String category = rs.getString(3);
                String mainIngredient = rs.getString(4);
                int preparationTime = rs.getInt(5);
                int cookingTime = rs.getInt(6);
                
                Recipe recipe = new Recipe(id,recipeName,category,mainIngredient,preparationTime,cookingTime);
                list.add(recipe);
            }
            return list;
            
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    @Override
    public List<Recipe> getRecipesForCategoryAndCombinedTime(String c, int ct1, int ct2) {
        List<Recipe> list = new ArrayList<>();
        try
        {
            selectRecipesForCategoryAndCookingTime = connection.prepareStatement("select * from RECIPES where CATEGORY = ? AND COOKINGTIME>= ? AND COOKINGTIME<= ?");
            selectRecipesForCategoryAndCookingTime.setString(1, c);
            selectRecipesForCategoryAndCookingTime.setInt(2, ct2);
            selectRecipesForCategoryAndCookingTime.setInt(3, ct1);
            ResultSet rs = selectRecipesForCategoryAndCookingTime.executeQuery();
            
            while(rs.next())
            {
                int id = rs.getInt(1);
                String recipeName = rs.getString(2);
                String category = rs.getString(3);
                String mainIngredient = rs.getString(4);
                int preparationTime = rs.getInt(5);
                int cookingTime = rs.getInt(6);
                
                Recipe recipe = new Recipe(id,recipeName,category,mainIngredient,preparationTime,cookingTime);
                list.add(recipe);
                
            }
            rs.close();
            return list;
            
        }
        catch(Exception ex)
        {
            return null;
        }
    }
        
        

    @Override
    public List<Recipe> getRecipesForCategoryAndPreparationTime(String c, int ct1, int ct2) {
        
        List<Recipe> list = new ArrayList<>();
        try
        {
            selectRecipesForCategoryAndPreparationTime = connection.prepareStatement("select * from RECIPES where CATEGORY = ? AND PREPARATIONTIME>= ? AND PREPARATIONTIME<= ?");
            selectRecipesForCategoryAndPreparationTime.setString(1, c);
            selectRecipesForCategoryAndPreparationTime.setInt(2, ct2);
            selectRecipesForCategoryAndPreparationTime.setInt(3, ct1);
            ResultSet rs = selectRecipesForCategoryAndPreparationTime.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt(1);
                String recipeName = rs.getString(2);
                String category = rs.getString(3);
                String mainIngredient = rs.getString(4);
                int preparationTime = rs.getInt(5);
                int cookingTime = rs.getInt(6);
                
                Recipe recipe = new Recipe(id,recipeName,category,mainIngredient,preparationTime,cookingTime);
                list.add(recipe);
                
            }
            
            rs.close();
            return list;
        }
        catch(Exception ex)
        {
             return null;
        } 
        
       
    }
    
}
