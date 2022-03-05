package com.buaja.abstraction.di

import javax.inject.Qualifier


/**
 * @created 05/03/22 14.28
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainDispatcher