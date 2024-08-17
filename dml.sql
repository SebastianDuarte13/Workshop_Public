INSERT INTO roles (name) VALUES ('Administrador');
INSERT INTO roles (name) VALUES ('Usuario');

INSERT INTO users (enabled, username, password) VALUES (TRUE, 'juan_perez', 'contraseña123');
INSERT INTO users (enabled, username, password) VALUES (FALSE, 'ana_lopez', 'clave_segura');

INSERT INTO category_catalog (created_at, updated_at, name) VALUES ('2024-08-16', '2024-08-16', 'Electrónica');
INSERT INTO category_catalog (created_at, updated_at, name) VALUES ('2024-08-16', '2024-08-16', 'Libros');

INSERT INTO surveys (created_at, updated_at, description, name) VALUES ('2024-08-16', '2024-08-16', 'Encuesta de Satisfacción del Cliente', 'Opinión del Cliente');
INSERT INTO surveys (created_at, updated_at, description, name) VALUES ('2024-08-16', '2024-08-16', 'Encuesta de Compromiso del Empleado', 'Opinión del Empleado');

INSERT INTO user_roles (role_id, user_id) VALUES (1, 1);
INSERT INTO user_roles (role_id, user_id) VALUES (2, 2);

INSERT INTO chapter (created_at, updated_at, chapter_number, chapter_title, survey_id) VALUES ('2024-08-16', '2024-08-16', '1', 'Introducción', 1);
INSERT INTO chapter (created_at, updated_at, chapter_number, chapter_title, survey_id) VALUES ('2024-08-16', '2024-08-16', '2', 'Conclusión', 1);

INSERT INTO questions (created_at, updated_at, question_number, response_type, comment_question, question_text, chapter_id) VALUES ('2024-08-16', '2024-08-16', 'P1', 'Opción Múltiple', 'Opcional', '¿Qué tan satisfecho está?', 1);
INSERT INTO questions (created_at, updated_at, question_number, response_type, comment_question, question_text, chapter_id) VALUES ('2024-08-16', '2024-08-16', 'P2', 'Texto', 'Opcional', 'Por favor, proporcione comentarios:', 1);

INSERT INTO response_options (option_value, created_at, updated_at, comment_response, option_text, categorycatalog_id, parentresponse_id, question_id) VALUES (1, '2024-08-16', '2024-08-16', 'Ninguno', 'Muy Satisfecho', 1, NULL, 1);
INSERT INTO response_options (option_value, created_at, updated_at, comment_response, option_text, categorycatalog_id, parentresponse_id, question_id) VALUES (2, '2024-08-16', '2024-08-16', 'Ninguno', 'Satisfecho', 1, NULL, 1);

INSERT INTO subresponse_options (subresponse_number, created_at, updated_at, subresponse_text, responseoptions_id) VALUES (1, '2024-08-16', '2024-08-16', 'Totalmente de Acuerdo', 1);
INSERT INTO subresponse_options (subresponse_number, created_at, updated_at, subresponse_text, responseoptions_id) VALUES (2, '2024-08-16', '2024-08-16', 'De Acuerdo', 1);

INSERT INTO response_question (response_id, subresponses_id, responsetext) VALUES (1, 1, 'Muy positivo');
INSERT INTO response_question (response_id, subresponses_id, responsetext) VALUES (2, 2, 'Positivo');
