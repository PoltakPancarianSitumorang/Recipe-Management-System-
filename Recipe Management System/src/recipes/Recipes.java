package recipes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import recipes.model.RecipesQueries;
import recipes.presenter.RecipePresenter;
import recipes.view.RecipeView;


public class Recipes {
    
    public static void main(String[] args)
    {
        
        RecipesQueries rq = new RecipesQueries();
        RecipePresenter rp = new RecipePresenter(rq);
        RecipeView rv = new RecipeView(rp);
        rp.bind(rv);
    }
}
