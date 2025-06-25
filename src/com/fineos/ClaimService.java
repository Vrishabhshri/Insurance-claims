package com.fineos;

import java.sql.*;

public class ClaimService {

    private Connection conn;

    public ClaimService(String dbPath) throws SQLException {

        conn = DriverManager.getConnection("jdbc:sqlite" + dbPath);

    }

    public void submitClaim(String name, String type, double amount) throws SQLException {

        String sql = "INSERT INTO claims (claimant_name, claim_type, amount) VALUES(?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, type);
            stmt.setDouble(3, amount);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateClaimStatus(int id, String status) throws SQLException {

        String sql = "UPDATE claims SET status = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void listClaims() throws SQLException {

        String sql = "SELECT * FROM claims";

        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                System.out.printf("ID: %d | Name: %s | Type: %s | Amount: %.2f | Status: %s | Created: %s\n",
                    rs.getInt("id"),
                    rs.getString("claimant_name"),
                    rs.getString("claim_type"),
                    rs.getDouble("amount"),
                    rs.getString("status"),
                    rs.getString("created_at"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
