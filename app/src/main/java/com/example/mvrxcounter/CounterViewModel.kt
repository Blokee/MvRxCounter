package com.example.mvrxcounter

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

data class CounterViewState(
    val count: Int = 0
): MvRxState

class CounterViewModel(initialState: CounterViewState): BaseMvRxViewModel<CounterViewState>(initialState, debugMode = true) {
    fun incrementCount() = setState { copy(count = count + 1) }
    fun decrementCount() = setState { copy(count = count - 1) }
}