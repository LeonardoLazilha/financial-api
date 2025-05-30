ALTER TABLE lancamentos ADD user_id BIGINT;

ALTER TABLE lancamentos
ADD CONSTRAINT fk_usuario_lancamento
FOREIGN KEY (user_id)
REFERENCES users(id);