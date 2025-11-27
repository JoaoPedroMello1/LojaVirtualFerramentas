CREATE DATABASE IF NOT EXISTS loja_ferramentas;
USE loja_ferramentas;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20)
);

CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    estoque INT NOT NULL,
    tipo VARCHAR(30) NOT NULL
);

CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE item_pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
);

INSERT INTO cliente (nome, email, telefone) VALUES
('João da Silva','joao@teste.com','1111-1111'),
('Maria Souza','maria@teste.com','2222-2222');

INSERT INTO produto (nome, preco, estoque, tipo) VALUES
('Martelo', 50.00, 10, 'FISICO'),
('Chave de Fenda', 20.00, 15, 'FISICO'),
('Curso de Ferramentas Online', 200.00, 9999, 'DIGITAL');
