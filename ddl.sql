DROP DATABASE public;

CREATE DATABASE public;

USE public;

-- TABLAS PRINCIPALES --

CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    enabled BOOLEAN,
    username VARCHAR(12),
    password VARCHAR(255)
);

CREATE TABLE category_catalog(
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at DATE,
    updated_at DATE,
    name VARCHAR(255)
);

CREATE TABLE surveys(
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at DATE,
    updated_at DATE,
    description VARCHAR(255),
    name VARCHAR(255)
);

-- TABLAS SECUNDARIAS --

CREATE TABLE user_roles(
    role_id INT, 
    user_id INT,
    PRIMARY KEY (role_id, user_id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE chapter(
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at DATE,
    updated_at DATE,
    chapter_number VARCHAR(50),
    chapter_title VARCHAR(50),
    survey_id INT,
    FOREIGN KEY (survey_id) REFERENCES surveys(id)
);

CREATE TABLE questions(
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at DATE,
    updated_at DATE,
    question_number VARCHAR(10),
    response_type VARCHAR(20),
    comment_question TEXT,
    question_text TEXT,
    chapter_id INT,
    FOREIGN KEY (chapter_id) REFERENCES chapter(id)
);

CREATE TABLE response_options(
    id INT AUTO_INCREMENT PRIMARY KEY,
    option_value INT,
    created_at DATE,
    updated_at DATE,
    comment_response TEXT,
    option_text TEXT,
    categorycatalog_id INT,
    parentresponse_id INT,
    question_id INT,
    FOREIGN KEY (categorycatalog_id) REFERENCES category_catalog(id),
    FOREIGN KEY (parentresponse_id) REFERENCES response_options(id),
    FOREIGN KEY (question_id) REFERENCES questions(id)
);

CREATE TABLE subresponse_options(
    id INT AUTO_INCREMENT PRIMARY KEY,
    subresponse_number INT,
    created_at DATE,
    updated_at DATE,
    subresponse_text VARCHAR(255),
    responseoptions_id INT,
    FOREIGN KEY (responseoptions_id) REFERENCES response_options(id)
);

CREATE TABLE response_question(
    id INT AUTO_INCREMENT PRIMARY KEY,
    response_id INT,
    subresponses_id INT,
    responsetext VARCHAR(80),
    FOREIGN KEY (response_id) REFERENCES response_options(id),
    FOREIGN KEY (subresponses_id) REFERENCES subresponse_options(id)
);

