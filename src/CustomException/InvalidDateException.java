package CustomException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bouss
 */
  public class InvalidDateException extends Exception {
        public InvalidDateException() {
            super("veillez choisir une autre Date ");}
        public InvalidDateException(String message) {
        super(message);
    }
    }
    
