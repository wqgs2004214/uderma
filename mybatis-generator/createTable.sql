create table weixin_user(
id varchar2(36) primary key,
idcode varchar2(36),
age number(8),
address varchar2(36)
);

create table weixin_user(
id varchar2(36) primary key,
userid varchar2(36),
--用户名
username varchar2(36),
--抽奖剩余次数
lotterynumber number(8)
);

--中奖信息
create table weixin_prize_info(
 --奖品Id
  prizeGoodsId INTEGER,
  --中奖用户
  winnerNickname varchar2(36),
  --奖品状态2领取 1未领取
  prizeGoodsStatus number(8),
  --中奖用户ID
  userid varchar2(36),
  --中奖时间
  winningTime Date
);

--奖品表
create table weixin_goods(
  --奖品Id
  prizeGoodsId INTEGER PRIMARY KEY AUTOINCREMENT,
  --奖品名
  prizeAlias varchar2(36)
);
