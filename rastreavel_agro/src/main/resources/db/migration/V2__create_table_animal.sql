CREATE TABLE animal (
  id_animal UUID NOT NULL,
   peso DOUBLE PRECISION NOT NULL,
   data_nascimento date NOT NULL,
   percent_prenhez DOUBLE PRECISION NOT NULL,
   desmame date NOT NULL,
   index_natal DOUBLE PRECISION NOT NULL,
   index_mortal DOUBLE PRECISION NOT NULL,
   produtor_id BIGINT,
   CONSTRAINT pk_animal PRIMARY KEY (id_animal)
);

