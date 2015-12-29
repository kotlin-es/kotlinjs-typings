// @TODO: check this!
@native("require('fs')") object fs {
	@native interface Stats {
		fun isFile(): Boolean
		fun isDirectory(): Boolean
		fun isBlockDevice(): Boolean
		fun isCharacterDevice(): Boolean
		fun isSymbolicLink(): Boolean
		fun isFIFO(): Boolean
		fun isSocket(): Boolean
		val dev: Int
		val ino: Int
		val mode: Int
		val nlink: Int
		val uid: Int
		val gid: Int
		val rdev: Int
		val size: Int
		val blksize: Int
		val blocks: Int
		val atime: Date
		val mtime: Date
		val ctime: Date
		val birthtime: Date
	}

	@native interface FSWatcher : EventEmitter {
		fun close(): Unit
	}

	@native interface ReadStream { //: Readable {
		fun close(): Unit
	}
	@native interface WriteStream { //: Writable {
		fun close(): Unit
		val bytesWritten: Int
	}

	fun rename(oldPath: String, newPath: String, callback: ((err: ErrnoException) -> Unit)?): Unit
	fun renameSync(oldPath: String, newPath: String): Unit
	fun truncate(path: String, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun truncate(path: String, len: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun truncateSync(path: String, len: Int?): Unit
	fun ftruncate(fd: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun ftruncate(fd: Int, len: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun ftruncateSync(fd: Int, len: Int?): Unit
	fun chown(path: String, uid: Int, gid: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun chownSync(path: String, uid: Int, gid: Int): Unit
	fun fchown(fd: Int, uid: Int, gid: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun fchownSync(fd: Int, uid: Int, gid: Int): Unit
	fun lchown(path: String, uid: Int, gid: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun lchownSync(path: String, uid: Int, gid: Int): Unit
	fun chmod(path: String, mode: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun chmod(path: String, mode: String, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun chmodSync(path: String, mode: Int): Unit
	fun chmodSync(path: String, mode: String): Unit
	fun fchmod(fd: Int, mode: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun fchmod(fd: Int, mode: String, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun fchmodSync(fd: Int, mode: Int): Unit
	fun fchmodSync(fd: Int, mode: String): Unit
	fun lchmod(path: String, mode: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun lchmod(path: String, mode: String, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun lchmodSync(path: String, mode: Int): Unit
	fun lchmodSync(path: String, mode: String): Unit
	fun stat(path: String, callback: ((err: ErrnoException, stats: Stats) -> Any)?): Unit
	fun lstat(path: String, callback: ((err: ErrnoException, stats: Stats) -> Any)?): Unit
	fun fstat(fd: Int, callback: ((err: ErrnoException, stats: Stats) -> Any)?): Unit
	fun statSync(path: String): Stats
	fun lstatSync(path: String): Stats
	fun fstatSync(fd: Int): Stats
	fun link(srcpath: String, dstpath: String, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun linkSync(srcpath: String, dstpath: String): Unit
	fun symlink(srcpath: String, dstpath: String, type: String?, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun symlinkSync(srcpath: String, dstpath: String, type: String?): Unit
	fun readlink(path: String, callback: ((err: ErrnoException, linkString: String) -> Any)?): Unit
	fun readlinkSync(path: String): String
	fun realpath(path: String, callback: ((err: ErrnoException, resolvedPath: String) -> Any)?): Unit
	//fun realpath(path: String, cache: {[path: String]: String}, callback: (err: ErrnoException, resolvedPath: String) ->any): Unit
	//fun realpathSync(path: String, cache?: { [path: String]: String }): String
	fun unlink(path: String, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun unlinkSync(path: String): Unit
	fun rmdir(path: String, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun rmdirSync(path: String): Unit
	fun mkdir(path: String, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun mkdir(path: String, mode: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun mkdir(path: String, mode: String, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun mkdirSync(path: String, mode: Int?): Unit
	fun mkdirSync(path: String, mode: String?): Unit
	fun readdir(path: String, callback: ((err: ErrnoException, files: Array<String>) -> Unit)?): Unit
	fun readdirSync(path: String): Array<String>
	fun close(fd: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun closeSync(fd: Int): Unit
	fun open(path: String, flags: String, callback: ((err: ErrnoException, fd: Int) -> Any)?): Unit
	fun open(path: String, flags: String, mode: Int, callback: ((err: ErrnoException, fd: Int) -> Any)?): Unit
	fun open(path: String, flags: String, mode: String, callback: ((err: ErrnoException, fd: Int) -> Any)?): Unit
	fun openSync(path: String, flags: String, mode: Int?): Int
	fun openSync(path: String, flags: String, mode: String?): Int
	fun utimes(path: String, atime: Int, mtime: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun utimes(path: String, atime: Date, mtime: Date, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun utimesSync(path: String, atime: Int, mtime: Int): Unit
	fun utimesSync(path: String, atime: Date, mtime: Date): Unit
	fun futimes(fd: Int, atime: Int, mtime: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun futimes(fd: Int, atime: Date, mtime: Date, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun futimesSync(fd: Int, atime: Int, mtime: Int): Unit
	fun futimesSync(fd: Int, atime: Date, mtime: Date): Unit
	fun fsync(fd: Int, callback: ((err: ErrnoException?) -> Unit)?): Unit
	fun fsyncSync(fd: Int): Unit
	fun write(fd: Int, buffer: Buffer, offset: Int, length: Int, position: Int, callback: ((err: ErrnoException, written: Int, buffer: Buffer) -> Unit)?): Unit
	fun write(fd: Int, buffer: Buffer, offset: Int, length: Int, callback: ((err: ErrnoException, written: Int, buffer: Buffer) -> Unit)?): Unit
	fun write(fd: Int, data: Any, callback: ((err: ErrnoException, written: Int, str: String) -> Unit)?): Unit
	fun write(fd: Int, data: Any, offset: Int, callback: ((err: ErrnoException, written: Int, str: String) -> Unit)?): Unit
	fun write(fd: Int, data: Any, offset: Int, encoding: String, callback: ((err: ErrnoException, written: Int, str: String) -> Unit)?): Unit
	fun writeSync(fd: Int, buffer: Buffer, offset: Int, length: Int, position: Int): Int
	fun read(fd: Int, buffer: Buffer, offset: Int, length: Int, position: Int, callback: ((err: ErrnoException, bytesRead: Int, buffer: Buffer) -> Unit)?): Unit
	fun readSync(fd: Int, buffer: Buffer, offset: Int, length: Int, position: Int): Int
	fun readFile(filename: String, encoding: String, callback: (err: ErrnoException, data: String) -> Unit): Unit
	//fun readFile(filename: String, options: { encoding: String flag: String? }, callback: (err: ErrnoException, data: String) -> Unit): Unit
	//fun readFile(filename: String, options: { flag: String? }, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit
	fun readFile(filename: String, callback: (err: ErrnoException, data: Buffer) -> Unit): Unit
	fun readFileSync(filename: String, encoding: String): String
	//fun readFileSync(filename: String, options: { encoding: String flag: String? }): String
	//fun readFileSync(filename: String, options?: { flag: String? }): Buffer
	fun writeFile(filename: String, data: Any, callback: ((err: ErrnoException) -> Unit)?): Unit
	//fun writeFile(filename: String, data: Any, options: { encoding: String? mode: Int? flag: String? }, callback?: (err: ErrnoException) -> Unit): Unit
	//fun writeFile(filename: String, data: Any, options: { encoding: String? mode: String? flag: String? }, callback?: (err: ErrnoException) -> Unit): Unit
	//fun writeFileSync(filename: String, data: Any, options?: { encoding: String? mode: Int? flag: String? }): Unit
	//fun writeFileSync(filename: String, data: Any, options?: { encoding: String? mode: String? flag: String? }): Unit
	//fun appendFile(filename: String, data: Any, options: { encoding: String? mode: Int? flag: String? }, callback?: (err: ErrnoException) -> Unit): Unit
	//fun appendFile(filename: String, data: Any, options: { encoding: String? mode: String? flag: String? }, callback?: (err: ErrnoException) -> Unit): Unit
	fun appendFile(filename: String, data: Any, callback: ((err: ErrnoException) -> Unit)?): Unit
	//fun appendFileSync(filename: String, data: Any, options?: { encoding: String? mode: Int? flag: String? }): Unit
	//fun appendFileSync(filename: String, data: Any, options?: { encoding: String? mode: String? flag: String? }): Unit
	fun watchFile(filename: String, listener: (curr: Stats, prev: Stats) -> Unit): Unit
	//fun watchFile(filename: String, options: { persistent?: Boolean interval: Int? }, listener: (curr: Stats, prev: Stats) -> Unit): Unit
	//fun unwatchFile(filename: String, listener?: (curr: Stats, prev: Stats) -> Unit): Unit
	//fun watch(filename: String, listener?: (event: String, filename: String) -> Any): FSWatcher
	//fun watch(filename: String, options: { persistent?: Boolean }, listener?: (event: String, filename: String) -> Any): FSWatcher
	//fun exists(path: String, callback?: (exists: Boolean) -> Unit): Unit
	fun existsSync(path: String): Boolean
	fun access(path: String, callback: (err: ErrnoException) -> Unit): Unit
	fun access(path: String, mode: Int, callback: (err: ErrnoException) -> Unit): Unit
	val F_OK: Int
	val R_OK: Int
	val W_OK: Int
	val X_OK: Int

	fun accessSync(path: String, mode : Int?): Unit
	/*
	fun createReadStream(path: String, options?: {
		flags: String?
		encoding: String?
		fd: Int?
		mode: Int?
		autoClose?: Boolean
	}): ReadStream
	fun createWriteStream(path: String, options?: {
		flags: String?
		encoding: String?
		fd: Int?
		mode: Int?
	}): WriteStream
	*/
}
