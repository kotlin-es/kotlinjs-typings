import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event

@native interface Point {
	var x: Double
	var y: Double
	@native fun set(x: Double, y: Double): Unit
}

@native open class DisplayObject() {
	val anchor: Point = noImpl
	val position: Point = noImpl
	val scale: Point = noImpl
	var rotation: Double = noImpl
	var interactive: Boolean = noImpl

	var x: Double = noImpl
	var y: Double = noImpl

	fun addChild(child: DisplayObject): Unit = noImpl
	fun on(event: String, handler: (e: Event) -> Unit)
}

fun DisplayObject.onClick(handler: () -> Unit) {
	this.interactive = true
	this.on("mousedown") {
		handler()
	}
}

@native("PIXI.Sprite") class Sprite(val texture: Texture) : DisplayObject() {
	companion object {
		@native fun fromImage(url: String): Sprite = noImpl
	}
}

@native("PIXI.Text") class Text(val text: String) : DisplayObject() {
	@native constructor(text: String, style: TextStyle) : this(text)

}

@native interface TextStyle

fun TextStyle(
	font: String? = null,
	fill: String? = null,
	stroke: String? = null,
	strokeThickness: Int? = null,
	dropShadow: Boolean? = null,
	dropShadowColor: String? = null,
	dropShadowAngle: Double? = null,
	dropShadowDistance: Int? = null,
	wordWrap: Boolean? = null,
	wordWrapWidth: Int? = null
): TextStyle {
	var out: dynamic = js("({})")
	if (font != null) out["font"] = font
	if (fill != null) out["fill"] = fill
	if (stroke != null) out["stroke"] = stroke
	if (strokeThickness != null) out["strokeThickness"] = strokeThickness
	if (dropShadow != null) out["dropShadow"] = dropShadow
	if (dropShadowColor != null) out["dropShadowColor"] = dropShadowColor
	if (dropShadowAngle != null) out["dropShadowAngle"] = dropShadowAngle
	if (dropShadowDistance != null) out["dropShadowDistance"] = dropShadowDistance
	if (wordWrap != null) out["wordWrap"] = wordWrap
	if (wordWrapWidth != null) out["wordWrapWidth"] = wordWrapWidth
	return out
}


@native("PIXI.loader") val loader: Loader

interface Loader {
	@native fun add(path: String): Loader
	@native fun load(callback: () -> Unit): Loader
}

@native("PIXI.Texture") class Texture {
	companion object {
		@native fun fromImage(url: String): Texture = noImpl
	}
}

@native fun requestAnimationFrame(animate: (Double) -> Unit): Unit = noImpl

fun requestAnimationLooop(animate: (dt: Double) -> Unit) {
	var last: Double = 0.0
	fun frame(time: Double) {
		if (last == 0.0) last = time
		requestAnimationFrame { frame(it) }
		animate(time - last)
		last = time
	}
	frame(0.0)
}

@native interface RendererExtra

fun RendererExtra(backgroundColor: Int? = null): RendererExtra {
	var out: dynamic = js("({})")
	if (backgroundColor != null) out["backgroundColor"] = backgroundColor
	return out
}

@native("PIXI.autoDetectRenderer") fun autoDetectRenderer(width: Int, height: Int): Renderer = noImpl
@native("PIXI.autoDetectRenderer") fun autoDetectRenderer(width: Int, height: Int, extra: RendererExtra): Renderer = noImpl

@native open class Renderer {
	@native val view: HTMLElement = noImpl
	fun render(stage: Container) = noImpl
}

@native("PIXI.Container") class Container(color: Int) : DisplayObject()
@native("PIXI.Graphics") class Graphics() : DisplayObject() {
	fun beginFill(color: Int): Unit = noImpl
	fun lineStyle(a: Int, color: Int, b: Int): Unit = noImpl
	fun moveTo(x: Number, y: Number): Unit = noImpl
	fun lineTo(x: Number, y: Number): Unit = noImpl
	fun drawRect(x: Number, y: Number, width: Number, height: Number): Unit = noImpl
	fun drawRoundedRect(x: Number, y: Number, width: Number, height: Number, radius: Number): Unit = noImpl
	fun drawCircle(x: Number, y: Number, radius: Number): Unit = noImpl
	fun endFill(): Unit = noImpl
}

@native("PIXI.WebGLRenderer") class WebGLRenderer(width: Int, height: Int) : Renderer()
