create table convidado (id bigint not null auto_increment, nome varchar(255), quantidade_acompanhantes int, primary key (id));
create table usuario (id_usuario bigint not null auto_increment, nome varchar(255), email varchar(255), dt_nasc date, salario float, primary key (id_usuario));
create table festa (id_festa bigint not null auto_increment, id_usuario bigint not null, nome varchar(255), data date, valor float, primary key(id_festa), foreign key(id_usuario) references usuario(id_usuario));
create table brand (id_brand bigint not null auto_increment, nome varchar(255), ramo_atividade varchar(255), primary key (id_brand));
create table product (id_product bigint not null auto_increment, id_brand bigint not null, nome varchar(255), valor float, primary key(id_product), foreign key(id_brand) references brand(id_brand));

