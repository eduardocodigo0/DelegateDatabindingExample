package com.eduardocodigo0.delegatedatabindingexample

import android.view.LayoutInflater
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class DataBindingUserImpl<T>(
    override val inflater: (layoutInflater: LayoutInflater) -> T
) : DataBindingUser<T>,
    LifecycleEventObserver {
    private var _binding: T? = null

    override fun inflateViewBinding(layoutInflater: LayoutInflater,  lifecycleOwner: LifecycleOwner) {
        _binding = inflater.invoke(layoutInflater)
        lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun getBind(): T = _binding!!

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_DESTROY -> {
                _binding = null
            }
            else -> {}
        }
    }
}