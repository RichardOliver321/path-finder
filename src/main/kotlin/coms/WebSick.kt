package coms

import sun.plugin2.message.Message
import javax.websocket.ClientEndpoint
import javax.websocket.Session
import javax.websocket.OnOpen
import javax.websocket.OnError
import java.io.IOException
import javax.websocket.OnClose
import javax.websocket.OnMessage


@ClientEndpoint
class WebSick {

    @OnOpen
    @Throws(IOException::class)
    fun onOpen(session: Session) {
        // Get session and WebSocket connection
    }

    @OnMessage
    @Throws(IOException::class)
    fun onMessage(session: Session, message: Message) {
        // Handle new messages
    }

    @OnClose
    @Throws(IOException::class)
    fun onClose(session: Session) {
        // WebSocket connection closes
    }

    @OnError
    fun onError(session: Session, throwable: Throwable) {
        // Do error handling here
    }
}