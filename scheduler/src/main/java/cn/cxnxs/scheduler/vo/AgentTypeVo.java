package cn.cxnxs.scheduler.vo;

import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.IAgent;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2020-11-22 01:32
 **/
@Getter
@Setter
public class AgentTypeVo {

    private Integer id;

    /**
     * agent类型名称
     */
    private String agentTypeName;

    /**
     * 处理器路径
     */
    private String handler;

    /**
     * 是否定时执行
     */
    private Boolean canBeScheduled;

    /**
     * 是否生成事件
     */
    private Boolean canCreateEvents;

    /**
     * 是否空运行
     */
    private Boolean canDryRun;

    /**
     * 是否接收事件
     */
    private Boolean canReceiveEvents;

    /**
     * 默认定时周期
     */
    private Integer defaultSchedule;

    private String defaultScheduleStr;

    private JSONArray schedules;

    private String name;

    private Integer value;

    /**
     * 使用方法
     */
    private String descriptionHtml;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 表单地址
     */
    private String formUrl;

    /**
     * 配置模板
     */
    private JSONObject optionsTemplate;

    /**
     * 表单校验规则，如果配置是json类型
     */
    private JSONObject optionsSchema;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    private JSONArray keepEventsTimes;

    /**
     * 搜索关键字
     */
    private String keyword;

    /**
     * 执行计划枚举
     */
    public enum ScheduleEnum {
        EVERY_1M(1, "0 */1 * * * ?", "每1分钟"),
        EVERY_2M(2, "0 */2 * * * ?", "每2分钟"),
        EVERY_5M(3, "0 */5 * * * ?", "每5分钟"),
        EVERY_10M(4, "0 */10 * * * ?", "每10分钟"),
        EVERY_30M(5, "0 */30 * * * ?", "每30分钟"),
        EVERY_1H(6, "0 0 */1 * * ?", "每1小时"),
        EVERY_2H(7, "0 0 */2 * * ?", "每2小时"),
        EVERY_5H(8, "0 0 */5 * * ?", "每5小时"),
        EVERY_12H(9, "0 0 */12 * * ?", "每12小时"),
        EVERY_1D(10, "0 0 1 * * ?", "每天"),
        EVERY_2D(11, "0 0 0 */2 * ?", "每2天"),
        EVERY_MONDAY(12, "0 0 0 ? * MON", "每周一"),
        MIDNIGHT(13, "* * 0 * * ?", "每天零点"),
        AM1(14, "* * 1 * * ? ", "上午1点"),
        AM2(15, "* * 2 * * ?", "上午2点"),
        AM3(16, "* * 3 * * ?", "上午3点"),
        AM4(17, "* * 4 * * ?", "上午4点"),
        AM5(18, "* * 5 * * ?", "上午5点"),
        AM6(19, "* * 6 * * ?", "上午6点"),
        AM7(20, "* * 7 * * ?", "上午7点"),
        AM8(21, "* * 8 * * ?", "上午8点"),
        AM9(22, "* * 9 * * ?", "上午9点"),
        AM10(23, "* * 10 * * ?", "上午10点"),
        AM11(24, "* * 11 * * ?", "上午11点"),
        NOON(25, "* * 12 * * ?", "中午12点"),
        PM1(26, "* * 13 * * ?", "下午1点"),
        PM2(27, "* * 14 * * ?", "下午2点"),
        PM3(28, "* * 15 * * ?", "下午3点"),
        PM4(29, "* * 16 * * ?", "下午4点"),
        PM5(30, "* * 17 * * ?", "下午5点"),
        PM6(31, "* * 18 * * ?", "下午6点"),
        PM7(32, "* * 19 * * ?", "下午7点"),
        PM8(33, "* * 20 * * ?", "晚上8点"),
        PM9(34, "* * 21 * * ?", "晚上9点"),
        PM10(35, "* * 22 * * ?", "晚上10点"),
        PM11(36, "* * 23 * * ?", "晚上11点"),
        NEVER(37, null, "手动触发");
        /**
         * 代码
         */
        private final Integer code;

        /**
         * cron表达式
         */
        private final String cron;

        /**
         * 描述
         */
        private final String desc;

        ScheduleEnum(Integer code, String cron, String desc) {
            this.code = code;
            this.cron = cron;
            this.desc = desc;
        }


        /**
         * 将该枚举全部转化成json
         *
         * @return json字符串
         */
        public static JSONArray toJson() {
            JSONArray jsonArray = new JSONArray();
            for (ScheduleEnum e : ScheduleEnum.values()) {
                JSONObject object = new JSONObject();
                object.put("code", e.getCode());
                object.put("cron", e.getCron());
                object.put("desc", e.getDesc());
                jsonArray.add(object);
            }
            return jsonArray;
        }

