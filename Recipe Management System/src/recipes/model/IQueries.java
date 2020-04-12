
package recipes.model;

import java.util.List;

public interface IQueries {
    
    public int addRecipe(String n, String c, String mi, int pt, int ct);
    public void close();
    public List<Recipe> getNumberOfRecipesUsingMainIngredient(String mi);
    public List<Recipe> getRecipesForCategory(String c);
    public List<Recipe> getRecipesForCategoryAndCombinedTime(String c, int ct1, int ct2);
    public List<Recipe> getRecipesForCategoryAndPreparationTime(String c, int ct1, int ct2);
    
    
}
