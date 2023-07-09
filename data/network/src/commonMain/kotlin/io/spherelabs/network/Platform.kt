package io.spherelabs.network

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform