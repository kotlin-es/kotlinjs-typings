package Phaser

import org.w3c.dom.events.Event
import kotlin.reflect.KClass

@native("Phaser.Game") class Game(val width: Double, val height: Double, val auto: String, id: String) {
	@native val state: PhaserState = noImpl
	@native val load: Loader = noImpl
	@native val add: PhaserGameObjectFactory = noImpl
	@native val physics: Physics = noImpl
	@native val input: Input = noImpl

	@native fun add() {

	}
}

@native("Phaser.Keyboard") class Keyboard {
	companion object {
		@native val LEFT: PhaserKey = noImpl
		@native val RIGHT: PhaserKey = noImpl
		@native val UP: PhaserKey = noImpl
		@native val DOWN: PhaserKey = noImpl
	}

	@native fun addKey(key: PhaserKey): Key
}

@native("Phaser.Key") class Key(@native val game: Phaser.Game, @native val keyCode: Int) {
	@native val altKey: Boolean = noImpl
	@native val ctrlKey: Boolean = noImpl
	@native val shiftKey: Boolean = noImpl

	@native fun downDuration(duration: Double): Boolean = noImpl
	@native fun upDuration(duration: Double): Boolean = noImpl
	@native fun reset(hard: Boolean = true) = noImpl

	@native val timeDown: Double = noImpl
	@native val timeUp: Double = noImpl
	@native val duration: Double = noImpl
	@native val repeats: Int = noImpl
	@native val event: Event = noImpl
	@native val isDown: Boolean = noImpl
	@native val isUp: Boolean = noImpl
	@native val onDown: Signal<Boolean> = noImpl
	@native val onUp: Signal<Boolean> = noImpl
	@native var onHoldCallback: () -> Unit = noImpl
	@native var onHoldContext: Any = noImpl
}


interface AssetName

data class Asset(@native val name: AssetName, @native val url: String) {
	constructor(name: String, url: String) : this(name as AssetName, url)
}

/*
interface {
}
*/

interface GameStateType

fun GameStateType(name: String): GameStateType = name as GameStateType

open class GameState(game: Phaser.Game) {
	@native open fun preload() {
	}

	@native open fun create() {
	}

	@native open fun update() {
	}

	@native open fun render() {
	}
}

@native interface PhaserState {
	@native fun add(state: GameStateType, clazz: (game: Phaser.Game) -> GameState)
	@native fun start(state: GameStateType)
}

@native("Phaser.Cache") class Cache(val game: Phaser.Game) {
	companion object {
		@native val BINARY: Int = noImpl
		@native val BITMAPDATA: Int = noImpl
		@native val BITMAPFONT: Int = noImpl
		@native val CANVAS: Int = noImpl
		@native val IMAGE: Int = noImpl
		@native val JSON: Int = noImpl
		@native val PHYSICS: Int = noImpl
		@native val RENDER_TEXTURE: Int = noImpl
		@native val SHADER: Int = noImpl
		@native val SOUND: Int = noImpl
		@native val TEXT: Int = noImpl
		@native val TEXTURE: Int = noImpl
		@native val TILEMAP: Int = noImpl
		@native val VIDEO: Int = noImpl
		@native val XML: Int = noImpl
	}

	@native var autoResolveURL: Boolean = noImpl
	@native var onSoundUnlock: Signal<Any> = noImpl

	fun addBinary(key: String, binaryData: Any): Unit = noImpl
	// ...
	// ...
}

@native("Phaser.Loader") class Loader(val game: Phaser.Game) {
	@native fun image(name: AssetName, url: String)
	@native val hasLoaded: Boolean = noImpl
	@native val isLoading: Boolean = noImpl
	@native val onFileComplete: Signal<Any> = noImpl
}

@native("Phaser.World") class World {

}

@native("Phaser.Group") class Group {

}

@native("Phaser.GameObjectFactory") class PhaserGameObjectFactory(val game: Phaser.Game) {
	@native val world: World = noImpl
	@native fun sprite(x: Number, y: Number, key: AssetName): Sprite = noImpl
	@native fun text(x: Number, y: Number, text: String): Text
	@native fun text(x: Number, y: Number, text: String, style: TextStyle): Text

}

@native("Phaser.Point") class Point(@native var x: Double, @native var y: Double) {
	@native fun set(x: Number): Unit = noImpl
	@native fun set(x: Number, y: Number): Unit = noImpl
}

@native interface TextStyle {
	var font: String
	var fontStyle: String
	var fontVariant: String
	var fontWeight: Int
	var fontSize: String
	var backgroundColor: String
	var fill: String
	var align: String
	var boundsAlignH: String
	var boundsAlignV: String
	var stroke: String
	var strokeThickness: Number
	var wordWrap: Boolean
	var wordWrapWidth: Int
	var tabs: Int
}

