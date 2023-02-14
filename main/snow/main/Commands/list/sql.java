package main.Commands.list;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sql {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://107.189.1.208/kevin_nrts_bot";

    static final String USER = "kevin_nrts";
    static final String PASS = "A@@46426764@@a";

    static int GID = 1206;

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("正在連線資料庫中...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("正在創建新資料...");
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO Guild_Settings (ID, Lang_Code) VALUES ('" + GID + "', 'Hui Hui \uD83D\uDC97')";
            stmt.executeUpdate(sql);
            System.out.println("新數據插入成功!");
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("我的工作已經完成了，再見!");
    }
}
