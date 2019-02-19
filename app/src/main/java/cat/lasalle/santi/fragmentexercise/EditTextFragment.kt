package cat.lasalle.santi.fragmentexercise


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_edit_text.*

/**
 * A simple [Fragment] subclass.
 *
 */
class EditTextFragment : Fragment() {

    interface OnButtonPressedListener {
        fun onButtonPressed(text: String)
    }

    lateinit var listener: OnButtonPressedListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_text, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        press_me.setOnClickListener {
            listener.onButtonPressed(edit_text_text.text.toString())
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = activity as OnButtonPressedListener
    }
}
