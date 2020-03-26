package cn.acyco.util;

import cn.acyco.life.util.TimeUtil;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.Date;

/**
 * @author Acyco
 * @create 2020-03-26 09:11
 */
public class TimeUtilTest {

    @Test
    public void testGetDescriptionTimeFromTimestamp() {
        System.out.println(TimeUtil.getDescriptionTimeFromTimestampMS(1585185625000L));
        System.out.println(TimeUtil.getDescriptionTimeFromTimestampS(1585185625L));
    }
    
    @Test
    public void testGetFormatTimeFromTimestamp() {
        System.out.println(TimeUtil.getFormatTimeFromTimestamp(1585185625000L, TimeUtil.TIME_FORMAT_TYPE.FORMAT_DATE));
        System.out.println(TimeUtil.getFormatTimeFromTimestamp(1585185625000L, TimeUtil.TIME_FORMAT_TYPE.FORMAT_DATE_TIME));
        System.out.println(TimeUtil.getFormatTimeFromTimestamp(1585185625000L, TimeUtil.TIME_FORMAT_TYPE.FORMAT_DATE_TIME_SEC));
        System.out.println(TimeUtil.getFormatTimeFromTimestamp(1585185625000L, TimeUtil.TIME_FORMAT_TYPE.FORMAT_MONTH_DAY_TIME));
        System.out.println(TimeUtil.getFormatTimeFromTimestamp(1585185625000L, TimeUtil.TIME_FORMAT_TYPE.FORMAT_TIME));
        System.out.println(TimeUtil.getFormatTimeFromTimestamp(1585185625000L, "yyyy-MM-dd hh:mm:ss"));
    }

    @Test
    public void testGetMixTimeFromTimestamp() {
        System.out.println(TimeUtil.getMixTimeFromTimestamp(1585185625000L,100000, TimeUtil.TIME_FORMAT_TYPE.FORMAT_DATE));
    }
    
    @Test
    public void testGetCurrentTime() {
        System.out.println(TimeUtil.getCurrentTime(TimeUtil.TIME_FORMAT_TYPE.FORMAT_DATE_TIME));
        System.out.println(TimeUtil.getCurrentTime("yyyy-MM-dd h:mm:ss"));
    }

    @Test
    public void testGetTimeFromString() {
        System.out.println(TimeUtil.getTimeFromString("2020-03-26 10:57:58","yyyy-MM-dd h:mm:ss"));
        System.out.println(TimeUtil.getTimeFromString("2020-03-26 10:57", TimeUtil.TIME_FORMAT_TYPE.FORMAT_DATE_TIME));
    }
    
    @Test
    public void testGetStringFromTime() {
        System.out.println(TimeUtil.getStringFromTime(new Date(System.currentTimeMillis()),TimeUtil.TIME_FORMAT_TYPE.FORMAT_DATE_TIME));
        System.out.println(TimeUtil.getStringFromTime(new Date(System.currentTimeMillis()),"yyyy-MM-dd h:mm:ss"));
        
    }
}
