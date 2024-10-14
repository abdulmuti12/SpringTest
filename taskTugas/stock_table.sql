CREATE TABLE stock (
       id SERIAL PRIMARY KEY,
       product_name VARCHAR(255) NOT NULL,
       quantity INT NOT NULL,
       serial_number VARCHAR(100) UNIQUE,
       additional_info JSONB,
       image BYTEA,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       created_by VARCHAR(100),
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_by VARCHAR(100)
);