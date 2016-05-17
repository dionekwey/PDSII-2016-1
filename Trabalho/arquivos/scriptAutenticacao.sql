CREATE DATABASE dbSeguranca;
USE DATABASE dbSeguranca;

INSERT INTO tb_sistema(NM_SISTEMA, DS_URL) 
VALUES('Sistema Pedido','http://localhost:8080/TrabalhoPDS2/'),
	('Seguranca','http://localhost:8080/Seguranca');
       
INSERT INTO tb_usuario(DS_LOGIN, FL_ATIVO, DS_EMAIL,DS_SENHA) 
VALUES 	('dione',1,'dione@hotmail.com','fASDfrNWVl4ouxTlod7bJApawlYfjtMYxUonn7apZl4='),
		('carlos',1,'carlos@iftm.com.br','YLytd8Q8SrmEDYqkS2wY5pLmyOXk9ANRVhxBJ08Rl8g=');

INSERT INTO tb_role(NM_ROLE, CD_SISTEMA) 
VALUES ('PED_admin',1),
	   ('PED_cadastro',1),
('PED_consulta',1),
('SEG_admin',2),
('SEG_cadastro',2),
('SEG_consulta',2);

INSERT INTO tb_usuario_role(CD_ROLE,DS_LOGIN)
VALUES (1,'Dione'),
	   (2,'Cezar'),
       (3,'Carlos'),
       (5,'Eduardo');
       
       
       -- a123 = fASDfrNWVl4ouxTlod7bJApawlYfjtMYxUonn7apZl4=
	-- b123 = YLytd8Q8SrmEDYqkS2wY5pLmyOXk9ANRVhxBJ08Rl8g=