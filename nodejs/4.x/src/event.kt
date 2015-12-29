@native interface EventEmitter {
	fun addListener(event: String, listener: () -> Unit): EventEmitter
	fun on(event: String, listener: () -> Unit): EventEmitter
	fun once(event: String, listener: () -> Unit): EventEmitter
	fun removeListener(event: String, listener: () -> Unit): EventEmitter
	fun removeAllListeners(event: String?): EventEmitter
	fun setMaxListeners(n: Int): EventEmitter
	fun getMaxListeners(): Int
	fun listeners(event: String): Array<() -> Unit>
	fun emit(event: String, vararg args: Any?): Boolean
	fun listenerCount(type: String): Int
}
