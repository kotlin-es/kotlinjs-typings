@native interface Error {

}

@native interface ErrnoException : Error {
	val errno: Int?
	val code: String?
	val path: String?
	val syscall: String?
	val stack: String?
}