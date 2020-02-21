package io.rob.keather

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

internal class Scope(private val context: CoroutineContext = MainDispatcher()) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = context + job

    internal val job = SupervisorJob()
}