/**
 * Created by mike on 29/11/15.
 */

package d3

import kotlin.browser.document
import org.w3c.dom.*

@native("d3")
object d3 : Selectable {

}

interface  Selectable {

    @native fun select(selector: String): Selection { noImpl }
    @native fun select(selector: ((Any, Int) -> Any)): Selection { noImpl }
    @native fun selectAll(selector: String): Selection { noImpl }

    @native fun select(selector: Node): Selection { noImpl }
    @native fun selectAll(selector: NodeList): Selection { noImpl }

}

class Selection : Selectable {

    @native open fun attr(name: String): Selection { noImpl }
    @native open fun attr(name: String, value: Any): Selection { noImpl }
    @native open fun attr(name: String, value: ((Any, Int) -> Any)): Selection { noImpl }

    @native open fun classed(name: String): Selection { noImpl }
    @native open fun classed(name: String, value: Any): Selection { noImpl }
    @native open fun classed(name: String, value: ((Any, Int) -> Any)): Selection { noImpl }

    @native open fun style(name: String): Selection { noImpl }
    @native open fun style(name: String, value: Any): Selection { noImpl }
    @native open fun style(name: String, value: ((Any, Int) -> Any)): Selection { noImpl }

    @native open fun property(name: String): Selection { noImpl }
    @native open fun property(name: String, value: Any): Selection { noImpl }
    @native open fun property(name: String, value: ((Any, Int) -> Any)): Selection { noImpl }

    @native open fun text(value: String): Selection { noImpl }
    @native open fun text(value: ((String, Int) -> String)): Selection { noImpl }

    @native open fun html(value: String): Selection { noImpl }
    @native open fun html(value: ((String, Int) -> String)): Selection { noImpl }

    @native fun append(name: String): Selection { noImpl }
    @native fun append(element: ((Any, Int) -> Element)): Selection { noImpl }

    @native fun insert(name: String, before: String?): Selection { noImpl }
    @native fun insert(element: ((Any, Int) -> Element), before: String?): Selection { noImpl }

    @native open fun remove(): Selection { noImpl }

    // Data

    @native open fun data(data: Array<*>): Selection { noImpl }
    @native open fun data(dataFun: (Any, Int) -> Any): Selection { noImpl }

    @native open fun enter(): Selection { noImpl }
    @native open fun exit(): Selection { noImpl }

    @native open fun filter(selector: String): Selection { noImpl }
    @native open fun filter(selector: (Any, Int) -> Boolean): Selection { noImpl }

    @native open fun sort(comparator: (a:Any, b:Any) -> Boolean): Selection { noImpl }
    @native open fun order(): Selection { noImpl }

    // Animation & Interaction

    // Control

    @native open fun empty(): Boolean { noImpl }
    @native open fun node(): Node { noImpl }
    @native open fun size(): Int { noImpl }
    @native open fun selection(): Selection { noImpl }
}