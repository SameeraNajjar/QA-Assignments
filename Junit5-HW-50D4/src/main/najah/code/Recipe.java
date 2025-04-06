package main.najah.code;

/**
 * @author Eng
 */
public class Recipe {
    private String name;
    private int price;
    private int amtCoffee;
    private int amtMilk;
    private int amtSugar;
    private int amtChocolate;

    public Recipe() {
        this.name = "";
        this.price = 0;
        this.amtCoffee = 0;
        this.amtMilk = 0;
        this.amtSugar = 0;
        this.amtChocolate = 0;
    }

    public int getAmtChocolate() {
        return amtChocolate;
    }

    public void setAmtChocolate(String chocolate) throws RecipeException {
        this.amtChocolate = parsePositiveInt(chocolate, "Units of chocolate must be a positive integer");
    }

    public int getAmtCoffee() {
        return amtCoffee;
    }

    public void setAmtCoffee(String coffee) throws RecipeException {
        this.amtCoffee = parsePositiveInt(coffee, "Units of coffee must be a positive integer");
    }

    public int getAmtMilk() {
        return amtMilk;
    }

    public void setAmtMilk(String milk) throws RecipeException {
        this.amtMilk = parsePositiveInt(milk, "Units of milk must be a positive integer");
    }

    public int getAmtSugar() {
        return amtSugar;
    }

    public void setAmtSugar(String sugar) throws RecipeException {
        this.amtSugar = parsePositiveInt(sugar, "Units of sugar must be a positive integer");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name != null) ? name : "";
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(String price) throws RecipeException {
        this.price = parsePositiveInt(price, "Price must be a positive integer");
    }

    private int parsePositiveInt(String value, String errorMessage) throws RecipeException {
        int parsedValue;
        try {
            parsedValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RecipeException(errorMessage);
        }
        if (parsedValue >= 0) {
            return parsedValue;
        } else {
            throw new RecipeException(errorMessage);
        }
    }

    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Recipe other = (Recipe) obj;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }

    
}
