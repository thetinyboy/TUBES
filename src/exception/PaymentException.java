/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author Lucas Manuel SB
 */
public class PaymentException extends Exception{
    public String message()
    {
        return "[!] Pembayaran Minimal 50% dari Total Harga [!]";
    }
}
