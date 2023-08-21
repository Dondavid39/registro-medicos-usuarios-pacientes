alter table Pacientes add activo tinyint;
update Pacientes set activo = 1;
