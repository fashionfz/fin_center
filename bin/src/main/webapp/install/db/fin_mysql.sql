/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/2/26 11:16:02                           */
/*==============================================================*/


drop table if exists FIN_MBOX_EVENT;

drop table if exists FIN_MBOX_R_EVENT_MBOXUSER;

drop table if exists FIN_MBOX_R_EVENT_USER;

drop table if exists FIN_MBOX_R_EVENT_VIC;

drop table if exists FIN_MBOX_R_GROUP_TABLET;

drop table if exists FIN_MBOX_R_GROUP_USER;

drop table if exists FIN_MBOX_R_TABLET_VIC;

drop table if exists FIN_MBOX_TABLET;

drop table if exists FIN_MBOX_TABLET_GROUP;

drop table if exists FIN_MBOX_TABLET_OPT;

drop table if exists FIN_MBOX_USER;

drop table if exists T_DEVICE;

drop table if exists T_USER;

/*==============================================================*/
/* Table: FIN_MBOX_EVENT                                        */
/*==============================================================*/
create table FIN_MBOX_EVENT
(
   ID                   numeric(8,0) not null comment '业务id由程序生产，方便数据库移植',
   TABLET_ID            numeric(8,0) comment '交接的设备',
   TABLET_NAME          varchar(255) comment '设备名称',
   TABLET_ADDRESS       varchar(255) comment '交接设备所在网点',
   EVENT_NUMBER         varchar(31) comment '根据业务需求程序生成',
   BEGIN_TIME           datetime comment '交接开始时间',
   END_TIME             datetime comment '交接结束时间',
   TYPE                 int comment '事件类型',
   CONTENT              varchar(1000) comment '处置内容',
   DEAL_USER            varchar(31) comment '处置人',
   DEAL_USERNAME        varchar(255) comment '处理人名称',
   DEAL_TIME            datetime comment '处置时间',
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_R_EVENT_MBOXUSER                             */
/*==============================================================*/
create table FIN_MBOX_R_EVENT_MBOXUSER
(
   ID                   numeric(8,0) not null,
   EVENT_ID             varchar(31),
   MBOX_USER_ID         numeric(8,0),
   T_TIME               datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_R_EVENT_USER                                 */
/*==============================================================*/
create table FIN_MBOX_R_EVENT_USER
(
   ID                   numeric(8,0) not null,
   USER_ID              varchar(31),
   EVENT_ID             varchar(31),
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_R_EVENT_VIC                                  */
/*==============================================================*/
create table FIN_MBOX_R_EVENT_VIC
(
   ID                   numeric(8,0) not null,
   EVENT_ID             varchar(31),
   VIC_ID               varchar(31),
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_R_GROUP_TABLET                               */
/*==============================================================*/
create table FIN_MBOX_R_GROUP_TABLET
(
   ID                   numeric(8,0) not null,
   TABLET_ID            numeric(8,0),
   GROUP_ID             numeric(8,0),
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_R_GROUP_USER                                 */
/*==============================================================*/
create table FIN_MBOX_R_GROUP_USER
(
   ID                   numeric(8,0) not null,
   GROUP_ID             numeric(8,0),
   USER_ID              varchar(31),
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_R_TABLET_VIC                                 */
/*==============================================================*/
create table FIN_MBOX_R_TABLET_VIC
(
   ID                   varchar(31) not null,
   TABLET_ID            varchar(31),
   VIC_ID               varchar(31),
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_TABLET                                       */
/*==============================================================*/
create table FIN_MBOX_TABLET
(
   ID                   numeric(8,0) not null comment '业务id由程序生产，方便数据库移植',
   DEVICE_NUMBER        varchar(31) comment '设备编号',
   NAME                 varchar(255) comment '设备名称',
   ADDRESS              varchar(255) comment '设备安装位置（网点）',
   DEVICE_IP            varchar(255) comment '设备ip（从新注册修改ip）',
   DEVICE_PORT          int comment '设备端口',
   LINK_MAN             varchar(255) comment '设备负责人名称',
   PHONE                varchar(255) comment '设备负责人电话',
   STATUS               numeric(1,0) comment '设备状态（0：离线，1：在线，2：停用）',
   CREATE_TIME          datetime comment '设备创建日期',
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_TABLET_GROUP                                 */
/*==============================================================*/
create table FIN_MBOX_TABLET_GROUP
(
   ID                   numeric(8,0) not null comment '业务id由程序生产，方便数据库移植',
   NAME                 varchar(255) comment '组名称',
   STATUS               int comment '组状态（0：停用，1：启用）',
   CREATE_TIME          datetime comment '创建日期',
   USER_ID              varchar(31) comment '创建人',
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_TABLET_OPT                                   */
/*==============================================================*/
create table FIN_MBOX_TABLET_OPT
(
   ID                   numeric(8,0) not null,
   LINE_STATUS          numeric(1,0) comment '交接状态（0：在线，1：离线）',
   DEAL_STAUTS          numeric(1,0) comment '交接状态（0：正常，1：正在交接）',
   LOCK_STATUS          numeric(1,0) comment '锁定状态（0：正常，1：锁定中）',
   LOCK_USER            varchar(31) comment '锁定人',
   CLIENT_MAC           varchar(255) comment '客户端的mac地址',
   LOCK_TIME            datetime comment '锁定时间',
   SESSION_ID           varchar(31) comment '用户sessionId',
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_USER                                         */
/*==============================================================*/
create table FIN_MBOX_USER
(
   ID                   numeric(8,0) not null comment '业务id由程序生产，方便数据库移植',
   NAME                 varchar(255) comment '员工姓名',
   USER_NUMBER          varchar(255) comment '员工工号',
   CODE_TYPE            numeric(1,0) comment '证件类型（默认身份证）',
   CODE                 varchar(100) comment '证件号码',
   COMPY                varchar(255) comment '员工所属公司',
   IMAGE                text comment '员工头像（文件路径）',
   IMAGE_TYPE           varchar(255) comment '头像文件类型',
   FINGER               text comment '员工指纹图片（路径）',
   FINGER2              text comment '员工备用指纹图片（路径）',
   FINGER_TYPE          varchar(255) comment '指纹文件类型',
   PHONE                varchar(15) comment '员工电话',
   NOTE                 varchar(1000) comment '备注',
   STATUS               numeric(1,0),
   CREATE_TIME          datetime,
   MODIFY_TIME          datetime,
   primary key (ID)
);

/*==============================================================*/
/* Table: T_DEVICE                                              */
/*==============================================================*/
create table T_DEVICE
(
   ID                   varchar(31) not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER
(
   ID                   varchar(31) not null,
   primary key (ID)
);

