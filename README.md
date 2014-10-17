1.run jetty : 
	mvn -Djetty.port=8080 jetty:run
2.debug :
	MAVEN_OPTS = -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=y
