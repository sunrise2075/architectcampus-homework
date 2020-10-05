package edu.geektime;

public class UIElement implements Drawable{

    private String name;

    public UIElement(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println(this.name);
    }
}