fun TextStyle(
	font: String? = null, // "bold 20pt Arial"
	fontStyle: String? = null, // (from font)
	fontVariant: String? = null, // (from font)
	fontWeight: Int? = null, // (from font)
	fontSize: String? = null, // (from font)
	backgroundColor: String? = null,
	fill: String? = null, // 'black'
	align: String? = null, // 'left'
	boundsAlignH: String? = null, //
	boundsAlignV: String? = null, //
	stroke: String? = null, // 'black'
	strokeThickness: Number? = null, // 0
	wordWrap: Boolean? = null, // false
	wordWrapWidth: Int? = null, // 100
	tabs: Int? = null // 0
): TextStyle {
	var out = js("({})")
	if (font != null) out.font = font
	if (fontStyle != null) out.fontStyle = fontStyle
	if (fontVariant != null) out.fontVariant = fontVariant
	if (fontWeight != null) out.fontWeight = fontWeight
	if (fontSize != null) out.fontSize = fontSize
	if (backgroundColor != null) out.backgroundColor = backgroundColor
	if (fill != null) out.fill = fill
	if (align != null) out.align = align
	if (boundsAlignH != null) out.boundsAlignH = boundsAlignH
	if (boundsAlignV != null) out.boundsAlignV = boundsAlignV
	if (stroke != null) out.stroke = stroke
	if (strokeThickness != null) out.strokeThickness = strokeThickness
	if (wordWrap != null) out.wordWrap = wordWrap
	if (wordWrapWidth != null) out.wordWrapWidth = wordWrapWidth
	if (tabs != null) out.tabs = tabs
	return out
}

@native("Phaser.Text") class Text(@native val game: Game, x: Double, y: Double, text: String, style: TextStyle? = null) {

}


@native("Phaser.Sprite") class Sprite(@native val game: Game) {
	@native var key: Any?
	@native var frame: Any?
	@native var x: Double
	@native var y: Double
	@native var angle: Double
	@native var position: Point
	@native var anchor: Point
	@native var rotation: Double
}

fun Loader.image(asset: Asset) = this.image(asset.name, asset.url)
fun Loader.image(vararg assets: Asset) = assets.forEach { image(it.name, it.url) }

@native("body") val Sprite.body: Physics.Arcade.Body get() = noImpl
@native("body") val Sprite.arcadeBody: Physics.Arcade.Body get() = noImpl

interface DirectionObj {
	var up: Boolean
	var down: Boolean
	var left: Boolean
	var right: Boolean
}

@native("Phaser.Physics") class Physics {
	@native enum class Type

	companion object {
		@native val ARCADE: Type = noImpl
	}

	@native val arcade: Arcade = noImpl
	@native fun startSystem(type: Type)
	@native fun enable(sprite: Sprite, type: Type)

	@native("Phaser.Physics.Arcade") class Arcade {
		@native fun accelerationFromRotation(rotation: Double, acceleration: Double, vector: Point)

		@native("Phaser.Physics.Arcade.Body") class Body(@native val sprite: Sprite) {
			@native var acceleration: Point = noImpl
			@native var allowGravity: Boolean = noImpl
			@native var allowRotation: Boolean = noImpl
			@native var angle: Double = noImpl
			@native var angularAcceleration: Double = noImpl
			@native var angularDrag: Double = noImpl
			@native var angularVelocity: Double = noImpl
			@native var blocked: DirectionObj = noImpl
			@native var bottom: Double = noImpl
			@native var bounce: Point = noImpl
			@native var center: Point = noImpl
			@native var checkCollision: DirectionObj = noImpl
			@native var collideWorldBounds: Boolean = noImpl
			@native var customSeparateX: Boolean = noImpl
			@native var customSeparateY: Boolean = noImpl
			@native var deltaMax: Point = noImpl
			@native var dirty: Boolean = noImpl
			@native var drag: Point = noImpl
			@native var embedded: Boolean = noImpl
			@native var enable: Boolean = noImpl
			@native var facing: Double = noImpl
			@native var friction: Point = noImpl
			@native val game: Game = noImpl
			@native var gravity: Point = noImpl
			@native val halfHeight: Double = noImpl
			@native val halfWidth: Double = noImpl
			@native val height: Double = noImpl
			@native var immovable: Boolean = noImpl
			@native var mass: Double = noImpl
			@native var maxAngular: Double = noImpl
			@native var maxVelocity: Point = noImpl
			@native var moves: Boolean = noImpl
			@native val newVelocity: Point = noImpl
			@native var offset: Point = noImpl
			@native var overlapX: Point = noImpl
			@native var overlapY: Point = noImpl
			@native val position: Point = noImpl
			@native val preRotation: Double = noImpl
			@native val prev: Point = noImpl
			@native val right: Double = noImpl
			@native var rotation: Double = noImpl
			@native var skipQuadTree: Boolean = noImpl
			@native val sourceHeight: Double = noImpl
			@native val sourceWidth: Double = noImpl
			@native val speed: Double = noImpl
			@native var syncBounds: Boolean = noImpl
			@native var tilePadding: Point = noImpl
			@native var touching: DirectionObj = noImpl
			@native var type: Int = noImpl
			@native var velocity: Point = noImpl
			@native var wasTouching: DirectionObj = noImpl
			@native val width: Double = noImpl
			@native var x: Double = noImpl
			@native var y: Double = noImpl

