/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package APCD;

/**
 *
 * @author orcl
 */
public class MeasurementsInfo {
    
    private double total;
    private int count;
    
    public MeasurementsInfo(){}

    public MeasurementsInfo(double total, int count) {
        this.total = total;
        this.count = count;
    }
    
    
    public double getMeasurementsAvarage()
    {
        if( total!=0 && count !=0)
        {
            return total / count;
        }
        return 0;
    }
    
    
    

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    
}
