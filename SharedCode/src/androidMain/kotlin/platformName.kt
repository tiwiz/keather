package io.rob.keather

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Runnable
import kotlin.coroutines.CoroutineContext

actual fun platformName(): String = "Android"

actual class MainDispatcher actual constructor() : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        Dispatchers.Main.dispatch(context, block)
    }
}