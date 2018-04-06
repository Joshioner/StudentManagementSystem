create table admin(
  aid int PRIMARY key ,
  aname varchar(20),
  apwd varchar(20)
)

create table user(
  uid int PRIMARY key auto_increment,
  uname varchar(20),
  ugender varchar(2),
  uage int,
  usalary double
)