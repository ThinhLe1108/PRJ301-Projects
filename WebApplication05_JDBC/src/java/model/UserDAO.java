/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DbUtils;

/**
 *
 * @author khoac
 */
public class UserDAO {

    ArrayList<UserDTO> list;

    public UserDAO() {
        this.list = new ArrayList<>();
        list.add(new UserDTO("admin", "Administator", "1", "AD", true));
        list.add(new UserDTO("SE192194", "Cao Do Dang Khoa", "21122005", "MB", true));
    }

    public boolean login(String userID, String password) {
        try {
            String sql = "SELECT * FROM tblUsers "
                    + " WHERE userID='" + userID + "' AND password='" + password + "'";
            // B1 - Ket noi
            Connection conn = DbUtils.getConnection();

            // B2 - Tao cong cu thuc thi cau lenh
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // B3 - Duyet bang 
            while (rs.next()) {
                String userId = rs.getString("userID");
                String fullName = rs.getString("fullName");
                String password1 = rs.getString("password");
                String roleID = rs.getString("roleID");
                boolean status = rs.getBoolean("status");

                UserDTO userDTO = new UserDTO(userId, fullName, password1, roleID, status);
                if (userDTO.isStatus()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public UserDTO getUserByID(String userID) {
        try {
            String sql = "SELECT * FROM tblUsers "
                    + " WHERE userID='" + userID + "'";
            // B1 - Ket noi
            Connection conn = DbUtils.getConnection();

            // B2 - Tao cong cu thuc thi cau lenh
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            // B3 - Duyet bang 
            while (rs.next()) {
                String userId = rs.getString("userID");
                String fullName = rs.getString("fullName");
                String password1 = rs.getString("password");
                String roleID = rs.getString("roleID");
                boolean status = rs.getBoolean("status");

                UserDTO userDTO = new UserDTO(userId, fullName, password1, roleID, status);
                return userDTO;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
