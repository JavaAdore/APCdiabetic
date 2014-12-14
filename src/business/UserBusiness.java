/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import APCD.APCdiabetic;
import APCD.DailyMeasurement;
import APCD.MeasurementsInfo;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import sun.awt.windows.WToolkit;
import utils.Util;
import xml.Users;
import xml.Users.UserInfo;
import xml.Users.UserInfo.DailyMeasurement.Measurement;

/**
 *
 * @author orcl
 */
public class UserBusiness {

    public Users.UserInfo getUserByEmail(String email) {

        for (UserInfo userInfo : Util.XmlUsers.getUserInfo()) {
            if (userInfo.getEmail().equalsIgnoreCase(email)) {
                return userInfo;
            }
        }

        return null;
    }

    public UserInfo.UserTimeSetting extractToDayUserTimeSetting() {
        if (Util.isNotEmpty(Util.currentLoginUser.getUserTimeSetting())) {
            Date toDay = new Date();
            for (UserInfo.UserTimeSetting userTimeSettings : Util.currentLoginUser.getUserTimeSetting()) {
                if (Util.areDatesEqualsEachOthers(userTimeSettings.getUserTimeSettingDate(), toDay)) {
                    return userTimeSettings;
                }
            }
        }
        return null;
    }

    public void saveUsersBackIntoFile() {
        try {
            Util.XmlUsers.getUserInfo().remove(Util.currentLoginUser);
            Util.XmlUsers.getUserInfo().add(Util.currentLoginUser);
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller marchaller = context.createMarshaller();
            marchaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marchaller.marshal(Util.XmlUsers, APCdiabetic.xmlFile);
        } catch (JAXBException ex) {
            Util.displayMessage(null, "Unable to add new User");
            System.exit(0);
        }
    }

