import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

    public class BD {

        public static void main(String[] args) {
            // TODO code application logic here
            Connection maCo = initConnection();
            if(maCo == null) return;
            String req = "select * from student";
            System.out.println("okok");
            try{

                Statement st = maCo.createStatement();
                ResultSet rs = st.executeQuery(req);
                while(rs.next()){

                    System.out.println("Nom :"+rs.getString("nomEtu"));
                    System.out.println("Dpt :"+rs.getString("deptName"));
                    System.out.println("Age :"+rs.getInt("age"));
                    System.out.println("Section :"+rs.getString("section"));
                }
                rs.close(); st.close(); maCo.close();

            }catch(SQLException se){
                System.out.print("connexion impossible: " + se.getMessage());
            }
        }

        public static Connection initConnection(){

            Connection co = null;
            String url = "jdbc:mysql://localhost/java_university";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                co = (Connection) DriverManager.getConnection(url,"root",null);
                JOptionPane.showMessageDialog(null, "Connection OK");

            }catch(ClassNotFoundException fe){
                System.out.print("driver introuvable : " + fe.getMessage());
            }
            catch(SQLException se){
                System.out.print("connexion impossible : " + se.getMessage());
            }

            return co;

        }

    }