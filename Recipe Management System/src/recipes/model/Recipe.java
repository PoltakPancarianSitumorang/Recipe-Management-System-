
package recipes.model;


public class Recipe {
    
    private int id;
    private String name;
    private String category;
    private String mainIngredient;
    private int preparationTime;
    private int cookingTime;

    public Recipe(int id, String name, String category, String mainIngredient, int preparationTime, int cookingTime) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.mainIngredient = mainIngredient;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nRecipe Name: " + name + "\nCategory: " + category + "\nMainIngredient: " + mainIngredient + "\nPreparationTime: " + preparationTime + "\nCookingTime: " + cookingTime;
    }
 
    
    
}
