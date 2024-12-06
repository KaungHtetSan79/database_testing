package com.testproject;

import de.vandermeer.asciitable.AsciiTable;

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

            AsciiTable at=new AsciiTable();
            at.addRule();
            at.addRow(new Object[]{"No.1","Country Name","ISO Name"});
            at.addRule();
            int no=1;

            while (rs.next()) {
                at.addRow(new Object[]{no,rs.getString(1),  rs.getString(2)});
                no++;
            }
            rs.close();
            st.close();
            at.addRule();
            System.out.println(at.render());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
