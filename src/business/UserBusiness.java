/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import APCD.APCdiabetic;
import APCD.DailyMeasurement;
import APCD.MeasurementsInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import sun.awt.windows.WToolkit;
import util.Utils;
import xml.Users;
import xml.Users.UserInfo;
import xml.Users.UserInfo.DailyMeasurement.Measurement;

/**
 *
 * @author orcl
 */
public class UserBusiness {

    public Users.UserInfo getUserByEmail(String email) {

        for (UserInfo userInfo : Utils.XmlUsers.getUserInfo()) {
            if (userInfo.getEmail().equalsIgnoreCase(email)) {
                return userInfo;
            }
        }

        return null;
    }

    public UserInfo.UserTimeSetting extractToDayUserTimeSetting() {
        if (Utils.isNotEmpty(Utils.currentLoginUser.getUserTimeSetting())) {
            Date toDay = new Date();
            for (UserInfo.UserTimeSetting userTimeSettings : Utils.currentLoginUser.getUserTimeSetting()) {
                if (Utils.areDatesEqualsEachOthers(userTimeSettings.getUserTimeSettingDate(), toDay)) {
                    return userTimeSettings;
                }
            }
        }
        return null;
    }

    public void saveUsersBackIntoFile() {
        try {
            Utils.XmlUsers.getUserInfo().remove(Utils.currentLoginUser);
            Utils.XmlUsers.getUserInfo().add(Utils.currentLoginUser);
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller marchaller = context.createMarshaller();
            marchaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marchaller.marshal(Utils.XmlUsers, APCdiabetic.xmlFile);
        } catch (JAXBException ex) {
            Utils.displayMessage(null, "Unable to add new User");
            System.exit(0);
        }
    }

    public UserInfo.DailyMeasurement extractToDayUserDailyMeasurement() {
        if (Utils.isNotEmpty(Utils.currentLoginUser.getUserTimeSetting())) {
            Date toDay = new Date();
            for (UserInfo.DailyMeasurement dailyMeasurement : Utils.currentLoginUser.getDailyMeasurement()) {
                if (Utils.areDatesEqualsEachOthers(dailyMeasurement.getMeasurementDate(), toDay)) {
                    return dailyMeasurement;
                }
            }
        }
        return null;
    }

    public MeasurementsInfo getMeasurementsInfo(UserInfo userInfo) {
        double result = 0;
        int counter = 0;
        if (userInfo != null) {
            if (Utils.isNotEmpty(userInfo.getDailyMeasurement())) {
                for (UserInfo.DailyMeasurement dailyMeasurement : userInfo.getDailyMeasurement()) {
                    if (Utils.isNotEmpty(dailyMeasurement.getMeasurement())) {
                        for (Measurement measurement : dailyMeasurement.getMeasurement()) {
                            result += measurement.getMeasurementValue();
                            counter++;
                        }
                    }
                }
            }
        }

        return new MeasurementsInfo(result, counter);
    }

    public List<Users.UserInfo.DailyMeasurement> extractlastSevenDaysOfDailyMeasurements() {
        List<Users.UserInfo.DailyMeasurement> result = null;

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -7);

        if (Utils.isNotEmpty(Utils.currentLoginUser.getDailyMeasurement())) {
            result = new ArrayList();
            for (UserInfo.DailyMeasurement dailyMeasurement : Utils.currentLoginUser.getDailyMeasurement()) {

                if (dailyMeasurement.getMeasurementDate() != null) {
                    //if (Utils.isDateBetween(dailyMeasurement.getMeasurementDate(), new Date(), c.getTime())) {

                    result.add(dailyMeasurement);
                    // }
                }

            }
        }
        return result;
    }

    public Map<Integer, UserInfo.DailyMeasurement> dailyMeasurementListToMap(List<Users.UserInfo.DailyMeasurement> dailyMeasurementList) {
        Map<Integer, UserInfo.DailyMeasurement> result = new TreeMap();

        for (int i = 0; i < 7; i++) {
            result.put(i, UserInfo.DailyMeasurement.constructDefaultDailyMeasurement(i));
        }

        for (Users.UserInfo.DailyMeasurement dailyMeasurement : dailyMeasurementList) {
            int dayNumber = Utils.extractDayNumberFromDate(dailyMeasurement.getMeasurementDate());
            Utils.replaceInMap(dayNumber - 1, dailyMeasurement, result);

        }
        return result;
    }

    public Map<Integer, UserInfo.DailyMeasurement> extractLastSevenDailyMeasurements() {
        return dailyMeasurementListToMap(extractlastSevenDaysOfDailyMeasurements());

    }
    public String prepareUserDetailsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("MR %s \n", Utils.getNotNullValue(Utils.currentLoginUser.getName())));
        stringBuilder.append(prepareColumns());
        for (int day : extractLastSevenDailyMeasurements().keySet()) {
            Users.UserInfo.DailyMeasurement data = extractLastSevenDailyMeasurements().get(day);
            stringBuilder.append(String.format("Date : %s \n ", Utils.getFullDate(data.getMeasurementDate())));
            try
            {
            stringBuilder.append(String.format("                  %s\t", Utils.getDayName(data.getMeasurementDate().toGregorianCalendar().getTime())));
            }catch(Exception ex)
            {
                stringBuilder.append("                   ");
            }
                        stringBuilder.append(data);

        }
        return stringBuilder.toString();

    }

    public String prepareColumns() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> columns = Arrays.asList(Utils.times);
        for (String c : columns) {
            c = Utils.refineWidth(c);
            stringBuilder.append(String.format("%s\t", c));

        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

}
