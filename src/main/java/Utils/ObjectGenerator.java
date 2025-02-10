package Utils;

import Tools.*;

public class ObjectGenerator extends  BaseClass {

    public Elements ele;
    public Sync sync;
    public TextBox textBox;
    public DropDown dd;

    public void initPage(){
        ele = new Elements();
         sync = new Sync();
        textBox = new TextBox();
         dd = new DropDown();
    }

}
