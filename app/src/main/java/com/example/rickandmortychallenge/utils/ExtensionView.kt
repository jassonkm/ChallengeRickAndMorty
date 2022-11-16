package com.example.rickandmortychallenge.utils

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.endless(visibleThreshold: Int = 10, loadMore: () -> Unit) {
    this.addOnScrollListener(HandlerEndlessScroll(this, visibleThreshold, loadMore))
}