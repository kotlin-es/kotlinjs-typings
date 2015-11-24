import kotlin.browser.document

/**
 * Created by mike on 24/11/15.
 */

fun main(args: Array<String>) {
    val h1 = document.createElement("h1")
    h1.textContent = "Hello world!"
    document.body!!.appendChild(h1)
    println("Hello, console World!")

    jQuery.get<Array<Person>>("data.json", dataType = "json").then {
        var list = document.createElement("ol")
        document.body!!.appendChild(list)
        it.forEach {
            val li = document.createElement("ol")
            li.textContent = it.name
            list.appendChild(li)
        }
    }
}

data class Person(val name:String)
