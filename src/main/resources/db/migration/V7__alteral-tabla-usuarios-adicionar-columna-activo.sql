alter table Usuarios add activo tinyint;
update Usuarios set activo = 1;
