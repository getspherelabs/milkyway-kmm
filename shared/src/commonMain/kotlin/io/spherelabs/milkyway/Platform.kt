package io.spherelabs.milkyway

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform