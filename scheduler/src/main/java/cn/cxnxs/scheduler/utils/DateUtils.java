package cn.cxnxs.scheduler.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date parseDate(String dateString) {
        String[] dateFormats = {
                "yyyy年MM月dd日",
                "yyyy年MM月dd日 HH:mm:",
                "yyyy年MM月dd日 HH:mm:ss",
                "yyyy-MM-dd",
                "yyyy-MM-dd HH:mm",
                "yyyy-MM-dd HH:mm:ss",
                "yyyy/MM/dd",
                "yyyy/MM/dd HH:mm",
                "yyyy/MM/dd HH:mm:ss",
                "MM/dd/yyyy",
                "MM/dd/yyyy HH:mm",
                "MM/dd/yyyy HH:mm:ss",
                "dd/MM/yyyy",
                "dd/MM/yyyy HH:mm",
                "dd/MM/yyyy HH:mm:ss",
                // 可以根据需要添加更多日期格式
        };

        for (String format : dateFormats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                return sdf.parse(dateString);
            } catch (ParseException e) {
                // 当前格式不匹配，尝试下一个格式
            }
        }
        // 如果所有格式都不匹配，返回 null 或者抛出异常，视情况而定
        return null;
    }
}
