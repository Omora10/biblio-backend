INSERT INTO libros (titulo, autor, isbn, imagen_url, prestado) VALUES
                                                                   ('Cien años de soledad', 'Gabriel Garcia Marquez', '978-9584236821', 'https://images-na.ssl-images-amazon.com/images/P/0307474720.01.L.jpg', false),
                                                                   ('Don Quijote de la Mancha', 'Miguel de Cervantes', '978-8491050277', 'https://m.media-amazon.com/images/I/91zbi9M+mKL.jpg', false),
                                                                   ('La casa de los espiritus', 'Isabel Allende', '978-8401352898', 'https://m.media-amazon.com/images/I/81s4M7h4H9L.jpg', false),
                                                                   ('Ficciones', 'Jorge Luis Borges', '978-8420633318', 'https://m.media-amazon.com/images/I/71z7kRkP5RL.jpg', false),
                                                                   ('El amor en los tiempos del colera', 'Gabriel Garcia Marquez', '978-0307389732', 'https://m.media-amazon.com/images/I/81K8mJGIw-L.jpg', false),
                                                                   ('Rayuela', 'Julio Cortazar', '978-8437604572', 'https://m.media-amazon.com/images/I/81Y5x6KJ5PL.jpg', false),
                                                                   ('Pedro Paramo', 'Juan Rulfo', '978-8437604183', 'https://m.media-amazon.com/images/I/71dT4w5n3TL.jpg', false),
                                                                   ('La ciudad y los perros', 'Mario Vargas Llosa', '978-8466333753', 'https://m.media-amazon.com/images/I/71nM7G5z6HL.jpg', false),
                                                                   ('El tunel', 'Ernesto Sabato', '978-8432216428', 'https://m.media-amazon.com/images/I/71d7F8hW7EL.jpg', false),
                                                                   ('Maria', 'Jorge Isaacs', '978-9583000454', 'https://m.media-amazon.com/images/I/61j3g5mXj-L.jpg', false);

INSERT INTO usuarios
(nombre, email, password, telefono, avatar_url, activo, fecha_registro)
VALUES
    ('Administrador', 'admin@biblio.com', '123456', '3101234567', 'https://i.pravatar.cc/300?img=1', true, DATE '2026-06-20'),
    ('Ana Perez', 'ana@biblio.com', '123456', '3102345678', 'https://i.pravatar.cc/300?img=2', true, DATE '2026-06-21'),
    ('Carlos Ruiz', 'carlos@biblio.com', '123456', '3103456789', 'https://i.pravatar.cc/300?img=3', true, DATE '2026-06-22'),
    ('Elena Martinez', 'elena@biblio.com', '123456', '3104567890', 'https://i.pravatar.cc/300?img=4', true, DATE '2026-06-23'),
    ('Juan Garcia', 'juan@biblio.com', '123456', '3105678901', 'https://i.pravatar.cc/300?img=5', true, DATE '2026-06-24');

INSERT INTO prestamos
(usuario_id, libro_id, fecha_prestamo, fecha_devolucion, devuelto)
VALUES
    (2, 1, DATE '2026-06-10', NULL, false),
    (3, 2, DATE '2026-06-11', NULL, false),
    (4, 3, DATE '2026-06-01', DATE '2026-06-12', true);

UPDATE libros
SET prestado = true
WHERE id IN (1, 2);