-- Tabla de Zonas
CREATE TABLE IF NOT EXISTS zones (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

-- Tabla de Cobradores (Entidad simple)
CREATE TABLE IF NOT EXISTS collectors (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    document_number VARCHAR(20) UNIQUE NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE' -- ACTIVE, INACTIVE
);

-- Datos iniciales de prueba
INSERT INTO zones (name, description) VALUES ('Zona Norte', 'Barrios periféricos del norte');
INSERT INTO zones (name, description) VALUES ('Zona Centro', 'Casco histórico y comercial');