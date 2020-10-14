create table bugdet (
	id bigint not null auto_increment,
	coin decimal(10,2) not null,
	description text not null,

	primary key (id)
);