INSERT INTO `roles` (`id`, `name`) VALUES (1, 'ROLE_ADM'), (2, 'ROLE_PATIENT'), (3, 'ROLE_DOC');

INSERT INTO `health_units` (`id`, `city`, `name`, `neighborhood`, `street`) VALUES 
    ( NULL, 'Brasilia', 'unidade - DF', 'Centro', 'Rua domingos 90'),
    ( NULL, 'Brasilia', 'unidade - DF (s)', 'Zona sul', 'Rua domingos 32'),
    ( NULL, 'Valparaiso', 'unidade - VAL', 'Centro', 'Rua são José 12'),
    ( NULL, 'São Paulo', 'unidade - SP', 'Centro', 'Rua Fernando Lopes 33'),
    ( NULL, 'Goiania', 'unidade - GO', 'centro ', 'Rua Maria  b12');

INSERT INTO `users` (`id`, `username`, `password`, `role_id`, `state`, `date`) VALUES 
    (NULL, 'doc 123', '$2a$10$hk6pn5SlyAdXqRUMr055Jus10JVoeNMMS.7c1b9i7bCzCxTDlUcN6', '3', '1', '2023-09-01'), 
    (NULL, 'doc 312', '$2a$10$hk6pn5SlyAdXqRUMr055Jus10JVoeNMMS.7c1b9i7bCzCxTDlUcN6', '3', '1', '2023-09-08'),
    (NULL, 'doc 456', '$2a$10$hk6pn5SlyAdXqRUMr055Jus10JVoeNMMS.7c1b9i7bCzCxTDlUcN6', '3', '1', '2023-09-01'), 
    (NULL, 'doc 212', '$2a$10$hk6pn5SlyAdXqRUMr055Jus10JVoeNMMS.7c1b9i7bCzCxTDlUcN6', '3', '1', '2023-09-08'),
    (NULL, 'doc 222', '$2a$10$hk6pn5SlyAdXqRUMr055Jus10JVoeNMMS.7c1b9i7bCzCxTDlUcN6', '3', '1', '2023-09-01'), 
    (NULL, 'doc 777', '$2a$10$hk6pn5SlyAdXqRUMr055Jus10JVoeNMMS.7c1b9i7bCzCxTDlUcN6', '3', '1', '2023-09-08');

INSERT INTO `doctors` (`id`, `specialty`, `crm`, `user_id`, `health_unit_id`) VALUES 
    (NULL, 'Dermatologista', 'GO122334', '1', '5'),
    (NULL, 'Dermatologista', 'GO722234', '2', '3'),
    (NULL, 'Dermatologista', 'DF1223124', '3', '1'),
    (NULL, 'Cardiologista', 'DF1223334', '4', '2'),
    (NULL, 'Clínico geral', 'DF122312', '5', '2'), 
    (NULL, 'Clínico geral', 'SP122345', '6', '4');