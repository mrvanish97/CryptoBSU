package com.uonagent.cryptobsu.utils

open class SingletonHolder<out T, in A>(private var creator: (A) -> T) {

    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        return instance ?: synchronized(this) {
            val i = instance
            if (i != null) {
                i
            } else {
                val created = creator(arg)
                instance = created
                created
            }
        }
    }
}