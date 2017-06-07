create table Spittle (
  id int(11),
  message varchar(140) not null,
  created_at timestamp not null,
  latitude double,
  longitude double
);

create table Spitter (
  id int(11),
  username varchar(20) unique not null,
  password varchar(20) not null,
  first_name varchar(30) not null,
  last_name varchar(30) not null,
  email varchar(30) not null
);