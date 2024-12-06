package com.testproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data_Read {

    public void read_Data(Connection conn) {
        try {
            PreparedStatement st = conn.prepareStatement(
                    "SELECT country_name, iso_name FROM population");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + " (" + rs.getString(2) + ")");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
