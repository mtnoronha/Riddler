create table tb_riddle_test(
	id bigint primary key auto_increment,
	comment text,
	solved boolean,
	start datetime,
	end datetime,
	id_user bigint references tb_user(id),
	id_riddle bigint references tb_riddle(id)	
);

create table tb_riddle_test_answer(
	id bigint primary key auto_increment,
	answer varchar(255),
	time datetime,
	id_riddle_test bigint references tb_riddle_test(id)
);