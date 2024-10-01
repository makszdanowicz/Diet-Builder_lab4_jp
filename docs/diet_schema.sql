-- Tworzenie tabeli products
CREATE TABLE products (
    name VARCHAR(60) PRIMARY KEY,
    mass DOUBLE NOT NULL,
    carbohydrates DOUBLE NOT NULL,
    fats DOUBLE NOT NULL,
    protein DOUBLE NOT NULL,
    category VARCHAR(100) NOT NULL
);

-- Tworzenie tabeli breakfast
CREATE TABLE breakfast (
    name VARCHAR(60) PRIMARY KEY,
    mass DOUBLE NOT NULL,
    carbohydrates DOUBLE NOT NULL,
    fats DOUBLE NOT NULL,
    protein DOUBLE NOT NULL,
    category VARCHAR(100) NOT NULL,
    amount DOUBLE NOT NULL
);

-- Tworzenie tabeli lunch
CREATE TABLE lunch (
    name VARCHAR(60) PRIMARY KEY,
    mass DOUBLE NOT NULL,
    carbohydrates DOUBLE NOT NULL,
    fats DOUBLE NOT NULL,
    protein DOUBLE NOT NULL,
    category VARCHAR(100) NOT NULL,
    amount DOUBLE NOT NULL
);

-- Tworzenie tabeli dinner
CREATE TABLE dinner (
    name VARCHAR(60) PRIMARY KEY,
    mass DOUBLE NOT NULL,
    carbohydrates DOUBLE NOT NULL,
    fats DOUBLE NOT NULL,
    protein DOUBLE NOT NULL,
    category VARCHAR(100) NOT NULL,
    amount DOUBLE NOT NULL
);