    public UserInfo.DailyMeasurement extractToDayUserDailyMeasurement() {
        if (Util.isNotEmpty(Util.currentLoginUser.getUserTimeSetting())) {
            Date toDay = new Date();
            for (UserInfo.DailyMeasurement dailyMeasurement : Util.currentLoginUser.getDailyMeasurement()) {
                if (Util.areDatesEqualsEachOthers(dailyMeasurement.getMeasurementDate(), toDay)) {
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
            if (Util.isNotEmpty(userInfo.getDailyMeasurement())) {
                for (UserInfo.DailyMeasurement dailyMeasurement : userInfo.getDailyMeasurement()) {
                    if (Util.isNotEmpty(dailyMeasurement.getMeasurement())) {
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

        if (Util.isNotEmpty(Util.currentLoginUser.getDailyMeasurement())) {
            result = new ArrayList();
            for (UserInfo.DailyMeasurement dailyMeasurement : Util.currentLoginUser.getDailyMeasurement()) {

                if (dailyMeasurement.getMeasurementDate() != null) {

               //     if (Util.isDateBetween(dailyMeasurement.getMeasurementDate(), new Date(), c.getTime())) {
                        result.add(dailyMeasurement);
                //    }

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
            int dayNumber = Util.extractDayNumberFromDate(dailyMeasurement.getMeasurementDate());
            Util.replaceInMap(dayNumber , dailyMeasurement, result);

        }
        return result;
    }

    public Map<Integer, UserInfo.DailyMeasurement> extractLastSevenDailyMeasurements() {
        return dailyMeasurementListToMap(extractlastSevenDaysOfDailyMeasurements());

    }

    public String prepareUserDetailsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("MR %s \n", Util.getNotNullValue(Util.currentLoginUser.getName())));
        stringBuilder.append(prepareColumns());
        for (int day : extractLastSevenDailyMeasurements().keySet()) {
            Users.UserInfo.DailyMeasurement data = extractLastSevenDailyMeasurements().get(day);
            stringBuilder.append(String.format("Date : %s \n ", Util.getFullDate(data.getMeasurementDate())));
            try {
                stringBuilder.append(String.format("                  %s\t", Util.getDayName(data.getMeasurementDate().toGregorianCalendar().getTime())));
            } catch (Exception ex) {
                stringBuilder.append("                   ");
            }
            stringBuilder.append(data);

        }
        return stringBuilder.toString();

    }

    public String prepareColumns() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> columns = Arrays.asList(Util.times);
        for (String c : columns) {
            c = Util.refineWidth(c);
            stringBuilder.append(String.format("%s\t", c));

        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public Map<String, String> getModificationResults(String beforeBreakfast, String breakfast, String lunch, String dinner, String beforeSleep, String suddenDrop) {
        Map<String, String> result = new HashMap();
        UserInfo.DailyMeasurement toDayMeasurement = extractToDayUserDailyMeasurement();
        if (toDayMeasurement != null) {

            Map<String, String> alreadySettedDailyMeasurments = Util.<String, String>ListToMap(toDayMeasurement.getMeasurement(), "timeOfMeasurement", "measurementValue");
            String returnedResult = String.valueOf(Util.<String, String>extractFromMap(Util.beforeBreakfast, alreadySettedDailyMeasurments));
            if (returnedResult != null) {
                if (!Util.areStringsEqualEachOther(beforeBreakfast, returnedResult)) {
                    String measurementChangeResult = doBusinessOfCheckingMeasurement(Util.beforeBreakfast, beforeBreakfast, true);
                    result.put(Util.beforeBreakfast, measurementChangeResult);
                }
                returnedResult = String.valueOf(Util.<String, String>extractFromMap(Util.breakfast, alreadySettedDailyMeasurments));

                if (!Util.areStringsEqualEachOther(breakfast, returnedResult)) {
                    String measurementChangeResult = doBusinessOfCheckingMeasurement(Util.breakfast, breakfast);
                    result.put(Util.breakfast, measurementChangeResult);
                }
                returnedResult = String.valueOf(Util.<String, String>extractFromMap(Util.lunch, alreadySettedDailyMeasurments));

                if (!Util.areStringsEqualEachOther(lunch, returnedResult)) {
                    String measurementChangeResult = doBusinessOfCheckingMeasurement(Util.lunch, lunch);
                    result.put(Util.lunch, measurementChangeResult);
                }
                returnedResult = String.valueOf(Util.<String, String>extractFromMap(Util.dinner, alreadySettedDailyMeasurments));

                if (!Util.areStringsEqualEachOther(dinner, returnedResult)) {
                    String measurementChangeResult = doBusinessOfCheckingMeasurement(Util.dinner, dinner);
                    result.put(Util.dinner, measurementChangeResult);
                }
                returnedResult = String.valueOf(Util.<String, String>extractFromMap(Util.beforeSleep, alreadySettedDailyMeasurments));

                if (!Util.areStringsEqualEachOther(beforeSleep, returnedResult)) {
                    String measurementChangeResult = doBusinessOfCheckingMeasurement(Util.beforeSleep, beforeSleep);
                    result.put(Util.beforeSleep, measurementChangeResult);
                }
                returnedResult = String.valueOf(Util.<String, String>extractFromMap(Util.suddenDrop, alreadySettedDailyMeasurments));

                if (!Util.areStringsEqualEachOther(suddenDrop, returnedResult)) {
                    String measurementChangeResult = doBusinessOfCheckingMeasurement(Util.suddenDrop, suddenDrop);
                    result.put(Util.suddenDrop, measurementChangeResult);
                }

            }

            System.out.println();

        }
        return result;

    }

    private String doBusinessOfCheckingMeasurement(String beforeBreakfast, String returnedResult) {
        return doBusinessOfCheckingMeasurement(beforeBreakfast, returnedResult, false);
    }

    private String doBusinessOfCheckingMeasurement(String measure, String returnedResult, boolean isBreakfast) {

        String result;
        Double myMeasure = Double.parseDouble(returnedResult);
        if (isBreakfast) {
            if (myMeasure >= 126) {
                return Util.OVER_AVERAGE;
            }
            if (myMeasure >= 110 && myMeasure < 126) {
                return Util.NORMAL;
            }
            if (myMeasure < 110) {
                return Util.DOWN_AVERAGE;
            }

        } else {
            if (myMeasure >= 210) {
                return Util.OVER_AVERAGE;
            }
            if (myMeasure >= 110 && myMeasure < 125) {
                return Util.NORMAL;
            }
            if (myMeasure < 110) {
                return Util.DOWN_AVERAGE;
            }

        }
        return "";
    }

}
