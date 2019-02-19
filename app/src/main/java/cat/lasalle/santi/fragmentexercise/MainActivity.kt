package cat.lasalle.santi.fragmentexercise

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), EditTextFragment.OnButtonPressedListener {
    override fun onButtonPressed(text: String) {
        val f = TextViewFragment.newInstance(text)
        supportFragmentManager.beginTransaction().
                replace(R.id.main_container, f).
                addToBackStack(null).
                commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val f = EditTextFragment()
        supportFragmentManager.beginTransaction().
            add(R.id.main_container, f).
            commit()
    }
}
