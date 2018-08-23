/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.stockinvestment.dao;

/**
 *
 * @author James
 */
public class SIPersistenceException extends Exception {
    
    public SIPersistenceException(String string) {
        super(string);
    }

    public SIPersistenceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
