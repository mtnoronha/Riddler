create table tb_user (
	id bigint primary key auto_increment,
	name varchar(255) not null,
	username varchar(100) unique,
	password varchar(500) not null,
	email varchar(255) unique not null
);

create table tb_role(
	role varchar(255) not null,
	id_user bigint not null references tb_user(id),
	primary key(feature,id_user)
);
