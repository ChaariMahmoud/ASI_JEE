-- Create database
CREATE DATABASE IF NOT EXISTS mydatabase;

-- Use the database
USE mydatabase;

-- Create table
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL
);
