@native interface ReadableStream : EventEmitter {
	val readable: Boolean
	fun read(size: Int?): Any // Any = String|Buffer
	fun setEncoding(encoding: String): Unit
	fun pause(): Unit
	fun resume(): Unit
	/*
	fun <T : WritableStream> pipe(destination: T, options?: {
		end ?: boolean
	}): T
	*/
	fun <T : WritableStream> unpipe(destination: T?): Unit

	fun unshift(chunk: String): Unit
	fun unshift(chunk: Buffer): Unit
	fun wrap(oldStream: ReadableStream): ReadableStream
}

@native interface WritableStream : EventEmitter {
	val writable: Boolean
	fun write(buffer: Buffer, cb: (() -> Unit)?): Boolean
	fun write(buffer: String, cb: (() -> Unit)?): Boolean
	fun write(str: String, encoding: String?, cb: (() -> Unit)?): Boolean
	fun end(): Unit
	fun end(buffer: Buffer, cb: (() -> Unit)?): Unit
	fun end(str: String, cb: (() -> Unit)?): Unit
	fun end(str: String, encoding: String?, cb: (() -> Unit)?): Unit
}

@native interface ReadWriteStream : ReadableStream, WritableStream

@native class Buffer {
	constructor(str: String, encoding: String?)

	constructor(size: Int)

	//constructor(array: Uint8Array)

	constructor(array: Array<Any>)

	val prototype: Buffer

	companion object {
		fun isBuffer(obj: Any): Boolean
		fun isEncoding(encoding: String): Boolean
		fun byteLength(string: String, encoding: String?): Int
		fun concat(list: Array<Buffer>, totalLength: Int?): Buffer
		fun compare(buf1: Buffer, buf2: Buffer): Int
	}

	operator fun get(index: Int): Int
	fun write(string: String, offset: Int?, length: Int?, encoding: String?): Int
	fun toString(encoding: String?, start: Int?, end: Int?): String
	fun toJSON(): Any
	val length: Int
	fun equals(otherBuffer: Buffer): Boolean
	fun compare(otherBuffer: Buffer): Int
	fun copy(targetBuffer: Buffer, targetStart: Int?, sourceStart: Int?, sourceEnd: Int?): Int
	fun slice(start: Int?, end: Int?): Buffer
	fun writeUIntLE(value: Int, offset: Int, byteLength: Int, noAssert: Boolean?): Int
	fun writeUIntBE(value: Int, offset: Int, byteLength: Int, noAssert: Boolean?): Int
	fun writeIntLE(value: Int, offset: Int, byteLength: Int, noAssert: Boolean?): Int
	fun writeIntBE(value: Int, offset: Int, byteLength: Int, noAssert: Boolean?): Int
	fun readUIntLE(offset: Int, byteLength: Int, noAssert: Boolean?): Int
	fun readUIntBE(offset: Int, byteLength: Int, noAssert: Boolean?): Int
	fun readIntLE(offset: Int, byteLength: Int, noAssert: Boolean?): Int
	fun readIntBE(offset: Int, byteLength: Int, noAssert: Boolean?): Int
	fun readUInt8(offset: Int, noAssert: Boolean?): Int
	fun readUInt16LE(offset: Int, noAssert: Boolean?): Int
	fun readUInt16BE(offset: Int, noAssert: Boolean?): Int
	fun readUInt32LE(offset: Int, noAssert: Boolean?): Int
	fun readUInt32BE(offset: Int, noAssert: Boolean?): Int
	fun readInt8(offset: Int, noAssert: Boolean?): Int
	fun readInt16LE(offset: Int, noAssert: Boolean?): Int
	fun readInt16BE(offset: Int, noAssert: Boolean?): Int
	fun readInt32LE(offset: Int, noAssert: Boolean?): Int
	fun readInt32BE(offset: Int, noAssert: Boolean?): Int
	fun readFloatLE(offset: Int, noAssert: Boolean?): Int
	fun readFloatBE(offset: Int, noAssert: Boolean?): Int
	fun readDoubleLE(offset: Int, noAssert: Boolean?): Int
	fun readDoubleBE(offset: Int, noAssert: Boolean?): Int
	fun writeUInt8(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeUInt16LE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeUInt16BE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeUInt32LE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeUInt32BE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeInt8(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeInt16LE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeInt16BE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeInt32LE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeInt32BE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeFloatLE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeFloatBE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeDoubleLE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun writeDoubleBE(value: Int, offset: Int, noAssert: Boolean?): Int
	fun fill(value: Any, offset: Int?, end: Int?): Buffer
}

@native("require('stream')") object stream {
	/*
	class Readable : EventEmitter, ReadableStream {
		val readable: Boolean
		constructor(opts?: ReadableOptions);
		_read(size: number): void;
		read(size?: number): any;
		setEncoding(encoding: string): void;
		pause(): void;
		resume(): void;
		pipe<T extends NodeJS.WritableStream>(destination: T, options?: { end?: boolean; }): T;
		unpipe<T extends NodeJS.WritableStream>(destination?: T): void;
		unshift(chunk: any): void;
		wrap(oldStream: NodeJS.ReadableStream): NodeJS.ReadableStream;
		push(chunk: any, encoding?: string): boolean;
	}
	*/
}