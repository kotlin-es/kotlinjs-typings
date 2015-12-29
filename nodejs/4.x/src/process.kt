@native val process: Process

@native interface Process : EventEmitter {
	//val stdout: WritableStream
	//val stderr: WritableStream
	//val stdin: ReadableStream
	val argv: Array<String>
	val execPath: String
	fun abort(): Unit
	fun chdir(directory: String): Unit
	fun cwd(): String
	val env: Any
	fun exit(code: Int?): Unit
	fun getgid(): Int
	fun setgid(id: Int): Unit
	fun setgid(id: String): Unit
	fun getuid(): Int
	fun setuid(id: Int): Unit
	fun setuid(id: String): Unit
	val version: String
	fun kill(pid: Int, signal: String): Unit
	fun kill(pid: Int, signal: Int): Unit
	fun kill(pid: Int): Unit
	val pid: Int
	val title: String
	val arch: String
	val platform: String

	fun nextTick(callback: () -> Unit): Unit
	fun umask(mask: Int?): Int
	fun uptime(): Int
	fun hrtime(time: Array<Int>?): Array<Int>

	// Worker
	fun send(message: Any, sendHandle: Any?): Unit

	/*
	val versions:
	{
		http_parser: string
		node: string
		v8: string
		ares: string
		uv: string
		zlib: string
		openssl: string
	}

	val config:
	{
		target_defaults: {
		cflags: any[]
		default_configuration: string
		defines: string[]
		include_dirs: string[]
		libraries: string[]
	}
		val variables: {
		clang: number
		host_arch: string
		node_install_npm: boolean
		node_install_waf: boolean
		node_prefix: string
		node_shared_openssl: boolean
		node_shared_v8: boolean
		node_shared_zlib: boolean
		node_use_dtrace: boolean
		node_use_etw: boolean
		node_use_openssl: boolean
		target_arch: string
		v8_no_strict_aliasing: number
		v8_use_snapshot: boolean
		visibility: string
	}
	}
	fun memoryUsage(): {
		rss: number heapTotal: number heapUsed: number
	}
	*/
}