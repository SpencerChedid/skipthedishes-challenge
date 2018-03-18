
insert into tb_cousine (name) values ('Chinese');
insert into tb_cousine (name) values ('Japanese');
insert into tb_cousine (name) values ('Italian');

insert into tb_store (name, cousine_id) values ('Tai Chi', 1);
insert into tb_store (name, cousine_id) values ('Chop Suey', 1);
insert into tb_store (name, cousine_id) values ('Nippon', 2);
insert into tb_store (name, cousine_id) values ('Taiko', 2);
insert into tb_store (name, cousine_id) values ('Bella Pizza', 3);
insert into tb_store (name, cousine_id) values ('Traviatta', 3);

insert into tb_product (name, description, store_id) values ('Chinese food 01', '', 1);
insert into tb_product (name, description, store_id) values ('Chinese food 02', '', 1);
insert into tb_product (name, description, store_id) values ('Japanese food 01' '', 2);
insert into tb_product (name, description, store_id) values ('Japanese food 02' '', 2);
insert into tb_product (name, description, store_id) values ('Italian food 01' '', 3);
insert into tb_product (name, description, store_id) values ('Italian food 02' '', 3);
insert into tb_product (name, description, store_id) values ('shrimp', 'none', 1);
insert into tb_product (name, description, store_id) values ('none', 'shrimp', 1);
insert into tb_product (name, description, store_id) values ('shrimp', 'shrimp', 2);
insert into tb_product (name, description, store_id) values ('', 'cheese', 3);
insert into tb_product (name, description, store_id) values ('tomatoes', '', 3);
