# poc-websockets
WebSockets proof of concept

## Running

### Frontend
```bash
cd web
yarn # Install dependencies
yarn start
```

### Backend

JAVA_HOME must be set to Java 11 installation.

```bash
cd server
mvn spring-boot:run
```

### Testing connection

Firstly, click on "Connect" to establish a connection with the WebSocket server.
After that, click on "Trigger message" to simulate an asynchronous action (a GET request), that in turn sends a message through the WebSocket connection.
