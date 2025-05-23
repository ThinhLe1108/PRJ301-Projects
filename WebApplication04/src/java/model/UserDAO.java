/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class UserDAO {
    ArrayList<UserDTO> list;

    public UserDAO() {
        this.list = new ArrayList<>();
        list.add(new UserDTO("admin", "Administrator", "1", "AD", true));
        list.add(new UserDTO("SE192111", "Le Duc Thinh", "hcm", "MB", true));
    }
    
    public boolean login(String username, String password){
        for (UserDTO userDTO : list) {
            if(userDTO.getUserID().equalsIgnoreCase(username)
                    && userDTO.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    
    public UserDTO getUserById(String userId){
        for (UserDTO userDTO : list) {
            if(userDTO.getUserID().equalsIgnoreCase(userId)){
                return userDTO;
            }
        }
        return null;
    }
    
}
