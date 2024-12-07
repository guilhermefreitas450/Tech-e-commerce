CREATE TABLE Pedido (
    id int AUTO_INCREMENT primary key,
    usuario_id int not null,
    data_pedido datetime not null default CURRENT_TIMESTAMP,
    andamento ENUM('PAGAMENTO NÃO EFETUADO', 'PEDIDO CANCELADO', 'PAGO') NOT NULL,
    total DECIMAL(10, 2),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);