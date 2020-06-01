docker run --rm -it --name proxy --network-alias proxy --network ndac-network -p 5050:5050 ndac-proxy:0.1 --proxyPort=5050 --host=testdb --port=3306
