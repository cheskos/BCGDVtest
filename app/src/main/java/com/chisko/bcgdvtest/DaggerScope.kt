package com.chisko.bcgdvtest

import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
annotation class DaggerScope(val value: KClass<*>)
