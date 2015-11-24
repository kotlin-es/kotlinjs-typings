import kotlin.reflect.KClass

@native("Phaser.Game") class PhaserGame(val width: Int, val height: Int, val auto: String, id: String) {
	@native val state: PhaserState = noImpl
	@native val load: PhaserLoad = noImpl
	@native val add: PhaserAdd = noImpl
	@native val physics: PhaserPhysics = noImpl
	@native val input: PhaserInput = noImpl

	@native fun add() {

	}
}

interface AssertName

data class Assert(@native val name: AssertName, @native val url: String) {
	constructor(name: String, url: String) : this(name as AssertName, url)
}

/*
interface {

}
*/

interface GameStateType {
	val name: String
}

open class GameState(game: PhaserGame) {
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
	@native fun add(state: GameStateType, clazz: (game: PhaserGame) -> GameState)
	@native fun start(state: GameStateType)
}

@native interface PhaserLoad {
	@native fun image(name: AssertName, url: String)
}

@native interface PhaserAdd {
	@native fun sprite(x: Number, y: Number, name: AssertName): PhaserSprite
}

@native interface Point {
	@native val x: Double
	@native val y: Double

	@native fun set(x: Number): Unit = noImpl
	@native fun set(x: Number, y: Number): Unit = noImpl
}

@native interface PhaserSprite {
	@native var angle: Double
	@native var position: Point
	@native var anchor: Point
	@native var rotation: Double
}

fun PhaserLoad.image(assert: Assert) = this.image(assert.name, assert.url)

@native val PhaserSprite.body: PhaserPhysics.Body get() = noImpl

@native("Phaser.Physics") class PhaserPhysics {
	@native enum class Type

	companion object {
		@native val ARCADE: Type = noImpl
	}

	@native val arcade: PhaserArcade = noImpl
	@native fun startSystem(type: Type)
	@native fun enable(sprite: PhaserSprite, type: Type)

	@native interface Body {
		var drag: Point
		var maxVelocity: Point
		var angularVelocity: Double
		var acceleration: Point
	}
}

@native interface PhaserArcade {
	@native fun accelerationFromRotation(rotation: Double, acceleration: Double, vector: Point)
}

@native class PhaserInput {
	@native val keyboard: PhaserKeyboard = noImpl
}

@native interface PhaserKey {

}

@native interface PhaserKeyInfo {
	@native val isDown: Boolean
}

@native("Phaser.Keyboard") class PhaserKeyboard {
	companion object {
		@native val LEFT: PhaserKey
		@native val RIGHT: PhaserKey
		@native val UP: PhaserKey
		@native val DOWN: PhaserKey
	}

	@native fun addKey(key: PhaserKey): PhaserKeyInfo
}

/*
var game = new Phaser.Game(gameProperties.screenWidth, gameProperties.screenHeight, Phaser.AUTO, 'gameDiv');
game.state.add(states.game, gameState);
game.state.start(states.game);
*/
