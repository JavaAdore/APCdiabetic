/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JOptionPane;
import javax.xml.datatype.XMLGregorianCalendar;
import utils.Util;
import xml.Users;

/**
 *
 * @author orcl
 */
public class AlertThread extends Thread {

    UserBusiness userBusiness = new UserBusiness();

    Users.UserInfo.UserTimeSetting timeSetting = userBusiness.extractToDayUserTimeSetting();
    Map<String, XMLGregorianCalendar> datesToNotify;

    public AlertThread() {

    }

    public void run() {
        if (timeSetting != null) {
            datesToNotify = new ConcurrentHashMap ();
            fillDatesToNotifyList();
            for (;;) {
                try {
                    for (String key : datesToNotify.keySet()) {
                        XMLGregorianCalendar xmlGregorianCalendar = datesToNotify.get(key);
                        {
                            if (Util.areTimesEqualsEachOthersBySecond(xmlGregorianCalendar, new Date())) {
                                NotifyUser(key);
                                Util.removeFromMap(datesToNotify , key);
                            }

                        }
                        sleep(100);

                    }
                } catch (InterruptedException ex) {
                }
            }

        }
    }

    private void fillDatesToNotifyList() {

        if (timeSetting.getBeforeBreakfast() != null) {

            datesToNotify.put(Util.beforeBreakfast, timeSetting.getBeforeBreakfast());
        }
        if (timeSetting.getBreackfast() != null) {
            datesToNotify.put(Util.breakfast, timeSetting.getBreackfast());
        }
        if (timeSetting.getLunch() != null) {
            datesToNotify.put(Util.lunch, timeSetting.getLunch());
        }
        if (timeSetting.getDinner() != null) {
            datesToNotify.put(Util.dinner, timeSetting.getDinner());
        }
        if (timeSetting.getBeforeSleep() != null) {
            datesToNotify.put(Util.beforeSleep, timeSetting.getBeforeSleep());
        }

    }

    private void NotifyUser(String key) {
        JOptionPane.showMessageDialog(null, String.format("Don't forget to take measurement of %s time", key));

    }
}
