import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenueDemo extends JFrame {

    public MenueDemo(String title){
        super(title);
        this.setSize(500,500);
        this.setLocation(400,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1 = create new JMenueBar
        // 2 = add jmenueBar to the jframe
        // 3 = create new JMenue and add it to the jmenueBar
        // 4 = create new JMenueItem and add it to JMenue

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("View");
        JMenu menu4 = new JMenu("Format");

        menuBar.add(menu1);
        menuBar.add(menu2);
//        menuBar.add(menu4);


        JMenuItem menuItemNew = new JMenuItem("New");
        JMenuItem menuItemOpen = new JMenuItem("Open");
        JMenuItem menuItemExit = new JMenuItem("Exit");
        JMenuItem menuItemCopy = new JMenuItem("Copy");
        JMenuItem menuItemCut = new JMenuItem("Cut");
        JMenuItem menuItemPaste = new JMenuItem("Paste");
        JMenuItem menuItemColor = new JMenuItem("Color");

        menu1.add(menuItemNew);
        menu1.add(menuItemOpen);
        menu1.addSeparator();
        menu1.add(menuItemExit);

        menu2.add(menuItemCopy);
        menu2.add(menuItemCut);
        menu2.addSeparator();
        menu2.add(menuItemPaste);

        menu4.add(menuItemColor);

        JMenuItem menuItemList = new JMenuItem("List view");
        JMenuItem menuItemDetails = new JMenuItem("Details view");
        JMenuItem menuItemTitled = new JMenuItem("Titled view");

        menu3.add(menuItemList);
        menu3.add(menuItemDetails);
        menu3.add(menuItemTitled);

        menu4.add(menu3);


        menuBar.add(menu4);
    }

    public static void main(String[] args) {
        MenueDemo m = new MenueDemo("Menue Demo..");
        m.setVisible(true);
    }

}
