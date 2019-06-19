package ru.romananchugov.vkmessenger

import android.os.Bundle
import ru.romananchugov.vkmessenger.base_classes.BaseActivity


class  MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
