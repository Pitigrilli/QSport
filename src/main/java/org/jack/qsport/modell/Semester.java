/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jack.qsport.modell;

/**
 *
 * @author claus
 */
public enum Semester {
    Q11_1, Q11_2, Q12_1, Q12_2;
    
        public static Semester get(String name) {
            if (name.equals("11-1")) {
                return Q11_1;
            }
            else if (name.equals("11-2")) {
                return Q11_2;
            }
            else if (name.equals("12-1")) {
                return Q12_1;
            }
            else if (name.equals("12-2")) {
                return Q12_2;
            }
            return Q12_2;
        
    }
}
