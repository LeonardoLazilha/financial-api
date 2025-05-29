CREATE TABLE lancamentos (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    descricao varchar(255) NOT NULL,
    valor DECIMAL(18,2) NOT NULL,
    data DATETIME NOT NULL,
    tipo VARCHAR(50) NOT NULL
)