			@native fun deltaAbsX(): Double = noImpl
			@native fun deltaAbsY(): Double = noImpl
			@native fun deltaX(): Double = noImpl
			@native fun deltaY(): Double = noImpl
			@native fun deltaZ(): Double = noImpl
			@native fun destroy(): Unit = noImpl
			@native fun hitTest(x: Number, y: Number): Boolean = noImpl
			@native fun onFloor(): Boolean = noImpl
			@native fun onWall(): Boolean = noImpl
			@native fun render(context: Any, body: Body, color: String, filled: Boolean): Unit = noImpl
			@native fun renderBodyInfo(body: Body, x: Number, y: Number, color: String): Unit = noImpl
			@native fun reset(x: Number, y: Number): Unit = noImpl
			@native fun setSize(width: Number, height: Number): Unit = noImpl
			@native fun setSize(width: Number, height: Number, offsetX: Number, offsetY: Number): Unit = noImpl
		}
	}
}

@native("Phaser.Math") object PhaserMath {
	//@native fun <T : Number> difference(a: T, b: T): T = noImpl
	@native val PI2: Double = noImpl

	@native fun angleBetween(x1: Number, y1: Number, x2: Number, y2: Number): Double = noImpl
	@native fun angleBetweenY(x1: Number, y1: Number, x2: Number, y2: Number): Double = noImpl
	@native fun angleBetweenPoints(point1: Point, point2: Point): Double = noImpl
	@native fun angleBetweenPointsY(point1: Point, point2: Point): Double = noImpl
	@native fun average(vararg n: Number): Double = noImpl
	@native fun bernstein(n: Number, i: Number): Double = noImpl
	@native fun bezierInterpolation(v: Array<Number>, k: Number): Double = noImpl
	@native fun catmullRom(p0: Number, p1: Number, p2: Number, p3: Number, t: Number): Double = noImpl
	@native fun catmullRomInterpolation(v: Array<Number>, k: Number): Double = noImpl
	@native fun ceilTo(value: Number, place: Number, base: Number): Double = noImpl
	@native fun chanceRoll(chance: Number): Boolean = noImpl
	@native fun clamp(x: Number, a: Number, b: Number): Double = noImpl
	@native fun clampBottom(x: Number, a: Number): Double = noImpl
	@native fun degToRad(degrees: Number): Double = noImpl
	@native fun difference(a: Number, b: Number): Double = noImpl
	@native fun distance(x1: Number, y1: Number, x2: Number, y2: Number): Double = noImpl
	@native fun distancePow(x1: Number, y1: Number, x2: Number, y2: Number, pow: Number = 2.0): Double = noImpl
	@native fun distanceSq(x1: Number, y1: Number, x2: Number, y2: Number): Double = noImpl
	@native fun factorial(value: Number): Double = noImpl
	@native fun floorTo(value: Number, place: Number, base: Number): Double = noImpl
	@native fun fuzzyCeil(`val`: Number, epsilon: Number = 0.0001): Double = noImpl
	@native fun fuzzyEqual(a: Number, b: Number, epsilon: Number = 0.0001): Boolean = noImpl
	@native fun fuzzyFloor(`val`: Number, epsilon: Number = 0.0001): Double = noImpl
	@native fun fuzzyGreaterThan(a: Number, b: Number, epsilon: Number = 0.0001): Boolean = noImpl


}

@native("Phaser.Input") class Input(@native val game: Game) {
	@native val keyboard: Phaser.Keyboard = noImpl
}

@native interface PhaserKey {

}

@native("Phaser.SignalBinding") class SignalBinding<T>() {
	@native fun detach(): ((T) -> Unit)? = noImpl
	@native fun execute(arg: T): Any = noImpl
	@native fun getListener(): (T) -> Unit = noImpl
	@native fun getSignal(): Signal<T> = noImpl
	@native fun isBound(): Boolean = noImpl
	@native fun isOnce(): Boolean = noImpl
}

@native("Phaser.Signal") class Signal<T>() {
	@native var active: Boolean = noImpl
	@native var memorize: Boolean = noImpl
	@native fun add(listener: (T) -> Unit, listenerContext: Any, priority: Int, args: Array<Any>): SignalBinding<T> = noImpl
	@native fun addOnce(listener: (T) -> Unit, listenerContext: Any, priority: Int, args: Array<Any>): SignalBinding<T> = noImpl
	@native fun remove(listener: (T) -> Unit, context: Any): (T) -> Unit = noImpl
	@native fun removeAll(context: Any): (T) -> Unit = noImpl
	@native fun dispatch(value: T): Unit = noImpl
	@native fun dispose(): Unit = noImpl
	@native fun forget(): Unit = noImpl
	@native fun getNumListeners(): Int = noImpl
	@native fun halt(): Unit = noImpl
	@native fun has(listener: (T) -> Unit, context: Any): Boolean = noImpl
}



/*
var game = new Phaser.Game(gameProperties.screenWidth, gameProperties.screenHeight, Phaser.AUTO, 'gameDiv');
game.state.add(states.game, gameState);
game.state.start(states.game);
*/
