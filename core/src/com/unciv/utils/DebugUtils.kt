package com.unciv.utils

object DebugUtils {

    /**
     * This exists so that when debugging we can see the entire map.
     * Remember to turn this to false before commit and upload!
     * Or use the "secret" debug page of the options popup instead.
     */
    var VISIBLE_MAP: Boolean = false

    /** This flag paints the tile coordinates directly onto the map tiles. */
    var SHOW_TILE_COORDS: Boolean = false

    /** For when you need to test something in an advanced game and don't have time to faff around */
    var SUPERCHARGED: Boolean = false

    /** Simulate until this turn on the first "Next turn" button press.
     *  Does not update World View changes until finished.
     *  Set to 0 to disable.
     */
    var SIMULATE_UNTIL_TURN: Int = 0

    /** Set it to true only when SIMULATE_UNTIL_TURN > 1 */
    var SIMULATEING: Boolean = false

    /** Use the AI module via http request, set false when build jar for simulator */
    var NEED_POST: Boolean = true

    /** Pass gameinfo with each interface request. Enabling this would increase processing time */
    var NEED_GAMEINFO: Boolean = false

    /** Disregard this option. Set it to true. */
    var ACTIVE_DIPLOMACY: Boolean = true

    var AI_SERVER_ADDRESS: String = "http://127.0.0.1:2337/"

    var LLM_API_KEY: String = ""

    var LLM_MODEL: String = ""

    fun initialize(args: Array<String>) {
        if (args.isEmpty()) return
        for (arg in args) {
            val (key, value) = arg.split("=")
            if (key == "NEED_POST") {
                NEED_POST = value.toBoolean()
            } else if (key == "NEED_GAMEINFO") {
                NEED_GAMEINFO = value.toBoolean()
            } else if (key == "ACTIVE_DIPLOMACY") {
                ACTIVE_DIPLOMACY = value.toBoolean()
            } else if (key == "AI_SERVER_ADDRESS") {
                AI_SERVER_ADDRESS = value
            } else if (key == "SIMULATE_UNTIL_TURN") {
                SIMULATE_UNTIL_TURN = value.toInt()
            } else if (key == "SIMULATEING") {
                SIMULATEING = value.toBoolean()
            } else if (key == "SUPERCHARGED") {
                SUPERCHARGED = value.toBoolean()
            } else if (key == "SHOW_TILE_COORDS") {
                SHOW_TILE_COORDS = value.toBoolean()
            } else if (key == "VISIBLE_MAP") {
                VISIBLE_MAP = value.toBoolean()
            } else if (key == "LLM_API_KEY") {
                LLM_API_KEY = value
            } else if (key == "LLM_MODEL") {
                LLM_MODEL = value
            }
        }
    }
}
