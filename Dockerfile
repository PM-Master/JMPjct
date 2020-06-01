FROM java:8
WORKDIR /
ADD ./out/artifacts/jmp_jar/jmp.jar jmp.jar
ENTRYPOINT ["java", "-jar", "jmp.jar"]
CMD ["--host=", "--port=", "--proxyHost=", "--proxyPort="]