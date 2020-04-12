
package recipes.presenter;

import java.util.List;
import recipes.model.IQueries;
import recipes.model.Recipe;
import recipes.view.IView;
import recipes.view.RecipeView;


public class RecipePresenter {
    
    private IQueries queries;
    private IView view;
    
    public RecipePresenter(IQueries q)
    {
        queries = q;
    }
    
    public void bind(IView v)
    {
        view = v;
    }
    
    public List<Recipe> recipesForCategory(String c)
    {
        return queries.getRecipesForCategory(c);
    }
    
    public int addRecipe(String n, String c, String mi, int pt, int ct)
    {
        return queries.addRecipe(n, c, mi, pt, ct);
    }
    
    public List<Recipe> recipesForCategoryAndPreparationTime(String c, int ct1, int ct2)
    {
        return queries.getRecipesForCategoryAndPreparationTime(c, ct1, ct2);
    }
    
    public List<Recipe> numberOfRecipesUsingMainIngredient(String mi)
    {
        return queries.getNumberOfRecipesUsingMainIngredient(mi);
    }
    
    
    public List<Recipe> recipesForCategoryAndCombinedTime(String c, int ct1, int ct2)
    {
        return queries.getRecipesForCategoryAndCombinedTime(c, ct1, ct2);
    }
    
    
    public void close()
    {
        queries.close();
    }
    
}
