package cat.lasalle.santi.fragmentexercise


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_text_view.*

private const val TEXT = "text"

/**
 * A simple [Fragment] subclass.
 *
 */
class TextViewFragment : Fragment() {
    private lateinit var text: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(TEXT)?:""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        text_view_text.text = text
    }

    fun updateText(text: String) {
        text_view_text.text = text
    }

    companion object {
        @JvmStatic
        fun newInstance(text: String = "") =
            TextViewFragment().apply {
                arguments = Bundle().apply {
                    putString(TEXT, text)
                }
            }
    }
}
