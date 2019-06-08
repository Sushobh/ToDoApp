package org.sushobh.exampleapp.Base
import androidx.fragment.app.Fragment
open class BaseFragment<T : BaseViewModel<*>> : Fragment() {

    lateinit var viewModel : T


    override fun onResume() {
        viewModel?.onResume()
        super.onResume()
    }

    override fun onPause() {
        viewModel?.onPause()
        super.onPause()
    }

}