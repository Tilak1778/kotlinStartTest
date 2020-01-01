package tluck.raj.kotlinstarttest

public interface Command<out T>{

    fun execute():T
}