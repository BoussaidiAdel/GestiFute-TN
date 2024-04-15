/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomException;

/**
 *
 * @author bouss
 */
public class InvalidIntException extends Exception {
        public InvalidIntException() {
            super("Entier Invalid");}
    
    public InvalidIntException(String message) {
            super(message);}}