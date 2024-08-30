import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class gui extends JFrame {


    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton arabayıEkleButton;
    private JTable table1;
    private JButton tabloyuGüncelleButton;
    private JTextField textField6;
    private JButton arabayıSilButton;
    private JTextField textField7;
    private JTextField textField8;
    private JButton kilometeGüncelleButton;
    private JButton IDYeGöreSıralaButton;
    private JButton KMYeGöreSıralaButton;
    private JButton modelYılınaGöreSıralaButton;
    private String cache;
    private int cacheID;
    private int cacheKM;
    private int cacheMY;

    araba araba = new araba();


    public gui(){

        add(panel1);
        setSize(1000,700);
        setTitle("Veritabanına Araba Ekle");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        arabayıEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brand = textField1.getText();
                String model = textField2.getText();
                int modelYear = Integer.parseInt(textField3.getText());
                String color = textField4.getText();
                int km = Integer.parseInt(textField5.getText());

                araba.arabaEkle(brand,model,modelYear,color,km);
                tabloyuGuncelle();
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
            }
        });

        tabloyuGuncelle();


        tabloyuGüncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabloyuGuncelle();
            }
        });


        arabayıSilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                araba.arabaSil(Integer.parseInt(textField6.getText()));
                textField6.setText("");
                tabloyuGuncelle();
            }
        });
        kilometeGüncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                araba.kmGuncelle(Integer.parseInt(textField7.getText()), Integer.parseInt(textField8.getText()));
                textField7.setText("");
                textField8.setText("");
                tabloyuGuncelle();
            }
        });
        IDYeGöreSıralaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cacheID == 1) {
                    orderbyIDdesc();
                    cacheID = 0;
                }else{
                    orderbyID();
                    cacheID = 1;
                }
                cache = "ID";
            }
        });
        KMYeGöreSıralaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cacheKM == 1) {
                    orderbyKMdesc();
                    cacheKM = 0;
                }else{
                    orderbyKM();
                    cacheKM = 1;
                }
                cache = "KM";
            }
        });
        modelYılınaGöreSıralaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cacheMY == 1) {
                    orderbyMYdesc();
                    cacheMY = 0;
                }else{
                    orderbyMY();
                    cacheMY = 1;
                }
                cache = "MY";
            }
        });
    }

    private void orderbyID() {

        DefaultTableModel modell = new DefaultTableModel();
        modell.setColumnIdentifiers(new String[]{"id", "Brand", "Model", "Model Year", "Color", "KM"});
        table1.setModel(modell);

        try {
            ResultSet resultSet = araba.selectID();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int modelYear = resultSet.getInt("modelYear");
                String color = resultSet.getString("color");
                int km = resultSet.getInt("km");

                modell.addRow(new Object[]{id, brand, model, modelYear, color, km});
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void orderbyKM() {

        DefaultTableModel modell = new DefaultTableModel();
        modell.setColumnIdentifiers(new String[]{"id", "Brand", "Model", "Model Year", "Color", "KM"});
        table1.setModel(modell);

        try {
            ResultSet resultSet = araba.selectKM();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int modelYear = resultSet.getInt("modelYear");
                String color = resultSet.getString("color");
                int km = resultSet.getInt("km");

                modell.addRow(new Object[]{id, brand, model, modelYear, color, km});
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void orderbyMY() {

        DefaultTableModel modell = new DefaultTableModel();
        modell.setColumnIdentifiers(new String[]{"id", "Brand", "Model", "Model Year", "Color", "KM"});
        table1.setModel(modell);

        try {
            ResultSet resultSet = araba.selectMY();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int modelYear = resultSet.getInt("modelYear");
                String color = resultSet.getString("color");
                int km = resultSet.getInt("km");

                modell.addRow(new Object[]{id, brand, model, modelYear, color, km});
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void orderbyIDdesc() {

        DefaultTableModel modell = new DefaultTableModel();
        modell.setColumnIdentifiers(new String[]{"id", "Brand", "Model", "Model Year", "Color", "KM"});
        table1.setModel(modell);

        try {
            ResultSet resultSet = araba.selectIDdesc();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int modelYear = resultSet.getInt("modelYear");
                String color = resultSet.getString("color");
                int km = resultSet.getInt("km");

                modell.addRow(new Object[]{id, brand, model, modelYear, color, km});
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void orderbyKMdesc() {

        DefaultTableModel modell = new DefaultTableModel();
        modell.setColumnIdentifiers(new String[]{"id", "Brand", "Model", "Model Year", "Color", "KM"});
        table1.setModel(modell);

        try {
            ResultSet resultSet = araba.selectKMdesc();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int modelYear = resultSet.getInt("modelYear");
                String color = resultSet.getString("color");
                int km = resultSet.getInt("km");

                modell.addRow(new Object[]{id, brand, model, modelYear, color, km});
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void orderbyMYdesc() {

        DefaultTableModel modell = new DefaultTableModel();
        modell.setColumnIdentifiers(new String[]{"id", "Brand", "Model", "Model Year", "Color", "KM"});
        table1.setModel(modell);

        try {
            ResultSet resultSet = araba.selectMYdesc();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                int modelYear = resultSet.getInt("modelYear");
                String color = resultSet.getString("color");
                int km = resultSet.getInt("km");

                modell.addRow(new Object[]{id, brand, model, modelYear, color, km});
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void tabloyuGuncelle(){
        if(cache == "KM") {
            if(cacheKM == 0) {
                orderbyKM();
            }
            else if(cacheKM == 1) {
                orderbyKMdesc();
            }
        }
        else if(cache == "ID") {
            if(cacheID == 0) {
                orderbyID();
            }
            else if(cacheID == 1) {
                orderbyIDdesc();
            }
        }
        else if(cache == "MY") {
            if(cacheMY == 0) {
                orderbyMY();
            }
            else if(cacheMY == 1) {
                orderbyMYdesc();
            }
        }
        else
            orderbyID();


    }

}
