# Je zapotřebí mít nainstalované:

- Docker
- Maven

# Spuštění:

Pozor! Nejprve se smáznou a pak se vytvoří kontejnery s názvy: app, prometheus, grafana!
Pokud aktuálně máte Docker container s nějakým z těchto názvů, pak bude smazán!!!

	build.cmd

# Rebuild aplikace (při změně konfigurace / kódu):

	rebuild-app.cmd

# Aplikace:

url: http://localhost:8080
username / password: user / letmein

# Prometheus:

url: http://localhost:9090

# Grafana:

url: http://localhost:3000
username / password: admin / password
Poznámka: V souboru docker-compose-servers.yml je definováno toto uživ. jméno a heslo.

V souboru volumes/datasource.yml je konfigurace Prometheus DataSource, 
díky čemuž není nutné provádět tuto konfiguraci ručně v Grafaně.

# Vypnutí:

	docker rm -v -f app prometheus grafana
	docker network rm app_net
