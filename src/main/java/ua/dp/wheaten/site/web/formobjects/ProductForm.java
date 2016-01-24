package ua.dp.wheaten.site.web.formobjects;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 13.05.15
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public class ProductForm {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return name + " " + description;
    }
}
