package edu.geektime;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UIContainer implements Drawable {

    private List<Drawable> elements = new ArrayList<>();

    protected String name;


    public UIContainer(String name) {
        this.name = name;
    }

    public void addElement(Drawable drawable){
        Objects.requireNonNull(drawable, "无法加入空指针元素");
        this.elements.add(drawable);
    }

    @Override
    public void draw() {
        for (Drawable element : this.elements) {
            element.draw();
        }
    }
}
