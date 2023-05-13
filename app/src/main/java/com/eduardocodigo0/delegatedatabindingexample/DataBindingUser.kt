package com.eduardocodigo0.delegatedatabindingexample

import android.view.LayoutInflater
import androidx.lifecycle.LifecycleOwner

interface DataBindingUser<T> {
    val inflater: (layoutInflater: LayoutInflater) -> T
    fun inflateViewBinding(layoutInflater: LayoutInflater, lifecycleOwner: LifecycleOwner)
    fun getBind(): T
}