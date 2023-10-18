CREATE TABLE IF NOT EXISTS transaction(
    id SERIAL primary key,
    type int,
    data date,
    valor decimal,
    cpf bigint,
    card varchar(255),
    store_owner varchar(255),
    store_name varchar(255)
);