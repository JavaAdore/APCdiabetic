/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author orcl
 */
public class ValueContainer {
    
    
    public ValueContainer(){}
    public ValueContainer(double value)
    {
        this.value = value;
    }
    private double value;

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    
    
}
