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
   ID                   numeric(8,0) not null comment 'ҵ��id�ɳ����������������ݿ���ֲ',
   TABLET_ID            numeric(8,0) comment '���ӵ��豸',
   TABLET_NAME          varchar(255) comment '�豸����',
   TABLET_ADDRESS       varchar(255) comment '�����豸��������',
   EVENT_NUMBER         varchar(31) comment '����ҵ�������������',
   BEGIN_TIME           datetime comment '���ӿ�ʼʱ��',
   END_TIME             datetime comment '���ӽ���ʱ��',
   TYPE                 int comment '�¼�����',
   CONTENT              varchar(1000) comment '��������',
   DEAL_USER            varchar(31) comment '������',
   DEAL_USERNAME        varchar(255) comment '����������',
   DEAL_TIME            datetime comment '����ʱ��',
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
   ID                   numeric(8,0) not null comment 'ҵ��id�ɳ����������������ݿ���ֲ',
   DEVICE_NUMBER        varchar(31) comment '�豸���',
   NAME                 varchar(255) comment '�豸����',
   ADDRESS              varchar(255) comment '�豸��װλ�ã����㣩',
   DEVICE_IP            varchar(255) comment '�豸ip������ע���޸�ip��',
   DEVICE_PORT          int comment '�豸�˿�',
   LINK_MAN             varchar(255) comment '�豸����������',
   PHONE                varchar(255) comment '�豸�����˵绰',
   STATUS               numeric(1,0) comment '�豸״̬��0�����ߣ�1�����ߣ�2��ͣ�ã�',
   CREATE_TIME          datetime comment '�豸��������',
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_TABLET_GROUP                                 */
/*==============================================================*/
create table FIN_MBOX_TABLET_GROUP
(
   ID                   numeric(8,0) not null comment 'ҵ��id�ɳ����������������ݿ���ֲ',
   NAME                 varchar(255) comment '������',
   STATUS               int comment '��״̬��0��ͣ�ã�1�����ã�',
   CREATE_TIME          datetime comment '��������',
   USER_ID              varchar(31) comment '������',
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_TABLET_OPT                                   */
/*==============================================================*/
create table FIN_MBOX_TABLET_OPT
(
   ID                   numeric(8,0) not null,
   LINE_STATUS          numeric(1,0) comment '����״̬��0�����ߣ�1�����ߣ�',
   DEAL_STAUTS          numeric(1,0) comment '����״̬��0��������1�����ڽ��ӣ�',
   LOCK_STATUS          numeric(1,0) comment '����״̬��0��������1�������У�',
   LOCK_USER            varchar(31) comment '������',
   CLIENT_MAC           varchar(255) comment '�ͻ��˵�mac��ַ',
   LOCK_TIME            datetime comment '����ʱ��',
   SESSION_ID           varchar(31) comment '�û�sessionId',
   primary key (ID)
);

/*==============================================================*/
/* Table: FIN_MBOX_USER                                         */
/*==============================================================*/
create table FIN_MBOX_USER
(
   ID                   numeric(8,0) not null comment 'ҵ��id�ɳ����������������ݿ���ֲ',
   NAME                 varchar(255) comment 'Ա������',
   USER_NUMBER          varchar(255) comment 'Ա������',
   CODE_TYPE            numeric(1,0) comment '֤�����ͣ�Ĭ�����֤��',
   CODE                 varchar(100) comment '֤������',
   COMPY                varchar(255) comment 'Ա��������˾',
   IMAGE                text comment 'Ա��ͷ���ļ�·����',
   IMAGE_TYPE           varchar(255) comment 'ͷ���ļ�����',
   FINGER               text comment 'Ա��ָ��ͼƬ��·����',
   FINGER2              text comment 'Ա������ָ��ͼƬ��·����',
   FINGER_TYPE          varchar(255) comment 'ָ���ļ�����',
   PHONE                varchar(15) comment 'Ա���绰',
   NOTE                 varchar(1000) comment '��ע',
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

