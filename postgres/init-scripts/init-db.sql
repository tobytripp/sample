CREATE ROLE development LOGIN PASSWORD 'development';
CREATE DATABASE development;
GRANT ALL PRIVILEGES ON DATABASE development TO development;

\c development

CREATE TABLE products (
       id   SERIAL,
       name VARCHAR(80)
);

GRANT ALL ON products TO development;
GRANT ALL ON products_id_seq TO development;
