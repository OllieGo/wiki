-- 电子书表
drop table if exists `ebook`;

CREATE TABLE `ebook`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `create_people`   varchar(45)  DEFAULT NULL COMMENT '创建人',
    `create_time`     datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_people`   varchar(45)  DEFAULT NULL COMMENT '修改人',
    `modify_time`     datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `deleted`         int(1) DEFAULT '0' COMMENT '是否删除 0正常 1删除',

    `name`            varchar(45) NOT NULL COMMENT '名称',
    `category_one_id` bigint(20) DEFAULT NULL COMMENT '分类一',
    `category_two_id` bigint(20) DEFAULT NULL COMMENT '分类二',
    `description`     varchar(200) DEFAULT NULL COMMENT '描述',
    `cover`           varchar(200) DEFAULT NULL COMMENT '封面',
    `doc_count`       int(10) DEFAULT '0' COMMENT '文档数',
    `view_count`      int(10) DEFAULT '0' COMMENT '阅读数',
    `vote_count`      int(10) DEFAULT '0' COMMENT '点赞数',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1253550049971695648 DEFAULT CHARSET=utf8mb4 COMMENT='电子书';

INSERT INTO `ebook`(`id`, `create_people`, `create_time`, `modify_people`, `modify_time`, `deleted`, `name`,
                    `category_one_id`, `category_two_id`, `description`, `cover`, `doc_count`, `view_count`,
                    `vote_count`)
VALUES (1, NULL, '2022-02-10 23:06:52', NULL, '2022-02-23 23:09:13', 0, 'SpringBoot入门教程', NULL, NULL, '零基础入门Java开发',
        '/image/cover2.png', 0, 0, 0);
INSERT INTO `ebook`(`id`, `create_people`, `create_time`, `modify_people`, `modify_time`, `deleted`, `name`,
                    `category_one_id`, `category_two_id`, `description`, `cover`, `doc_count`, `view_count`,
                    `vote_count`)
VALUES (2, NULL, '2022-02-10 23:06:52', NULL, '2022-02-23 23:09:18', 0, 'Vue入门教程', NULL, NULL, '零基础入门Vue开发',
        '/image/cover1.png', 0, 0, 0);
INSERT INTO `ebook`(`id`, `create_people`, `create_time`, `modify_people`, `modify_time`, `deleted`, `name`,
                    `category_one_id`, `category_two_id`, `description`, `cover`, `doc_count`, `view_count`,
                    `vote_count`)
VALUES (3, NULL, '2022-02-10 23:06:52', NULL, '2022-02-10 23:06:52', 0, 'Mysql入门教程', NULL, NULL, '零基础入门Mysql开发', NULL,
        0, 0, 0);
INSERT INTO `ebook`(`id`, `create_people`, `create_time`, `modify_people`, `modify_time`, `deleted`, `name`,
                    `category_one_id`, `category_two_id`, `description`, `cover`, `doc_count`, `view_count`,
                    `vote_count`)
VALUES (4, NULL, '2022-02-10 23:06:52', NULL, '2022-02-10 23:06:52', 0, 'Python入门教程', NULL, NULL, '零基础入门Python开发', NULL,
        0, 0, 0);


-- 分类表
drop table if exists `category`;

CREATE TABLE `category`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `create_people` varchar(45) DEFAULT NULL COMMENT '创建人',
    `create_time`   datetime    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_people` varchar(45) DEFAULT NULL COMMENT '修改人',
    `modify_time`   datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `deleted`       int(1) DEFAULT '0' COMMENT '是否删除 0正常 1删除',

    `parent`        bigint(20) NOT NULL DEFAULT '0' COMMENT '父id',
    `name`          varchar(45) NOT NULL COMMENT '名称',
    `sort`          int(10) DEFAULT '0' COMMENT '顺序',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分类表';

INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (100, 000, '前端开发', 100);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (101, 100, 'Vue', 101);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (102, 100, 'HTML & CSS', 102);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (200, 000, 'Java', 200);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (201, 200, '基础应用', 201);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (202, 200, '框架应用', 202);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (300, 000, 'Python', 300);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (301, 300, '基础应用', 301);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (302, 300, '进阶方向应用', 302);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (400, 000, '数据库', 400);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (401, 400, 'MySQL', 401);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (500, 000, '其它', 500);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (501, 500, '服务器', 501);
INSERT INTO `category`(`id`, `parent`, `name`, `sort`)
VALUES (502, 500, '开发工具', 502);
