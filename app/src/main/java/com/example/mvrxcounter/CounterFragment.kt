package com.example.mvrxcounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import kotlinx.android.synthetic.main.fragment_counter.*

class CounterFragment : BaseMvRxFragment() {

    private val viewModel: CounterViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        increment.setOnClickListener {
            viewModel.incrementCount()
        }

        decrement.setOnClickListener {
            viewModel.decrementCount()
        }
    }

    override fun invalidate() = withState(viewModel) { state ->
        countTextView.text = state.count.toString()
    }
}