package idv.derekhsu.helloword50.listview04;

/**
 * Created by derekhsu on 2016/9/25.
 */

public class Fruit {
    private long id;
    private String name;
    private String content;
    private boolean selected;

    public Fruit(long id, String name, String content, boolean selected) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.selected = selected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
