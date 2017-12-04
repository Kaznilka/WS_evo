package WS_evo;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class db {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            conn.Conn();
            conn.CreateDB();
            conn.CreateAgt();
            conn.ReadDB();
            conn.CloseDB();
            conn.GetBalance();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
    }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}




class conn {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    // --------Connect--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:C:\\Device\\WS_evo\\src\\WS_evo\\BAZA.s3db");

        System.out.println("База Подключена!");
    }

    // --------Create--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' ('login' INTEGER PRIMARY KEY AUTOINCREMENT, 'password' text, 'balance' INT);");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Request1--------
    public static int CreateAgt() throws SQLException
    {
        statmt.execute("INSERT INTO 'users' ('login', 'password', 'balance') VALUES (login, password, 0); ");
        //statmt.execute("INSERT INTO 'users' ('password', 'balance') VALUES ('Vasya', 321789); ");
        //statmt.execute("INSERT INTO 'users' ('password', 'balance') VALUES ('Masha', 456123); ");

        System.out.println("Enough");
    }

    // --------Request2--------
    public static int GetBalance(String rlogin, String rpassword) throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("login");
            if(id == rlogin) {
                String  password = resSet.getString("password");
                if (password == rpassword) {
                    String  balance = resSet.getString("balance");
                    return balance;

                }
                else {
                    return 1488;
                }
            }



            /*
            String  password = resSet.getString("password");
            String  balance = resSet.getString("balance");
            System.out.println( "login = " + id );
            System.out.println( "password = " + password );
            System.out.println( "balance = " + balance );
            System.out.println();
            */
        }

        System.out.println("Table HERE");
    }




    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while(resSet.next())
        {
            int id = resSet.getInt("login");
            String  password = resSet.getString("password");
            String  balance = resSet.getString("balance");
            System.out.println( "login = " + id );
            System.out.println( "password = " + password );
            System.out.println( "balance = " + balance );
            System.out.println();
        }

        System.out.println("Table HERE");
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        resSet.close();

        System.out.println("Closing..");
    }

}