package cat.lasalle.santi.fragmentexercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), EditTextFragment.OnButtonPressedListener {
    override fun onButtonPressed(text: String) {
        if (isLargeScreen()) {
            val textViewFragment = supportFragmentManager.findFragmentByTag("textViewFragment") as TextViewFragment?
            textViewFragment?.updateText(text)
        } else {
            val f = TextViewFragment.newInstance(text)
            supportFragmentManager.beginTransaction().replace(R.id.main_container, f).addToBackStack(null).commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(isLargeScreen()) {
            val editTextFragment = EditTextFragment()
            val textViewFragment = TextViewFragment.newInstance()
            supportFragmentManager.beginTransaction().
                add(R.id.view_editText, editTextFragment).
                add(R.id.view_textView, textViewFragment, "textViewFragment").
                commit()
        } else {
            val editTextFragment = EditTextFragment()
            supportFragmentManager.beginTransaction().
                add(R.id.main_container, editTextFragment).
                commit()
        }
    }

    private fun isLargeScreen(): Boolean {
        return resources.getBoolean(R.bool.large)
    }
}
