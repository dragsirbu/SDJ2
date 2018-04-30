java -Djava.security.policy=all.policy Server
pause
java -Djava.rmi.server.codebase=http://ict-engineering.dk/class/
 -Djava.security.policy=all.policy Client localhost
pause