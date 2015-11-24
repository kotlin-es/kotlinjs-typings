/**
 * Created by mike on 24/11/15.
 */

package  promise

@native("Promise")
class Promise<T> {

    @native open fun then(callback: (T) -> Any) {}
}