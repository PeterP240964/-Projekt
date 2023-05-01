package pckg;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.sql.DriverManager;
import java.sql.Connection;

public class Connections {
    private Connection connection;

    public boolean getDBConnection() { 
        if (connection == null) ;
        {
            try {
            	Class.forName("org.sqlite.JDBC");
            	connection = DriverManager.getConnection("jdbc:sqlite:filmy.db"); 
                createTableHranyF();
                createTableAnimovanyF();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return  false;
            }
        }
        return true;
    }

    public void closeConnection() { 
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableHranyF() 
    {

        String sql = "CREATE TABLE IF NOT EXISTS hranyf (nazov varchar(50), reziser varchar(50), rokVydania int, hodnotenie int, slovneHodnotenie varchar(255), zoznamHercov varchar(255));";
        try
        {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean resetTableHranyF() 
    {
        if (connection==null)
            return false;
        String sql = "DROP TABLE IF EXISTS hranyf;";
        try
        {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            return true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void createTableAnimovanyF()
    {

        String sql = "CREATE TABLE IF NOT EXISTS animovanyf (nazov varchar(50), reziser varchar(50), rokVydania int, hodnotenie int, slovneHodnotenie varchar(255), zoznamAnimatorov varchar(255), doporucenyVek int);";
        try
        {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean resetTableAnimovanyF()
    {
        if (connection==null)
            return false;
        String sql = "DROP TABLE IF EXISTS animovanyf;";
        try
        {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            return true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void getDB(Databaza Films) 
    {

        this.createTableHranyF();
        this.createTableAnimovanyF();
        Films.vymazanieDatabazy();
        String sql = "SELECT * FROM hranyf;";  
        try
        {
            Statement stmt1 = connection.createStatement();
            ResultSet rs1 = stmt1.executeQuery(sql);
            while (rs1.next()) {
                String nazov = rs1.getString("nazov");
                String reziser = rs1.getString("reziser");
                int rokVydania = rs1.getInt("rokVydania");
                String zoznamHercovStr = rs1.getString("zoznamHercov");
                ArrayList<String> zoznamHercov = new ArrayList<String>(Arrays.asList(zoznamHercovStr.split(",")));
                Films.addHranyF(nazov, reziser, rokVydania, zoznamHercov);
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        sql = "SELECT * FROM animovanyf;"; 
        try
        {
            Statement stmt2 = connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql);
            while (rs2.next()) {
                String nazov = rs2.getString("nazov");
                String reziser = rs2.getString("reziser");
                int rokVydania = rs2.getInt("rokVydania");
                String zoznamAnimatorovStr = rs2.getString("zoznamAnimatorov");
                ArrayList<String> zoznamAnimatorov = new ArrayList<String>(Arrays.asList(zoznamAnimatorovStr.split(",")));
                int doporucenyVek = rs2.getInt("doporuceyVek");
                Films.addAnimovanyF(nazov, reziser, rokVydania, zoznamAnimatorov, doporucenyVek);
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void saveDB(Databaza Films) 
    {
        this.resetTableHranyF();
        this.resetTableAnimovanyF();
        createTableHranyF();
        createTableAnimovanyF();
        HashSet<Film> hranyF = Films.getHranyF();
        String sql = "INSERT INTO hranyf (nazov, reziser, rokVydania, zoznamHercov) VALUES (?,?,?,?)"; 
        try
        {
            for (Film o: hranyF)
            {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, o.getNazov());
                pstmt.setString(2, o.getReziser());
                pstmt.setInt(3, o.getRokVydania());

                pstmt.setArray(4, connection.createArrayOf("varchar", o.getZoznamHercovAAnimatorov().toArray()));
                pstmt.executeUpdate();
            }

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        HashSet<Film> animovanyF = Films.getAnimovanyF();
        String sqll = "INSERT INTO animovanyf (nazov, reziser, rokVydania,  zoznamAnimatorov) VALUES (?,?,?,?)"; 
        try
        {
            for (Film o: animovanyF)
            {
                PreparedStatement pstmtt = connection.prepareStatement(sqll);
                pstmtt.setString(1, o.getNazov());
                pstmtt.setString(2, o.getReziser());
                pstmtt.setInt(3, o.getRokVydania());

                pstmtt.setArray(4, connection.createArrayOf("varchar", o.getZoznamHercovAAnimatorov().toArray()));
                pstmtt.executeUpdate();
            }

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

}