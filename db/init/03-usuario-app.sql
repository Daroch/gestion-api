CREATE USER IF NOT EXISTS 'gestion_app'@'%' IDENTIFIED BY 'dev-gestion-2026';
GRANT SELECT, INSERT, UPDATE, DELETE ON gestion.* TO 'gestion_app'@'%';
CREATE USER IF NOT EXISTS 'gestion_app2'@'%' IDENTIFIED BY 'secreto2';
GRANT SELECT, INSERT, UPDATE, DELETE ON gestion.* TO 'gestion_app2'@'%';
FLUSH PRIVILEGES;
