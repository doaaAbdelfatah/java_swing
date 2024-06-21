import javax.swing.*;

public class TableDemo extends JFrame {

    public TableDemo(){
        setBounds(400,150,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        String [] x = new String[4];
//        x[0]= "No";
//        x[1]= "Name";
//        x[2]= "No";
//        x[3]= "No";
        String [] cols = {"NO" , "Name" , "Salary" , "Job" };
//        String [][] y = new String[5][4];
//        y[0][0] = "1";
//        y[0][1]="Ahmed";
        String [][] data ={
                {"1" , "Ahmed" ,"2500" , "instructor"},
                {"2" , "Dina" ,"1500" ,"sales"},
                {"3" , "Sara" ,"3500" ,"sales"},
                {"4" , "Ahmed" ,"2500" ,"Account Manager"},
                {"5" , "Mohamed" ,"4000" ,"Customer Services"}
        };

        JTable table = new JTable(data , cols);
        JScrollPane scrollPane = new JScrollPane(table);
        this.getContentPane().add(scrollPane);
    }
    public static void main(String[] args) {
        new TableDemo().setVisible(true);
    }

}
