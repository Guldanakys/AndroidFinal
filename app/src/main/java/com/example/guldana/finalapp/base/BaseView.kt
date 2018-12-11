package com.example.guldana.finalapp.base

interface BaseView<out P : BasePresenter<*>> {
    val presenter: P
}