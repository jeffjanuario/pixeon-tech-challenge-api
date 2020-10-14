create table exam (
	id bigint not null auto_increment,
	access_first tinyint(1) not null,
	healthcare_id bigint not null,
	patient_name text not null,
	patient_age text not null,
	patient_gender text not null,
	physician_name text not null,
	physician_crm text not null,
	producere_name text not null,

	primary key (id)
);

alter table exam add constraint fk_exam_healthcare_institution
foreign key (healthcare_id) references healthcare_institution (id);