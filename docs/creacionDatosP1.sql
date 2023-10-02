INSERT INTO Hoteles(nombreHotel, cant_habitaciones) VALUES ('Tequendama', 600);
INSERT INTO Hoteles(nombreHotel, cant_habitaciones) VALUES ('Hilton', 800);

INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1223, 'jose', 'jose@gmail.com', 'administrador', 'Tequendama', 'cc');
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1221, 'juan', 'juan@gmail.com', 'gerente', 'Hilton', 'cc');

INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1222, 'luis', 'luis@gmail.com', 'recepcionista', 'Tequendama', 'cc');
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1224, 'maria', 'maria@gmail.com', 'recepcionista', 'Hilton', 'cc');
    
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1225, 'laura', 'laura@gmail.com', 'empleado', 'Hilton', 'cc');   
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1226, 'sofia', 'sofia@gmail.com', 'empleado', 'Tequendama', 'cc'); 
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1227, 'camila', 'camila@gmail.com', 'empleado', 'Hilton', 'cc'); 
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1228, 'sara', 'sara@gmail.com', 'empleado', 'Tequendama', 'cc'); 
    
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1229, 'david', 'david@gmail.com', 'cliente', 'Tequendama', 'cc'); 
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1230, 'francisco', 'francisco@gmail.com', 'cliente', 'Hilton', 'cc'); 
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1231, 'santiago', 'santiago@gmail.com', 'cliente', 'Tequendama', 'cc'); 
INSERT INTO Usuarios(idUsuario, nombreUsuario, email, rol, Hoteles_nombreHotel, tipoId) 
    VALUES (1232, 'luisa', 'luisa@gmail.com', 'cliente', 'Hilton', 'cc'); 
    
INSERT INTO tipoHabi(tipo, capacidad) VALUES ('Doble', 4);
INSERT INTO tipoHabi(tipo, capacidad) VALUES ('Suite', 2);
INSERT INTO tipoHabi(tipo, capacidad) VALUES ('Suite_presidencial', 6);
    
INSERT INTO Servicios(idServicio, tipo, servicios_type) VALUES (1, 'piscina', 'Piscinas');
INSERT INTO Servicios(idServicio, tipo, servicios_type) VALUES (2, 'gimnasio', 'Gimnasios');
INSERT INTO piscinas(idServicio, capacidad, profundidad, costo) VALUES (1, 20, 1.6, 0);
INSERT INTO gimnasios(idServicio, capacidad,costo) VALUES (2, 20, 0);

