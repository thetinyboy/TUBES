/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author Lucas Manuel SB
 */
public class NomorTeleponException extends Exception{
    public String message()
    {
        return "No Telepon Hanya Boleh Terdiri dari Angka atau Diawali +";
    }
}
