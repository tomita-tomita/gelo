CREATE DATABASE controleEstoque; 

CREATE TABLE `controleEstoque`.`produtos` ( `id` INT NOT NULL AUTO_INCREMENT , `codigo` VARCHAR(15) NOT NULL , `descricao` VARCHAR(100) NOT NULL , `codigo_barras` INT NOT NULL , `precoCompra` FLOAT(10,4) NOT NULL , `precoVenda` FLOAT(10,4) NOT NULL , PRIMARY KEY (`id`), UNIQUE (`codigo_barras`), UNIQUE (`codigo`)) ENGINE = MyISAM; 

CREATE TABLE `controleEstoque`.`estoque` ( `id` INT NOT NULL AUTO_INCREMENT , `id_produto` INT NOT NULL , `quantidade` INT NOT NULL DEFAULT '0' , PRIMARY KEY (`id`)) ENGINE = MyISAM; 
