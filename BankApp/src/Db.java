import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db {

    String jdbc = "jdbc:sqlite:C:customersDb.db";

    public void connect() {

        try {
            Connection connection = DriverManager.getConnection(jdbc);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void insertData(String firstname, String lastname, String age, String accountNumber, String pin) {
        String query = "insert into customerDetails(firstname, lastname, age, accountNumber) values(?,?,?,?)";
        String accQuery = "insert into accountDetails(accountNumber, pin, balance) values(?,?,?)";

        try (Connection conn = DriverManager.getConnection(jdbc);) {
            PreparedStatement statement = conn.prepareStatement(query);
            PreparedStatement accStatmt = conn.prepareStatement(accQuery);
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, age);
            statement.setString(4, accountNumber);
            statement.executeUpdate();

            accStatmt.setString(1, accountNumber);
            accStatmt.setString(2, pin);
            accStatmt.setDouble(3, 0.0);
            accStatmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error inserting account: " + e.getMessage());
        }
    }

    public Customer getCustomerInfo(String accNumber){
        Customer customer = null;
        String sql = "SELECT user.firstname, user.lastname, user.age, acc.accountNumber, acc.pin, acc.balance " +
                     "FROM customerDetails user " +
                     "JOIN accountDetails acc ON user.accountNumber = acc.accountNumber " +
                     "WHERE acc.accountNumber = ?";
        
         try (Connection conn = DriverManager.getConnection(jdbc);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1, accNumber);   

             try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    customer = new Customer(
                        rs.getString("firstname"), rs.getString("lastname"), 
                        rs.getString("age"), rs.getString("pin"), 
                        rs.getString("accountNumber"), rs.getDouble("balance"));
                    }else{
                        System.out.println("No user found with account number: " + accNumber);
                    }
                }
                
            }
            catch (SQLException e) {
                System.out.println("Error retrieving user info: " + e.getMessage());
            }
            return customer;
    }

    public Boolean updatePIN(String newPin, String accNumber){
        String sql = "UPDATE accountDetails SET pin = ? WHERE accountNumber = ?";
        Boolean isUpdated = false;
        try (Connection conn = DriverManager.getConnection(jdbc);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPin);
            pstmt.setString(2, accNumber);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer PIN updated successfully.");
                isUpdated = true;
            } else {
                System.out.println("Customer not found or no change made.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating customer pin: " + e.getMessage());
        }
        return isUpdated;
    }

    public Boolean updateBalance(Double newBalance, String accNumber) {
        String sql = "UPDATE accountDetails SET balance = ? WHERE accountNumber = ?";
        Boolean isUpdated = false;
        try (Connection conn = DriverManager.getConnection(jdbc);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newBalance); // Set the new PIN
            pstmt.setString(2, accNumber);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            } else {
                System.out.println("Customer not found or no change made.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating customer balance: " + e.getMessage());
        }

        return isUpdated;
    }

    public void delte() {
        String sql = "DELETE FROM ?;";
        try (Connection conn = DriverManager.getConnection(jdbc);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newBalance); // Set the new PIN
            pstmt.setString(2, accNumber);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                isUpdated = true;
            } else {
                System.out.println("Customer not found or no change made.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating customer balance: " + e.getMessage());
        }
    }
}
