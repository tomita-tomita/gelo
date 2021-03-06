CREATE DATABASE controleEstoque; 

CREATE TABLE `controleEstoque`.`produtos` ( `id` INT NOT NULL AUTO_INCREMENT , `descricao` VARCHAR(100) NOT NULL , `codigo_barras` INT NOT NULL, `precoCompra` FLOAT(10,4) NOT NULL , `precoVenda` FLOAT(10,4) NOT NULL , PRIMARY KEY (`id`), UNIQUE (`codigo_barras`), UNIQUE (`codigo`)) ENGINE = MyISAM; 

CREATE TABLE `controleEstoque`.`estoque` ( `id` INT NOT NULL AUTO_INCREMENT , `id_produto` INT NOT NULL , `quantidade` INT NOT NULL DEFAULT '0' , PRIMARY KEY (`id`)) ENGINE = MyISAM; 


CREATE TABLE `controleestoque`.`caixa` ( `id` INT NOT NULL AUTO_INCREMENT , `descricao` TEXT NULL , `valor` DECIMAL(10,2) NOT NULL , `data` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP , `tipo_movimentacao` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

CREATE TABLE `recibos` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `cliente` VARCHAR(100) COLLATE latin1_swedish_ci NOT NULL,
  `endereco` VARCHAR(100) COLLATE latin1_swedish_ci DEFAULT NULL,
  `telefone` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  `valorTotal` FLOAT NOT NULL,
  `taxaEntrega` FLOAT DEFAULT NULL,
  `dataEmissao` DATE NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM
AUTO_INCREMENT=2 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci';

CREATE TABLE `itens_recibo` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `id_recibo` INTEGER(11) NOT NULL,
  `id_produto` INTEGER(11) NOT NULL,
  `descricao` VARCHAR(100) COLLATE latin1_swedish_ci NOT NULL,
  `quantidade` FLOAT NOT NULL,
  `precoUnitario` FLOAT NOT NULL,
  `precoTotal` FLOAT NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM
AUTO_INCREMENT=17 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci';