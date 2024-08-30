import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Islemler {

    public Connection con;
    public Statement statement;
    public PreparedStatement preparedStatement;


    public static void main(String[] args){
        Islemler islemler = new Islemler();



        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui gui1 = new gui();
                gui1.setVisible(true);
            }
        });





    }







}
