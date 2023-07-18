"crear contenedor para la db"
"docker run -it --name mysql-GoTicket -d -p 3336:3306 -e MYSQL_ROOT_PASSWORD=Jugadornumero-12 --restart unless-stopped --pull always -v $(pwd)/msql:/var/lib/mysql mysql:8"
"crear base de datos"
"docker exec -it mysql-GoTicket bash
 mysql -u root -p
 Jugadornumero-12
 CREATE DATABASE db_GoTicketUM;
 exit"