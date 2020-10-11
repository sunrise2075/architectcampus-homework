package edu.geektime;

public class Main {

    public static void main(String[] args) {
	// write your code here
        UIContainer uiContainer = new UIContainer("Window - 窗口");
        UIElement logo = new UIElement("Picture - Logo图片");
        uiContainer.addElement(logo);

        UIContainer frame = new UIContainer("Frame 1");
        uiContainer.addElement(frame);

        UIElement label1 = new UIElement("Label - 用户名");
        frame.addElement(label1);
        UIElement textfield = new UIElement("Text Box - 用户名");
        frame.addElement(textfield);
        UIElement label2 = new UIElement("Label - 密码");
        frame.addElement(label2);
        UIElement pwdField = new UIElement("Password Box - 密码");
        frame.addElement(pwdField);
        UIElement checkbox = new UIElement("Checkbox - 记住用户名");
        frame.addElement(checkbox);
        UIElement forgetPassword = new UIElement("Link Label - 忘记密码");
        frame.addElement(forgetPassword);


        UIElement button1 = new UIElement("按钮 - 登录");
        uiContainer.addElement(button1);
        UIElement button2 = new UIElement("按钮 - 注册");
        uiContainer.addElement(button2);

        uiContainer.draw();
    }
}
