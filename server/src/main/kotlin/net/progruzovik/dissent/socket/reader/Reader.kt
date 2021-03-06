package net.progruzovik.dissent.socket.reader

import net.progruzovik.dissent.captain.Player
import net.progruzovik.dissent.model.socket.ClientSubject

interface Reader {

    val subject: ClientSubject

    fun read(player: Player, data: Map<String, Int>)
}
