-- Create table
create table T_FILE_INFO
(
  id         CHAR(32) not null,
  file_name  VARCHAR2(64),
  file_size  NUMBER,
  file_path  VARCHAR2(128),
  file_type  VARCHAR2(32),
  remark     VARCHAR2(128),
  created    DATE,
  updated    DATE,
  file_alias VARCHAR2(64)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table T_FILE_INFO
  is '文件';
-- Add comments to the columns
comment on column T_FILE_INFO.id
  is '主键';
comment on column T_FILE_INFO.file_name
  is '文件名称';
comment on column T_FILE_INFO.file_size
  is '文件大小';
comment on column T_FILE_INFO.file_path
  is '文件存储路径';
comment on column T_FILE_INFO.file_type
  is '文件类型';
comment on column T_FILE_INFO.remark
  is '备注';
comment on column T_FILE_INFO.created
  is '创建时间';
comment on column T_FILE_INFO.updated
  is '更新时间';
comment on column T_FILE_INFO.file_alias
  is '文件别名';
-- Create/Recreate indexes
create index NAMEX on T_FILE_INFO (FILE_NAME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index PATHX on T_FILE_INFO (FILE_PATH)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table T_FILE_INFO
  add constraint IDS primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

-- Create table
create table T_FILE_SHEET
(
  id      CHAR(32) not null,
  value   CHAR(32),
  title   VARCHAR2(64),
  file_id VARCHAR2(32),
  created DATE,
  updated DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table
comment on table T_FILE_SHEET
  is '文件选择的sheet';
-- Add comments to the columns
comment on column T_FILE_SHEET.id
  is '主键';
comment on column T_FILE_SHEET.value
  is 'layui 穿梭框中的value';
comment on column T_FILE_SHEET.title
  is 'layui 穿梭框中的title';
comment on column T_FILE_SHEET.file_id
  is 't_file_info 中的id';
comment on column T_FILE_SHEET.created
  is '创建时间';
comment on column T_FILE_SHEET.updated
  is '更新时间';
-- Create/Recreate indexes
create index FILE_ID on T_FILE_SHEET (FILE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints
alter table T_FILE_SHEET
  add constraint ID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

-- Create table
create table T_ITEM_INFO
(
  id         CHAR(32) not null,
  title      VARCHAR2(256) not null,
  sell_point VARCHAR2(1024),
  price      NUMBER not null,
  num        NUMBER not null,
  barcode    VARCHAR2(32),
  image      VARCHAR2(128),
  cid        CHAR(32),
  cname      VARCHAR2(32),
  status     NUMBER(1),
  created    DATE,
  updated    DATE,
  descs      CLOB,
  import_num NUMBER(3),
  file_id    CHAR(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table T_ITEM_INFO
  is '商品表';
-- Add comments to the columns
comment on column T_ITEM_INFO.id
  is '主键';
comment on column T_ITEM_INFO.title
  is '商品标题';
comment on column T_ITEM_INFO.sell_point
  is '商品卖点';
comment on column T_ITEM_INFO.price
  is '商品价格';
comment on column T_ITEM_INFO.num
  is '库存数量';
comment on column T_ITEM_INFO.barcode
  is '商品条形码';
comment on column T_ITEM_INFO.image
  is '商品图片';
comment on column T_ITEM_INFO.cid
  is '所属类目，叶子类目';
comment on column T_ITEM_INFO.cname
  is '类目名称';
comment on column T_ITEM_INFO.status
  is '商品状态，1-正常，2-下架，3-删除';
comment on column T_ITEM_INFO.created
  is '创建时间';
comment on column T_ITEM_INFO.updated
  is '更新时间';
comment on column T_ITEM_INFO.descs
  is '商品描述';
comment on column T_ITEM_INFO.import_num
  is '导入批次';
comment on column T_ITEM_INFO.file_id
  is '文件id，对应t_file_info表中的主键';
-- Create/Recreate primary, unique and foreign key constraints
alter table T_ITEM_INFO
  add constraint P_ID primary key (ID)
  using index
  tablespace TS_SUOFEIYA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );

-- Create table
create table T_FILE_IMPORT_HISTORY
(
  id              CHAR(32) not null,
  file_name       VARCHAR2(32) not null,
  file_row_num    VARCHAR2(16) not null,
  file_import_num NUMBER(2) not null,
  file_id         CHAR(32) not null,
  catagory        VARCHAR2(64) not null,
  remark          VARCHAR2(64),
  created         DATE,
  updated         DATE
)
tablespace TS_SUOFEIYA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 5M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
-- Add comments to the table
comment on table T_FILE_IMPORT_HISTORY
  is '文件导入历史表';
-- Add comments to the columns
comment on column T_FILE_IMPORT_HISTORY.id
  is '主键';
comment on column T_FILE_IMPORT_HISTORY.file_name
  is '导入文件路径';
comment on column T_FILE_IMPORT_HISTORY.file_row_num
  is '文档记录数';
comment on column T_FILE_IMPORT_HISTORY.file_import_num
  is '导入批次';
comment on column T_FILE_IMPORT_HISTORY.file_id
  is '文件表中文件id';
comment on column T_FILE_IMPORT_HISTORY.catagory
  is '导入的模块名称';
comment on column T_FILE_IMPORT_HISTORY.remark
  is '备注';
comment on column T_FILE_IMPORT_HISTORY.created
  is '创建时间';
comment on column T_FILE_IMPORT_HISTORY.updated
  is '更新时间';
-- Create/Recreate indexes
create index I_CATEGORY on T_FILE_IMPORT_HISTORY (CATAGORY)
  tablespace TS_SUOFEIYA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
create index I_FILEID on T_FILE_IMPORT_HISTORY (FILE_ID)
  tablespace TS_SUOFEIYA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table T_FILE_IMPORT_HISTORY
  add constraint P_IDS primary key (ID)
  using index
  tablespace TS_SUOFEIYA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 5M
    next 5M
    minextents 1
    maxextents unlimited
    pctincrease 0
  );
