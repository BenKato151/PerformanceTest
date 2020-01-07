import java.security.MessageDigest
import kotlin.system.measureNanoTime

fun hash(obj: String): String {
    val bytes = obj.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}
fun main() {
    var duration = measureNanoTime {
        for (i in 0..1000000) {
            hash("aaaaaaaaaa")
        }
    }
    println("Duration: " + duration/1000)
}