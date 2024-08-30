import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class araba {
    private String brand;
    private String model;
    private int modelYear;
    private String color;
    private int km;

    private Connection con;
    private PreparedStatement preparedStatement;


    public araba() {
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi + "?serverTimezone=UTC";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bulunamadi");
        }

        try {
            con = DriverManager.getConnection(url, Database.kullanici_adi,Database.parola);
            System.out.println("Baglanti basarili");
        } catch (SQLException e) {
            System.out.println("Veritabanina baglanilamadi: " + e.getMessage());
        }

    }



    public void arabaEkle(String brand, String model, int modelYear, String color, int km){

        if (con == null) {
            System.out.println("Veritabanı bağlantısı mevcut değil.");

        }

        String sorgu = "INSERT INTO araba (brand,model,modelYear,color,km) VALUES (?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, modelYear);
            preparedStatement.setString(4, color);
            preparedStatement.setInt(5, km);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

    public void arabaSil(int id){

        if (con == null) {
            System.out.println("Veritabanı bağlantısı mevcut değil.");

        }

        String sorgu = "DELETE FROM araba WHERE ID = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }

    public void kmGuncelle(int id, int km){

        if (con == null) {
            System.out.println("Veritabanı bağlantısı mevcut değil.");

        }

        String sorgu = "UPDATE araba SET km = ? WHERE id = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, km);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }


    public ResultSet selectID(){

        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sorgu = "SELECT id, brand, model, modelYear, color, km FROM araba ORDER BY id ASC";

        try {
            ResultSet resultSet = statement.executeQuery(sorgu);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet selectKM(){

        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sorgu = "SELECT id, brand, model, modelYear, color, km FROM araba ORDER BY km ASC";

        try {
            ResultSet resultSet = statement.executeQuery(sorgu);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet selectMY(){

        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sorgu = "SELECT id, brand, model, modelYear, color, km FROM araba ORDER BY modelYear ASC";

        try {
            ResultSet resultSet = statement.executeQuery(sorgu);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public ResultSet selectIDdesc(){

        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sorgu = "SELECT id, brand, model, modelYear, color, km FROM araba ORDER BY id DESC";

        try {
            ResultSet resultSet = statement.executeQuery(sorgu);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet selectKMdesc(){

        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sorgu = "SELECT id, brand, model, modelYear, color, km FROM araba ORDER BY km DESC";

        try {
            ResultSet resultSet = statement.executeQuery(sorgu);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet selectMYdesc(){

        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sorgu = "SELECT id, brand, model, modelYear, color, km FROM araba ORDER BY modelYear DESC";

        try {
            ResultSet resultSet = statement.executeQuery(sorgu);
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
