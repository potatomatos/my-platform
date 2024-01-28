/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : webspider

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2024-01-29 00:27:35
*/

SET
FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent`
(
  `id`                    int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id`               int(11) DEFAULT NULL COMMENT '所属用户',
  `options`               text         NOT NULL COMMENT '服务配置',
  `type`                  int(11) NOT NULL COMMENT '服务类型',
  `name`                  varchar(191) NOT NULL COMMENT '服务名称',
  `schedule`              varchar(191)          DEFAULT NULL COMMENT '服务运行周期计划',
  `data_count`            int(11) NOT NULL DEFAULT '0' COMMENT '数据总数',
  `last_check_at`         datetime              DEFAULT NULL COMMENT '上次检测时间',
  `last_receive_at`       datetime              DEFAULT NULL COMMENT '上次接收到数据时间',
  `last_checked_data_id`  int(11) DEFAULT NULL COMMENT '上次检查数据源数据id',
  `last_web_request_at`   datetime              DEFAULT NULL COMMENT '上次发送请求时间',
  `keep_data_time`        int(11) DEFAULT NULL COMMENT '结果数据保存时长',
  `last_data_ime`         datetime              DEFAULT NULL COMMENT '上次产生数据时间',
  `last_error_log_time`   datetime              DEFAULT NULL COMMENT '上次产生错误时间',
  `propagate_immediately` tinyint(1) DEFAULT NULL COMMENT '数据是否立即传播到下一个服务',
  `state`                 int(1) NOT NULL DEFAULT '0' COMMENT '状态 0暂停 1待运行 2执行中 3已禁用',
  `created_at`            datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at`            datetime              DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY                     `index_agents_on_user_id_and_created_at` (`user_id`,`created_at`) USING BTREE,
  KEY                     `index_agents_on_type` (`type`) USING BTREE,
  KEY                     `index_agents_on_schedule` (`schedule`) USING BTREE,
  KEY                     `index_agents_on_disabled` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='爬虫任务配置信息';

-- ----------------------------
-- Records of agent
-- ----------------------------
INSERT INTO `agent`
VALUES ('5', null,
        '{\n  \"url\": \"https://movie.douban.com/cinema/nowplaying/shanghai/\",\n  \"method\": \"get\",\n  \"type\": \"html\",\n  \"mode\": \"on_change\",\n  \"uniqueness_look_back\": 1,\n  \"include_sort_info\": true,\n  \"extract\": {\n    \"title\": {\n      \"css\": \"li[data-category=\'nowplaying\']\",\n      \"value\": \"@data-title\"\n    },\n    \"score\": {\n      \"css\": \"li[data-category=\'nowplaying\']\",\n      \"value\": \"@data-score\"\n    },\n    \"star\": {\n      \"css\": \"li[data-category=\'nowplaying\']\",\n      \"value\": \"@data-star\"\n    },\n    \"release\": {\n      \"css\": \"li[data-category=\'nowplaying\']\",\n      \"value\": \"@data-release\"\n    },\n    \"region\": {\n      \"css\": \"li[data-category=\'nowplaying\']\",\n      \"value\": \"@data-region\"\n    },\n    \"actors\": {\n      \"css\": \"li[data-category=\'nowplaying\']\",\n      \"value\": \"@data-actors\"\n    },\n    \"director\": {\n      \"css\": \"li[data-category=\'nowplaying\']\",\n      \"value\": \"@data-director\"\n    }\n  },\n  \"headers\": {\n    \"user-agent\": \"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36 SE 2.X MetaSr 1.0\"\n  },\n  \"data\": {},\n  \"disable_ssl_verification\": true,\n  \"template\": {},\n  \"events_order\": []\n}',
        '1', '豆瓣', '37', '0', null, null, null, null, '1', null, null, '1', '2', '2021-01-16 01:41:25', null);
INSERT INTO `agent`
VALUES ('6', null,
        '{\"url\":\"https://movie.douban.com/cinema/nowplaying/hangzhou/\",\"method\":\"get\",\"type\":\"html\",\"mode\":\"on_change\",\"uniqueness_look_back\":1,\"include_sort_info\":true,\"extract\":{\"title\":{\"css\":\"li[data-category=\'nowplaying\']\",\"value\":\"@data-title\"},\"score\":{\"css\":\"li[data-category=\'nowplaying\']\",\"value\":\"@data-score\"},\"star\":{\"css\":\"li[data-category=\'nowplaying\']\",\"value\":\"@data-star\"},\"release\":{\"css\":\"li[data-category=\'nowplaying\']\",\"value\":\"@data-release\"},\"region\":{\"css\":\"li[data-category=\'nowplaying\']\",\"value\":\"@data-region\"},\"actors\":{\"css\":\"li[data-category=\'nowplaying\']\",\"value\":\"@data-actors\"},\"director\":{\"css\":\"li[data-category=\'nowplaying\']\",\"value\":\"@data-director\"}},\"headers\":{\"user-agent\":\"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36 SE 2.X MetaSr 1.0\"},\"data\":{},\"disable_ssl_verification\":false,\"template\":{},\"events_order\":[]}',
        '1', '测试立即传播', '37', '0', null, null, null, null, '1', null, null, null, '0', '2021-02-14 23:42:31',
        null);

-- ----------------------------
-- Table structure for agent_logs
-- ----------------------------
DROP TABLE IF EXISTS `agent_logs`;
CREATE TABLE `agent_logs`
(
  `id`                int(11) NOT NULL AUTO_INCREMENT,
  `agent_id`          int(11) NOT NULL,
  `message`           text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `level`             int(11) NOT NULL DEFAULT '3',
  `inbound_event_id`  int(11) DEFAULT NULL,
  `outbound_event_id` int(11) DEFAULT NULL,
  `created_at`        datetime DEFAULT NULL,
  `updated_at`        datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of agent_logs
-- ----------------------------

-- ----------------------------
-- Table structure for agent_type
-- ----------------------------
DROP TABLE IF EXISTS `agent_type`;
CREATE TABLE `agent_type`
(
  `id`                 int(11) NOT NULL AUTO_INCREMENT,
  `agent_type_name`    varchar(191) NOT NULL COMMENT 'agent类型名称',
  `handler`            varchar(191) DEFAULT NULL COMMENT '处理器',
  `can_be_scheduled`   tinyint(1) NOT NULL COMMENT '是否定时执行',
  `can_create_events`  tinyint(1) NOT NULL COMMENT '是否生成事件',
  `can_dry_run`        tinyint(1) NOT NULL COMMENT '是否空运行',
  `can_receive_events` tinyint(1) NOT NULL COMMENT '是否接收事件',
  `default_schedule`   int(11) DEFAULT NULL COMMENT '默认定时周期',
  `description_html`   mediumtext COMMENT '使用方法',
  `introduction`       mediumtext COMMENT '简介',
  `form_url`           varchar(191) NOT NULL COMMENT '表单地址',
  `options_template`   mediumtext COMMENT '配置模板',
  `options_schema`     mediumtext COMMENT '表单校验规则，如果配置是json类型',
  `created_at`         datetime     NOT NULL COMMENT '创建时间',
  `updated_at`         datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='agent定义信息';

-- ----------------------------
-- Records of agent_type
-- ----------------------------
INSERT INTO `agent_type`
VALUES ('1', '网站代理', 'cn.cxnxs.webspider.core.agents.WebsiteAgent', '1', '1', '1', '1', '3', '', '',
        '/static/page/agent/agent_form/website_agent.html',
        '{\n  \"url\": \"https://movie.douban.com/cinema/nowplaying/hangzhou/\",\n  \"method\": \"get\",\n  \"type\": \"html\",\n  \"mode\": \"on_change\",\n  \"uniqueness_look_back\": 1,\n  \"include_sort_info\": true,\n  \"extract\": {\n    \"title\": {\n      \"css\": \"li[@data-category=\'nowplaying\']\",\n      \"value\": \"@data-title\"\n    }\n  },\n  \"headers\": {},\n  \"data\": {},\n  \"disable_ssl_verification\": false,\n  \"events_order\": []\n}',
        '{\"title\":\"options\",\"description\":\"网站抓取配置\",\"type\":\"object\",\"properties\":{\"url\":{\"title\":\"请求链接\",\"examples\":[\"www.baidu.com\"],\"type\":\"string\"},\"url_from_event\":{\"type\":\"string\"},\"method\":{\"title\":\"请求方式\",\"enum\":[\"get\",\"post\"],\"type\":\"string\",\"default\":\"get\"},\"type\":{\"title\":\"数据类型\",\"enum\":[\"html\",\"xml\",\"json\",\"text\"],\"type\":\"string\",\"default\":\"html\"},\"include_sort_info\":{\"type\":\"boolean\",\"default\":false},\"disable_ssl_verification\":{\"type\":\"boolean\",\"default\":false},\"uniqueness_look_back\":{\"type\":\"integer\",\"minimum\":1},\"headers\":{\"title\":\"请求头信息\",\"type\":\"object\"},\"extract\":{\"title\":\"数据获取规则配置\",\"type\":\"object\"},\"template\":{\"type\":\"object\"},\"events_order\":{\"type\":\"array\"},\"data\":{\"title\":\"请求数据\",\"type\":\"object\"}},\"required\":[\"url\",\"extract\",\"type\",\"method\"]}',
        '2020-11-19 16:35:13', '2021-01-25 00:47:26');

-- ----------------------------
-- Table structure for delayed_jobs
-- ----------------------------
DROP TABLE IF EXISTS `delayed_jobs`;
CREATE TABLE `delayed_jobs`
(
  `id`         int(11) NOT NULL AUTO_INCREMENT,
  `priority`   int(11) DEFAULT '0' COMMENT '任务权重',
  `attempts`   int(11) DEFAULT '0' COMMENT '失败尝试次数',
  `handler`    mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '处理器',
  `last_error` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '错误信息',
  `run_at`     datetime                             DEFAULT NULL COMMENT '运行时间',
  `thread_id`  int(11) DEFAULT NULL COMMENT '线程id',
  `failed_at`  datetime                             DEFAULT NULL COMMENT '发生错误时间',
  `queue`      varchar(191) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所在队列',
  `created_at` datetime                             DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime                             DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY          `delayed_jobs_priority` (`priority`,`run_at`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of delayed_jobs
-- ----------------------------

-- ----------------------------
-- Table structure for events
-- ----------------------------
DROP TABLE IF EXISTS `events`;
CREATE TABLE `events`
(
  `id`         int(11) NOT NULL AUTO_INCREMENT,
  `user_id`    int(11) DEFAULT NULL COMMENT '所属用户',
  `agent_id`   int(11) DEFAULT NULL COMMENT '所属代理',
  `payload`    mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '内容',
  `locked_by`  varchar(191) DEFAULT NULL COMMENT '锁定的线程号',
  `created_at` datetime     DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `expires_at` datetime     DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`),
  KEY          `index_events_on_user_id_and_created_at` (`user_id`,`created_at`) USING BTREE,
  KEY          `index_events_on_agent_id_and_created_at` (`agent_id`,`created_at`) USING BTREE,
  KEY          `index_events_on_expires_at` (`expires_at`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='代理事件';

-- ----------------------------
-- Records of events
-- ----------------------------

-- ----------------------------
-- Table structure for links
-- ----------------------------
DROP TABLE IF EXISTS `links`;
CREATE TABLE `links`
(
  `id`                   int(11) NOT NULL AUTO_INCREMENT,
  `source_id`            int(11) DEFAULT NULL,
  `receiver_id`          int(11) DEFAULT NULL,
  `created_at`           datetime DEFAULT NULL,
  `updated_at`           datetime DEFAULT NULL,
  `event_id_at_creation` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY                    `index_links_on_source_id_and_receiver_id` (`source_id`,`receiver_id`) USING BTREE,
  KEY                    `index_links_on_receiver_id_and_source_id` (`receiver_id`,`source_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='agent关联';

-- ----------------------------
-- Records of links
-- ----------------------------
INSERT INTO `links`
VALUES ('9', '5', '6', '2024-01-18 22:41:44', null, '0');

-- ----------------------------
-- Table structure for scenarios
-- ----------------------------
DROP TABLE IF EXISTS `scenarios`;
CREATE TABLE `scenarios`
(
  `id`           int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name`         varchar(191) NOT NULL COMMENT '名称',
  `user_id`      int(11) DEFAULT NULL COMMENT '所属用户',
  `description`  text COMMENT '描述说明',
  `is_public`    tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否公开',
  `tag_bg_color` varchar(191) NOT NULL COMMENT '标签背景颜色',
  `tag_fg_color` varchar(191) NOT NULL COMMENT '标签前景颜色',
  `icon`         varchar(191) NOT NULL COMMENT '图标',
  `created_at`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at`   datetime              DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY            `index_scenarios_on_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='任务场景';

-- ----------------------------
-- Records of scenarios
-- ----------------------------
INSERT INTO `scenarios`
VALUES ('1', '测试', '1', '', '0', '#9e1ee2', '#66ffff', 'fa fa-bookmark', '2020-12-11 11:03:46',
        '2020-12-25 00:56:49');
INSERT INTO `scenarios`
VALUES ('2', '测试新建', null, '测试', '0', '#66ffff', '#000000', 'fa fa-adn', '2020-12-26 00:37:34',
        '2020-12-27 22:48:44');
INSERT INTO `scenarios`
VALUES ('4', '测试1228', null, '20201228', '0', '#ffffff', '#000000', 'fa fa-smile-o', '2020-12-28 17:00:26', null);
INSERT INTO `scenarios`
VALUES ('6', '测试22222', null, '啊啊啊啊啊啊', '0', '#66cccc', '#f00994', 'fa fa-cogs', '2020-12-28 22:30:31',
        '2021-01-18 00:17:49');

-- ----------------------------
-- Table structure for scenario_agent_rel
-- ----------------------------
DROP TABLE IF EXISTS `scenario_agent_rel`;
CREATE TABLE `scenario_agent_rel`
(
  `id`          int(11) NOT NULL AUTO_INCREMENT,
  `agent_id`    int(11) NOT NULL COMMENT '代理id',
  `scenario_id` int(11) NOT NULL COMMENT '场景id',
  `created_at`  datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at`  datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY           `index_scenario_agent_rel_on_agent_id` (`agent_id`) USING BTREE,
  KEY           `index_scenario_agent_rel_on_scenario_id` (`scenario_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='场景-代理关系';

-- ----------------------------
-- Records of scenario_agent_rel
-- ----------------------------
INSERT INTO `scenario_agent_rel`
VALUES ('63', '6', '1', '2022-01-10 17:06:49', null);
INSERT INTO `scenario_agent_rel`
VALUES ('65', '5', '2', '2024-01-18 22:41:44', null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
  `id`         int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `p_id`       int(11) DEFAULT '0' COMMENT '父级id',
  `href`       varchar(191) DEFAULT NULL COMMENT '菜单路径',
  `title`      varchar(191) NOT NULL COMMENT '菜单名称',
  `icon`       varchar(191) DEFAULT NULL COMMENT '菜单图标',
  `target`     varchar(191) DEFAULT NULL COMMENT '打开方式:_blank，_self',
  `user_id`    int(11) NOT NULL COMMENT '创建用户',
  `sort`       int(11) DEFAULT '99' COMMENT '排序',
  `state`      int(11) NOT NULL DEFAULT '0' COMMENT '菜单状态,0启用，1停用，2删除',
  `created_at` datetime     DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime     DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT='菜单信息';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu`
VALUES ('1', '0', '', '系统管理', 'fa fa-cog', '_self', '1', '99', '0', null, '2020-11-18 00:38:52');
INSERT INTO `sys_menu`
VALUES ('6', '1', 'static/page/menu/menu.html', '菜单管理', 'fa fa-bars', '_self', '1', '99', '0', null,
        '2020-11-18 00:39:32');
INSERT INTO `sys_menu`
VALUES ('15', '0', '', 'agent管理', 'fa fa-adjust', '_self', '1', '1', '0', '2020-11-18 00:40:20',
        '2021-09-07 19:29:08');
INSERT INTO `sys_menu`
VALUES ('16', '15', 'static/page/agent/agent_type.html', 'agent定义', 'fa fa-dedent', '_self', '1', '1', '0',
        '2020-11-18 00:43:55', null);
INSERT INTO `sys_menu`
VALUES ('20', '0', '', '方案管理', 'fa fa-align-justify', '_self', '1', '99', '0', '2020-12-09 18:24:04',
        '2020-12-27 23:06:22');
INSERT INTO `sys_menu`
VALUES ('21', '20', 'static/page/scenario/scenarios.html', '方案列表', 'fa fa-align-justify', '_self', '1', '99', '0',
        '2020-12-09 18:29:31', '2020-12-27 23:07:16');
INSERT INTO `sys_menu`
VALUES ('22', '0', 'https://www.baidu.com/', '外链', 'fa fa-asterisk', '_self', '1', '99', '0', '2020-12-11 10:40:44',
        null);
INSERT INTO `sys_menu`
VALUES ('25', '15', 'static/page/agent/agents.html', '代理列表', 'fa fa-server', '_self', '1', '99', '0',
        '2021-01-15 01:28:31', null);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
  `id`                       int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber`              varchar(32) COLLATE utf8_unicode_ci  NOT NULL,
  `email`                    varchar(191) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `encrypted_password`       varchar(191) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `reset_password_token`     varchar(191) COLLATE utf8_unicode_ci          DEFAULT NULL,
  `reset_password_sent_time` datetime                                      DEFAULT NULL,
  `login_count`              int(11) DEFAULT '0',
  `current_login_time`       datetime                                      DEFAULT NULL,
  `last_login_time`          datetime                                      DEFAULT NULL,
  `current_login_ip`         varchar(191) COLLATE utf8_unicode_ci          DEFAULT NULL,
  `last_login_ip`            varchar(191) COLLATE utf8_unicode_ci          DEFAULT NULL,
  `admin`                    tinyint(1) NOT NULL DEFAULT '0',
  `failed_attempts`          int(11) DEFAULT '10',
  `unlock_token`             varchar(191) COLLATE utf8_unicode_ci          DEFAULT NULL,
  `locked_time`              datetime                                      DEFAULT NULL,
  `username`                 varchar(191) COLLATE utf8_unicode_ci          DEFAULT NULL,
  `service_count`            int(11) NOT NULL DEFAULT '0',
  `confirmation_token`       varchar(191) COLLATE utf8_unicode_ci          DEFAULT NULL,
  `confirmed_time`           datetime                                      DEFAULT NULL,
  `confirmation_sent_time`   datetime                                      DEFAULT NULL,
  `unconfirmed_email`        varchar(191) COLLATE utf8_unicode_ci          DEFAULT NULL,
  `state`                    tinyint(1) DEFAULT NULL,
  `token`                    varchar(191) COLLATE utf8_unicode_ci          DEFAULT NULL,
  `created_at`               datetime                                      DEFAULT NULL,
  `updated_at`               datetime                                      DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_users_on_email` (`email`) USING BTREE,
  UNIQUE KEY `index_users_on_username` (`username`) USING BTREE,
  UNIQUE KEY `index_users_on_reset_password_token` (`reset_password_token`) USING BTREE,
  UNIQUE KEY `index_users_on_unlock_token` (`unlock_token`) USING BTREE,
  UNIQUE KEY `index_users_on_confirmation_token` (`confirmation_token`) USING BTREE,
  KEY                        `index_users_on_state` (`state`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户信息';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users`
VALUES ('1', '15077222983', '782399171@qq.com', '4a5ffb79a7cccab08da14151f70ba52f', '1389969ccbfc2325cd07060f34af8be9',
        null, '6', '2022-03-09 11:46:06', '2020-11-30 00:41:19', '0:0:0:0:0:0:0:1', '0:0:0:0:0:0:0:1', '0', '10',
        '4c34c800d404d032b77c20904b1a6d4c', null, 'mengjinyuan', '0', null, null, null, null, null, null,
        '2020-11-25 16:07:35', null);
