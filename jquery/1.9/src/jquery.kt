import promise.Promise

/**
 * Created by mike on 24/11/15.
 */

@native("jQuery")
object jQuery {

    @native open fun get<T>(url: String, data: String? = undefined,
                            success: (() -> Unit)? = undefined,
                            dataType: String? = undefined): Promise<T> { noImpl }
}