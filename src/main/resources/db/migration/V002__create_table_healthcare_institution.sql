create table healthcare_institution (
	id bigint not null auto_increment,
	bugdet_id bigint not null,
	name varchar(60) not null,
	cnpj varchar(14) not null,
	
	primary key (id)
);
alter table healthcare_institution add constraint fk_healthcare_institution_bugdet
foreign key (bugdet_id) references bugdet (id);
