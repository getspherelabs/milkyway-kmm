package io.spherelabs.cosmo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform