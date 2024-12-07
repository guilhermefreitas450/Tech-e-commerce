ALTER TABLE Pagamento
ADD COLUMN produtos_id INT,
ADD CONSTRAINT fk_produtos
FOREIGN KEY (produtos_id) REFERENCES Produtos(id);