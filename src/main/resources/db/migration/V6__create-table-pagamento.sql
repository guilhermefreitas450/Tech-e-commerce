CREATE TABLE Pagamento (
    id int AUTO_INCREMENT primary key,
    pedido_id int not null,
    forma_pgmt ENUM('CRÉDITO', 'DÉBITO', 'PIX', 'CRIPTO') NOT NULL,
    data_pgmt DATETIME,
    valor DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES Pedido(id)
);