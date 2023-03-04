package alsa.entity;

public class Notebook {
    private String name;
    public NotebookCategory category;
    private int price;

    public Notebook(String name, NotebookCategory category , int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public NotebookCategory getCategory() {
        return category;
    }

    public void setCategory(NotebookCategory category) {
        this.category = category;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        if(price < 0)
            throw new RuntimeException("IllegalArgument");

        this.price = price;
    }


}
