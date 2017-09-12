create table brand (id_brand bigint not null auto_increment, nome_marca varchar(255), ramo_atividade varchar(255), primary key (id_brand));
create table product (id_product bigint not null auto_increment, id_brand bigint not null, descricao varchar(255), valor float, primary key(id_product), foreign key(id_brand) references brand(id_brand));

