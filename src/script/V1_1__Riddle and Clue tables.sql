create table tb_riddle (
	id bigint primary key auto_increment,
	description text not null,
	answer varchar(255) unique,
	reward integer not null,
	level integer  not null
);
	
create table tb_clue(
	id bigint primary key auto_increment,
	answer varchar(255) not null,
	clue text not null,
	id_riddle bigint not null references tb_riddle(id)
);