        @Override
        public String toString() {
            JSONObject object = new JSONObject();
            object.put("code", code);
            object.put("cron", cron);
            object.put("desc", desc);
            return object.toJSONString();
        }

        public Integer getCode() {
            return code;
        }

        public String getCron() {
            return cron;
        }

        public static String getCron(Integer code) {
            for (ScheduleEnum e : ScheduleEnum.values()) {
                if (e.getCode().equals(code)) {
                    return e.cron;
                }
            }
            return null;
        }

        public String getDesc() {
            return desc;
        }

        public static String getDesc(Integer code) {
            for (ScheduleEnum e : ScheduleEnum.values()) {
                if (e.getCode().equals(code)) {
                    return e.desc;
                }
            }
            return null;
        }
    }

    /**
     * 数据保存时间
     */
    @Getter
    public enum KeepEventsTime {
        FOREVER(1, null, "永久"),
        ONR_HOUR(2, 1, "1小时"),
        SIX_HOUR(3, 6, "6小时"),
        ONE_DAY(4, 24, "1天"),
        TWO_DAYS(5, 2 * 24, "2天"),
        THREE_DAYS(6, 3 * 24, "3天"),
        FOUR_DAYS(7, 4 * 24, "4天"),
        FIVE_DAYS(8, 5 * 24, "5天"),
        SIX_DAYS(9, 6 * 24, "6天"),
        SEVEN_DAYS(10, 7 * 24, "7天"),
        FOURTEEN_DAYS(11, 14 * 24, "14天"),
        TWENTY_ONE_DAYS(12, 21 * 24, "21天"),
        THIRTY_DAYS(13, 30 * 24, "30天"),
        FORTY_FIVE_DAYS(14, 45 * 24, "45天"),
        NINETY_DAYS(15, 90 * 24, "90天"),
        ONE_HUNDRED_AND_EIGHTY_DAYS(16, 180 * 24, "180天"),
        ONE_YEAR(17, 365 * 24, "1年"),
        ;
        private final Integer code;

        private final Integer hours;

        private final String desc;

        KeepEventsTime(Integer code, Integer hours, String desc) {
            this.code = code;
            this.hours = hours;
            this.desc = desc;
        }

        /**
         * 将该枚举全部转化成json
         *
         * @return json字符串
         */
        public static JSONArray toJson() {
            JSONArray jsonArray = new JSONArray();
            for (KeepEventsTime e : KeepEventsTime.values()) {
                JSONObject object = new JSONObject();
                object.put("code", e.getCode());
                object.put("hours", e.getHours());
                object.put("desc", e.getDesc());
                jsonArray.add(object);
            }
            return jsonArray;
        }

        public static Integer getHours(Integer code) {
            for (KeepEventsTime e : KeepEventsTime.values()) {
                if (e.getCode().equals(code)) {
                    return e.hours;
                }
            }
            return null;
        }

        public static KeepEventsTime getValue(Integer code) {
            for (KeepEventsTime e : KeepEventsTime.values()) {
                if (e.getCode().equals(code)) {
                    return e;
                }
            }
            return null;
        }

        public static String getDesc(Integer code) {
            for (KeepEventsTime e : KeepEventsTime.values()) {
                if (e.getCode().equals(code)) {
                    return e.desc;
                }
            }
            return null;
        }
    }

    public Integer getValue() {
        return this.id;
    }

    public JSONArray getKeepEventsTimes() {
        this.keepEventsTimes = KeepEventsTime.toJson();
        return keepEventsTimes;
    }

    public String getDefaultScheduleStr() {
        this.defaultScheduleStr = ScheduleEnum.getDesc(this.defaultSchedule);
        return this.defaultScheduleStr;
    }

    public JSONArray getSchedules() {
        this.schedules = ScheduleEnum.toJson();
        return schedules;
    }


    public void setOptionsTemplate(String optionsTemplate) {
        if (optionsTemplate != null) {
            this.optionsTemplate = JSONObject.parseObject(optionsTemplate, Feature.OrderedField);
        }
    }

    public void setOptionsSchema(String optionsSchema) {
        if (optionsSchema != null) {
            this.optionsSchema = JSONObject.parseObject(optionsSchema, Feature.OrderedField);
        }
    }

    /**
     * 获取处理器class
     *
     * @return
     * @throws ClassNotFoundException
     */
    private Class<? extends IAgent> handlerClass;

    public Class<? extends IAgent> getHandlerClass() throws ClassNotFoundException {
        if (handlerClass == null && StringUtil.isNotEmpty(this.handler)) {
            this.handlerClass = (Class<IAgent>) Class.forName(this.handler);
        }
        return handlerClass;
    }
}
