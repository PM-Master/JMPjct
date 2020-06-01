# build
```
docker build ndac-proxy:latest
```

# run
```
docker run --rm -it --name proxy --network-alias proxy --network ndac-network -p 5050:5050 ndac-proxy:latest --proxyPort=5050 --host=testdb --port=3306
```

**make sure the database is running on the same network if using docker**
**if not using docker change the "host" param to 127.0.0.1 or the IP address of the database**
