create table weixin_user(
id varchar2(36) primary key,
idcode varchar2(36),
age number(8),
address varchar2(36)
);

create table weixin_user(
id varchar2(36) primary key,
userid varchar2(36),
--抽奖剩余次数
lotterynumber number(8)
);