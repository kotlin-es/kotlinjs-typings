import kotlin.browser.document
import d3.*
/**
 * Created by mike on 24/11/15.
 */

fun main(args: Array<String>) {

    val data = arrayOf(4, 8, 15, 16, 23, 42)

    d3.select("#chart1")
            .selectAll("div")
            .data(data)
            .enter().append("div")
            .style("width") { d, i -> "${10 * d as Int}px" }
            .text { d, i -> d }

    println("DONE!")
}
