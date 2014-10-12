--openid, lotterynumber, nickname, sex, city,country, province
create table weixin_user(
openid varchar2(36) primary key,
lotterynumber number(8),
nickname varchar2(36),
sex number(8),
city varchar2(36),
country varchar2(36),
province varchar2(36),
createDate Date
);

--中奖信息
create table weixin_prize_info(
 --奖品Id
  id varchar2(36) primary key,
  --中奖用户
  winnerNickname varchar2(36),
  --奖品状态2领取 1未领取
  prizeGoodsStatus number(8),
  --奖品名称
  prizeGoodsName varchar2(36),
  --中奖用户ID
  openid varchar2(36),
  --中奖时间
  winningTime Date
);

--奖品表
create table weixin_goods(
  --奖品Id
  prizeGoodsId INTEGER PRIMARY KEY,
  --奖品名
  prizeAlias varchar2(36),
  --奖品数量
  prizeGoodsNumber number(8)
);
